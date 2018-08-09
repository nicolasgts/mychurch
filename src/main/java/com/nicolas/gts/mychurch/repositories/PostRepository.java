package com.nicolas.gts.mychurch.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nicolas.gts.mychurch.domain.Church;
import com.nicolas.gts.mychurch.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
	
	@Query("SELECT obj FROM Post obj WHERE obj.church.id = :churchId")
	public Page<Post> search(@Param("churchId") Integer church, Pageable pageRequest);
}
