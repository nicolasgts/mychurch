package com.nicolas.gts.mychurch.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.nicolas.gts.mychurch.domain.Church;
import com.nicolas.gts.mychurch.repositories.ChurchRepository;
import com.nicolas.gts.mychurch.repositories.PostRepository;
import com.nicolas.gts.mychurch.services.exceptions.DataIntegrityException;
import com.nicolas.gts.mychurch.services.exceptions.ObjectNotFoundException;


@Service
public class ChurchService {
	
	@Autowired
	private ChurchRepository repo;

	public Church find(Integer id) {
		Optional<Church> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Church.class.getName()));
	}
	
	
	public List<Church> findAll(){
		return repo.findAll();
	}
	
	public Church insert(Church obj) {
		obj.setId(null);
		return repo.save(obj);
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
		newObj.setName(obj.getName());
		newObj.setDescription(obj.getDescription());
	}
	

}
