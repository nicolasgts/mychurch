package com.nicolas.gts.mychurch.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nicolas.gts.mychurch.domain.Church;
import com.nicolas.gts.mychurch.services.validation.UserInsert;

@UserInsert
public class UserNewDTO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="this field is required")
	@Length(min=10,max=120,  message="The size should be between 10 and 120 characters")
	private String name;
	
	@NotEmpty(message="this field is required")
	@Email(message="Invalid Email")
	private String email;
	
	@Column(nullable = false)
	@NotEmpty(message="this field is required")
	@Length(min=6,max=12,  message="The size should be between 6 and 12 characters")
	private String password;

	@CPF(message = "invalid cpf")
	private String cpf;
	
	private Church church;
	
	
	public UserNewDTO() {
		
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Church getChurch() {
		return church;
	}


	public void setChurch(Church church) {
		this.church = church;
	}
	
	
	

}
