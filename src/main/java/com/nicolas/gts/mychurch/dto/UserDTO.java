package com.nicolas.gts.mychurch.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.nicolas.gts.mychurch.domain.Church;
import com.nicolas.gts.mychurch.domain.User;



public class UserDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message="this field is required")
	@Length(min=10,max=120,  message="The size should be between 10 and 120 characters")
	private String name;
	
	@NotEmpty(message="this field is required")
	@Email(message="Invalid Email")
	private String email;
	
	private ChurchDTO church;
	

	
	public UserDTO() {}

	public UserDTO(User obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.email = obj.getEmail();
//		this.church = new ChurchDTO(obj.getChurch().getId(), obj.getChurch().getCnpj(), obj.getChurch().getName(), obj.getChurch().getDescription());
		this.church = new ChurchDTO(obj.getChurch());
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

	public ChurchDTO getChurch() {
		return church;
	}

	public void setChurch(ChurchDTO church) {
		this.church = church;
	}

	
	
	

}