package com.nicolas.gts.mychurch.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nicolas.gts.mychurch.domain.Adress;
import com.nicolas.gts.mychurch.domain.Church;
import com.nicolas.gts.mychurch.domain.City;
import com.nicolas.gts.mychurch.domain.User;
import com.nicolas.gts.mychurch.domain.enums.Profile;
import com.nicolas.gts.mychurch.dto.ChurchDTO;
import com.nicolas.gts.mychurch.dto.ChurchNewDTO;
import com.nicolas.gts.mychurch.repositories.AdressRepository;
import com.nicolas.gts.mychurch.repositories.ChurchRepository;
import com.nicolas.gts.mychurch.repositories.UserRepository;
import com.nicolas.gts.mychurch.services.exceptions.DataIntegrityException;
import com.nicolas.gts.mychurch.services.exceptions.ObjectNotFoundException;


@Service
public class ChurchService {
	
	@Autowired
	private ChurchRepository repo;
	
	@Autowired
	private UserRepository repoUser;
	
	@Autowired
	private AdressRepository repoAdress;

	public Church find(Integer id) {
		Optional<Church> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Church.class.getName()));
	}
	
	
	public List<Church> findAll(){
		return repo.findAll();
	}

	@Transactional
	public Church insert(Church obj) {
		obj.setId(null);
		obj = repo.save(obj);
		repoAdress.saveAll(obj.getAdresses());
		repoUser.saveAll(obj.getUsers());
		return obj;
	}
	
	public Church update(Church obj) {
		Church newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("It is not possible delete an church that has posts");
		}
	}
	
	
	private void updateData(Church newObj, Church obj) {
		if(obj.getName() != null) newObj.setName(obj.getName());
		if(obj.getDescription() != null) newObj.setDescription(obj.getDescription());
		if(obj.getCnpj() != null) newObj.setCnpj(obj.getCnpj());
	}
	
	
	public Page<Church> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Church fromDTO(ChurchDTO objDto) {
		return new Church(objDto.getId(), objDto.getCnpj(), objDto.getName(), objDto.getDescription());
	}
	
	public Church fromDTO(ChurchNewDTO objDto) {
		Church church = new  Church(null, objDto.getCnpj(), objDto.getName(), objDto.getDescription());
		City city = new City(objDto.getCity_id(), null, null);
		Adress ad = new Adress(null, objDto.getStreet(), objDto.getNumber(), objDto.getComplement(),objDto.getDistrict(), city, objDto.getZipcode(), church);
		User user = new User(null, objDto.getName_user(), objDto.getEmail_user(), objDto.getPassword(), objDto.getCpf_user(), church);
		user.addProfile(Profile.ADMIN);
		church.getAdresses().add(ad);
		church.getUsers().add(user);	
		
		return church;
		
	}

}
