package com.nicolas.gts.mychurch.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nicolas.gts.mychurch.domain.Adress;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Integer>{
	
}
