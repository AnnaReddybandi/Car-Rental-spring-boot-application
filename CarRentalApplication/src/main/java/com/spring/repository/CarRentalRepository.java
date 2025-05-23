package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.CarRental;

@Repository
public interface CarRentalRepository extends JpaRepository<CarRental, Integer>{

}
