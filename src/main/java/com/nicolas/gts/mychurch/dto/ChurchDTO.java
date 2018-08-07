package com.nicolas.gts.mychurch.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import com.nicolas.gts.mychurch.domain.Adress;
import com.nicolas.gts.mychurch.domain.Church;
import com.nicolas.gts.mychurch.domain.Post;

public class ChurchDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String description;
	private List<Adress> adresses = new ArrayList<>();

	public ChurchDTO() {

	}

	public ChurchDTO(Church obj) {
		id = obj.getId();
		name = obj.getName();
		description = obj.getDescription();
		adresses = obj.getAdresses();
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public List<Adress> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adress> adresses) {
		this.adresses = adresses;
	}


}
