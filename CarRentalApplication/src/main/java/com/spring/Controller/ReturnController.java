package com.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.helper.CarReturnResponsiveStruture;
import com.spring.model.CarReturn;
import com.spring.repository.CarReturnRepository;

@RestController
public class ReturnController {
	
	@Autowired
	CarReturnRepository returnRepo;
	
/*
 * 
 * {
 "returnDate" :"2010-09-12",
 "elap":"1",
 "fine":2019,
 "car":{
     "id":2
 },
 "customer":{
     "id":1
 }
}
 */
	@PostMapping("/SaveReturnData")
	public CarReturnResponsiveStruture<CarReturn> SaveReturnData(@RequestBody CarReturn return1){
		returnRepo.save(return1);
		CarReturnResponsiveStruture<CarReturn> rs= new CarReturnResponsiveStruture<>();
		rs.setStatusCode(HttpStatus.CREATED.value());
		rs.setMesg("Rental Data successfully");
		rs.setData(return1);
		return rs;
				
	}

}
