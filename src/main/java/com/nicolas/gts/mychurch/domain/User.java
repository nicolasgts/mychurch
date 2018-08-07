package com.nicolas.gts.mychurch.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	@JsonIgnore
	@Column(nullable = false)
	private String password;

	@Column(nullable = false,unique=true)
	private String email;
	
	@Column(nullable = false,unique=true)
	private String cpf;
	
//	@ElementCollection(fetch=FetchType.EAGER)
//	@CollectionTable(name="PROFILES")
//	private Set<Integer> profiles = new HashSet<>();
	
	
	@ManyToOne
	@JoinColumn(name = "fk_church")
	private Church church;
	
	
	public User() {}

	public User(Integer id, String name, String email, String password , String cpf) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.cpf = cpf;
	}
	
	public User(Integer id, String name, String email, String password , String cpf, Church church) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.cpf = cpf;
		this.church = church;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Church getChurch() {
		return church;
	}

	public void setChurch(Church church) {
		this.church = church;
	}
	
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	

}
