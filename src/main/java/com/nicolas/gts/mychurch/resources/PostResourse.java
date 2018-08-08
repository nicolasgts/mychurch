package com.nicolas.gts.mychurch.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nicolas.gts.mychurch.domain.Church;
import com.nicolas.gts.mychurch.domain.Post;
import com.nicolas.gts.mychurch.dto.ChurchDTO;
import com.nicolas.gts.mychurch.dto.ChurchNewDTO;
import com.nicolas.gts.mychurch.dto.PostDTO;
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
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Post obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<PostDTO>> findPage(
			@RequestParam(value = "churchId", defaultValue = "") Integer churchId,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Post> list = service.search(churchId,page, linesPerPage, orderBy, direction);
		Page<PostDTO> listDto = list.map(obj -> new PostDTO(obj));
		return ResponseEntity.ok().body(listDto);

	}
}
	