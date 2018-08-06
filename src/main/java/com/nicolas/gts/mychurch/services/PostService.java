package com.nicolas.gts.mychurch.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.nicolas.gts.mychurch.domain.Church;
import com.nicolas.gts.mychurch.domain.Post;
import com.nicolas.gts.mychurch.repositories.PostRepository;
import com.nicolas.gts.mychurch.services.exceptions.DataIntegrityException;
import com.nicolas.gts.mychurch.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	
	@Autowired
	private PostRepository repo;

	public Post find(Integer id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Post.class.getName()));
	}
	
	public Post insert(Post obj) {
		obj.setId(null);
		return repo.save(obj);
	}
//	
//	public Post update(Post obj) {
//		Post newObj = find(obj.getId());
//		updateData(newObj, obj);
//		return repo.save(newObj);
//	}
	
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("It is not possible delete an church that has posts");
		}
	}
	
	
//	private void updateData(Post newObj, Post obj) {
//		newObj.setName(obj.getName());
//	}
	
	
}
