package com.example.samuraitravel.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.samuraitravel.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public Page<User> findByNameLikeOrFuriganaLike(String nameKeyword, String furiganaKeyword, Pageable pageable);
	public Page<User> findAll(Pageable pageable);
	public User findByEmail(String email);
	}


