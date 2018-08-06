package com.nicolas.gts.mychurch.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nicolas.gts.mychurch.domain.Post;
import com.nicolas.gts.mychurch.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResourse {
		
	@Autowired
	private PostService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Post obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
	