package com.nicolas.gts.mychurch.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nicolas.gts.mychurch.domain.Post;
import com.nicolas.gts.mychurch.domain.User;
import com.nicolas.gts.mychurch.repositories.PostRepository;
import com.nicolas.gts.mychurch.security.UserSS;
import com.nicolas.gts.mychurch.services.exceptions.AuthorizationException;
import com.nicolas.gts.mychurch.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	
	@Autowired
	private PostRepository repo;
	
	@Autowired 
	private ChurchService churchService;
	
	@Autowired
	private UserService userService;

	public Post find(Integer id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Post.class.getName()));
	}
	
	public Page<Post> search(Integer churchId, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.search(churchId, pageRequest);
	}
	
	
	
	
	public Post insert(Post obj) {
		obj.setId(null);
		obj.setPostDate(new Date());
		obj = repo.save(obj);
		return obj;
	}
	

	
	
}
