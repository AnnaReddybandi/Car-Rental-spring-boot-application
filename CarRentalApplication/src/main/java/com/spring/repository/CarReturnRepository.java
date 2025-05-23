package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.CarReturn;

@Repository
public interface CarReturnRepository extends JpaRepository<CarReturn, Integer> {

}
