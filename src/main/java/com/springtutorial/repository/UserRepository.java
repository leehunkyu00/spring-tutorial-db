package com.springtutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springtutorial.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
}
