package com.nicolas.gts.mychurch.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nicolas.gts.mychurch.domain.User;
import com.nicolas.gts.mychurch.dto.ChurchDTO;
import com.nicolas.gts.mychurch.dto.UserDTO;
import com.nicolas.gts.mychurch.repositories.UserRepository;
import com.nicolas.gts.mychurch.services.exceptions.DataIntegrityException;
import com.nicolas.gts.mychurch.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	
	public User find(Integer id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + User.class.getName()));
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

}
