package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospital.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findByUsername(String username);
	
}
