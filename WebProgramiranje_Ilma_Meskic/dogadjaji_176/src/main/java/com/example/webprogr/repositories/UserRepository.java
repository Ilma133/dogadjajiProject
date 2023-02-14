package com.example.webprogr.repositories;

import org.springframework.stereotype.Repository;

import com.example.webprogr.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsername(String name);
}
