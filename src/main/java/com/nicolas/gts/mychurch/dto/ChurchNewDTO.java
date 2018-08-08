package com.nicolas.gts.mychurch.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nicolas.gts.mychurch.domain.Adress;
import com.nicolas.gts.mychurch.domain.Post;
import com.nicolas.gts.mychurch.domain.User;
import com.nicolas.gts.mychurch.services.validation.ChurchInsert;

@ChurchInsert
public class ChurchNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	
	
	@NotEmpty(message="this field is required")
	@CNPJ(message="Cnpj Invalid")
	private String cnpj;

	@NotEmpty(message="this field is required")
	@Length(min=10,max=70,  message="The size should be between 10 and 70 characters")
	private String name;

	@Length(min=5,max=300,  message="The size should be between 5 and 300 characters")
	private String description;

	@NotEmpty(message="this field is required")
	private String street;
	@NotEmpty(message="this field is required")
	private String number;
	
	private String complement;
	private String district;
	
	@NotEmpty(message="this field is required")
	private String zipcode;
	
	@NotEmpty(message="this field is required")
	private String name_user;
	@NotEmpty(message="this field is required")
	@Length(min=6,max=12,  message="The password's size should be between 6 and 12 characters")
	private String password;
	@NotEmpty(message="this field is required")
	private String email_user;
	@NotEmpty(message="this field is required")
	private String cpf_user;
	
	private Integer city_id;
	
	public ChurchNewDTO(){	
	}


	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getName_user() {
		return name_user;
	}

	public void setName_user(String name_user) {
		this.name_user = name_user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail_user() {
		return email_user;
	}

	public void setEmail_user(String email_user) {
		this.email_user = email_user;
	}

	public String getCpf_user() {
		return cpf_user;
	}

	public void setCpf_user(String cpf_user) {
		this.cpf_user = cpf_user;
	}

	public Integer getCity_id() {
		return city_id;
	}

	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}



	
	

}
	

	
