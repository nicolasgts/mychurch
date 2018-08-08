package com.nicolas.gts.mychurch.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nicolas.gts.mychurch.domain.Church;
import com.nicolas.gts.mychurch.domain.User;

@Repository
public interface ChurchRepository extends JpaRepository<Church, Integer>{
	
	@Transactional(readOnly=true)
	Church findByName(String name);
	
	@Transactional(readOnly=true)
	Church findByCnpj(String cnpj);

	
}
