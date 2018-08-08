package com.nicolas.gts.mychurch.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import com.nicolas.gts.mychurch.domain.Adress;
import com.nicolas.gts.mychurch.domain.Church;
import com.nicolas.gts.mychurch.domain.Post;
import com.nicolas.gts.mychurch.services.validation.ChurchUpdate;

@ChurchUpdate
public class ChurchDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@Length(min=10,max=70,  message="The size should be between 10 and 70 characters")
	private String name;
	
	
	@Length(min=5,max=300,  message="The size should be between 5 and 300 characters")
	private String description;
	private List<Adress> adresses = new ArrayList<>();
	
	@CNPJ(message="Cnpj Invalid")
	private String cnpj;

	public ChurchDTO() {

	}

	public ChurchDTO(Church obj) {
		id = obj.getId();
		name = obj.getName();
		description = obj.getDescription();
		adresses = obj.getAdresses();
		cnpj = obj.getCnpj();
	
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	
}
