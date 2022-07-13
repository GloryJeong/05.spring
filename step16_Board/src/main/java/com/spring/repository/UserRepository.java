package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.Entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, String> {

	User getUserByUserEmail(String userEmail);


	
}