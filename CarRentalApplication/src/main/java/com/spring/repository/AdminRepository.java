package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	public Admin findByEmailAndPassword(String email, String password);

}
