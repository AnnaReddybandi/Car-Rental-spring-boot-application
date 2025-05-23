package com.spring.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.spring.car.CarRentalApplication;
import com.spring.helper.CarRegistrationResponsiveStructure;
import com.spring.model.CarRegistration;
import com.spring.repository.CarRegistrationRepository;

@RestController
public class CarRegistrationController {

    private final CarRentalApplication carRentalApplication;

	@Autowired
	CarRegistrationRepository regiRepo;

    CarRegistrationController(CarRentalApplication carRentalApplication) {
        this.carRentalApplication = carRentalApplication;
    }

	@PostMapping("/saveRegister")
	public CarRegistrationResponsiveStructure<CarRegistration> saveRegister(@RequestBody CarRegistration register) {
		regiRepo.save(register);
		CarRegistrationResponsiveStructure<CarRegistration> res = new CarRegistrationResponsiveStructure<>();
		res.setStatuscode(HttpStatus.CREATED.value());
		res.setMesg("data saved successfully");
		res.setData(register);
		return res;
	}

	@GetMapping("/fetchCar")
	public CarRegistrationResponsiveStructure<CarRegistration> fetchCar(@RequestParam("id") int id) {
		Optional<CarRegistration> option = regiRepo.findById(id);
		CarRegistrationResponsiveStructure<CarRegistration> rs = new CarRegistrationResponsiveStructure<>();
		CarRegistration reg = option.get();
		if (reg != null) {
			rs.setStatuscode(HttpStatus.OK.value());
			rs.setMesg("Car fetched successfully");
			rs.setData(reg);
		} else {
			rs.setStatuscode(HttpStatus.NOT_FOUND.value());
			rs.setMesg("Car not found");
			rs.setData(null);

		}
		return rs;
	}

	@GetMapping("/fetchCar1")
	public CarRegistrationResponsiveStructure<List<CarRegistration>> fetchCar1() {
		List<CarRegistration> cars = regiRepo.findAll();
		CarRegistrationResponsiveStructure<List<CarRegistration>> rs = new CarRegistrationResponsiveStructure<>();
		if (!cars.isEmpty()) {
			rs.setStatuscode(HttpStatus.OK.value());
			rs.setMesg("Car fetched successfully");
			rs.setData(cars);

		} else {
			rs.setStatuscode(HttpStatus.NOT_FOUND.value());
			rs.setMesg("Car not found");
			rs.setData(null);

		}
		return rs;
	}

	
	@DeleteMapping("/deleteCar")
	public CarRegistrationResponsiveStructure<CarRegistration> deleteCar(@RequestParam("id") int id){
		regiRepo.deleteById(id);
		CarRegistrationResponsiveStructure<CarRegistration> rs= new CarRegistrationResponsiveStructure<>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMesg("Car deleted successfully");
		return rs;
	}
	
	
	@PutMapping("/updateCar")
	public CarRegistrationResponsiveStructure<CarRegistration> updateCar(@RequestParam("id") int id,@RequestBody CarRegistration carregister){
	Optional<CarRegistration> option=	regiRepo.findById(id);
	CarRegistrationResponsiveStructure<CarRegistration> rs= new CarRegistrationResponsiveStructure<>();
	CarRegistration register=option.get();
	if(option.isPresent()) {
		register.setFualType(carregister.getFualType());
		register.setDescription(carregister.getDescription());
		register.setModelYear(carregister.getModelYear());
		regiRepo.save(carregister);
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMesg("Car update successfully");
		rs.setData(register);
	}else {
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMesg("Car not updated");
		rs.setData(null);
	}
		return rs;
	}
	
}
