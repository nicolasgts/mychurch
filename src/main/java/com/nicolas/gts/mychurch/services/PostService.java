package com.nicolas.gts.mychurch.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolas.gts.mychurch.domain.Post;
import com.nicolas.gts.mychurch.repositories.PostRepository;
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
	
}
