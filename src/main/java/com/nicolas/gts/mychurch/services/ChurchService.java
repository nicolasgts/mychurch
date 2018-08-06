package com.nicolas.gts.mychurch.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolas.gts.mychurch.domain.Church;
import com.nicolas.gts.mychurch.repositories.ChurchRepository;

@Service
public class ChurchService {
	
	@Autowired
	private ChurchRepository repo;
	
	public Church find(Integer id) {
		Optional<Church> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<Church> findAll(){
		return repo.findAll();
	}
	

}
