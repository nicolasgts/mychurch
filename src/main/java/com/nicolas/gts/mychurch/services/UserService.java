package com.nicolas.gts.mychurch.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nicolas.gts.mychurch.domain.User;
import com.nicolas.gts.mychurch.domain.enums.Profile;
import com.nicolas.gts.mychurch.dto.UserDTO;
import com.nicolas.gts.mychurch.dto.UserNewDTO;
import com.nicolas.gts.mychurch.repositories.UserRepository;
import com.nicolas.gts.mychurch.security.UserSS;
import com.nicolas.gts.mychurch.services.exceptions.AuthorizationException;
import com.nicolas.gts.mychurch.services.exceptions.DataIntegrityException;
import com.nicolas.gts.mychurch.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	
	public User find(Integer id) {
		
		
		
		UserSS user = UserServiceAuth.authenticated();
		if (user==null || !user.hasRole(Profile.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Access denied");
		}
		
		Optional<User> currentUser = repo.findById(user.getId());
		Optional<User> obj = repo.findById(id);
		
		if(obj.get().getChurch().getId() != currentUser.get().getChurch().getId()) {
			throw new AuthorizationException("Access denied");
		}
		

		obj.get().getChurch().getId();
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + User.class.getName()));
	}
	
	@Transactional
	public User insert(User obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	
	public User update(User obj) {
		User newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("It is not possible delete an User that has entities");
		}
	}
		
	
	private void updateData(User newObj, User obj) {
		newObj.setEmail(obj.getEmail());
	}
	
	
	public Page<User> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail(), null , null);
	}
	
	public User fromDTO(UserNewDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail(), pe.encode(objDto.getPassword()), objDto.getCpf(), objDto.getChurch());
	}


}
