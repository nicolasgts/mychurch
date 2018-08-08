package com.nicolas.gts.mychurch.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nicolas.gts.mychurch.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Transactional(readOnly=true)
	User findByEmail(String email);
	
	@Transactional(readOnly=true)
	User findByCpf(String cpf);

}
