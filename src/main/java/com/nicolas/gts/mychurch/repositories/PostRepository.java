package com.nicolas.gts.mychurch.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nicolas.gts.mychurch.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{}
