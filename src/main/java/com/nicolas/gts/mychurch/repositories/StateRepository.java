package com.nicolas.gts.mychurch.repositories;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nicolas.gts.mychurch.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer>{
	
}

