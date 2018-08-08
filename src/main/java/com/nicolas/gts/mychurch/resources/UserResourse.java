package com.nicolas.gts.mychurch.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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
import com.nicolas.gts.mychurch.domain.User;
import com.nicolas.gts.mychurch.dto.ChurchDTO;
import com.nicolas.gts.mychurch.dto.UserDTO;
import com.nicolas.gts.mychurch.dto.UserNewDTO;
import com.nicolas.gts.mychurch.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResourse {

	@Autowired
	private UserService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> find(@PathVariable Integer id) {
		User obj = service.find(id);
		UserDTO objDTO = new UserDTO(obj);
		return ResponseEntity.ok().body(objDTO);
	}
	

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody UserNewDTO objDto) {
		User obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody UserDTO objDTO, @PathVariable Integer id) {
		User obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}


	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<UserDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<User> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<UserDTO> listDto = list.map(obj -> new UserDTO(obj));
		return ResponseEntity.ok().body(listDto);

	}
}