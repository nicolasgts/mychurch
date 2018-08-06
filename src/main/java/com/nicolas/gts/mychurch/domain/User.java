package com.nicolas.gts.mychurch.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String password;

	@Column(nullable = false,unique=true)
	private String email;
	
	@JsonIgnore
	private String senha;
	
	
	@ManyToOne
	@JoinColumn(name="adress_user_id")
	private Adress adress;

//	@ElementCollection(fetch=FetchType.EAGER)
//	@CollectionTable(name="PROFILES")
//	private Set<Integer> profiles = new HashSet<>();
	
	
	@ManyToOne
	@JoinColumn(name = "fk_church")
	private Church church;
	
	
	
	
	

}
