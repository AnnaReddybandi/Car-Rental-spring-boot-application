package com.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.helper.CarRentalResponsiveStructure;
import com.spring.model.CarRental;
import com.spring.repository.CarRentalRepository;

@RestController
public class RentalController {

	@Autowired
	CarRentalRepository rentalRepo;
	
	
	@PostMapping("/saveRental")
	public CarRentalResponsiveStructure<CarRental> saveRental(@RequestBody CarRental rental){
		rentalRepo.save(rental);
		CarRentalResponsiveStructure<CarRental> rs= new CarRentalResponsiveStructure<>();
		rs.setStatuscode(HttpStatus.CREATED.value());
		rs.setMesg("save rental data successfully");
		rs.setData(rental);
		return rs;
	}
}
