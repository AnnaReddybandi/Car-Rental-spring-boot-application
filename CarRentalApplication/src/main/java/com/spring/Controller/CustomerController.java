package com.spring.Controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.spring.helper.CarCustomerResponsiveStructure;
import com.spring.model.Customer;
import com.spring.repository.CarCustomerRepository;
import com.spring.repository.CarRegistrationRepository;

@RestController
public class CustomerController{
	@Autowired
	CarCustomerRepository custRepo;
	
	@PostMapping("/saveCustomer")
	public CarCustomerResponsiveStructure<Customer> saveCustomer(@RequestBody Customer cust){
		         custRepo.save(cust);
		CarCustomerResponsiveStructure<Customer>  res= new CarCustomerResponsiveStructure<>();
		res.setStatuscode(HttpStatus.CREATED.value());
		res.setMesg("data saved successfully");
		res.setData(cust);
		return res;
	}
	
	@GetMapping("/fetchCustomer")
	public CarCustomerResponsiveStructure<Customer> fetchCustomer(@RequestParam int id) {
	    Optional<Customer> optionalCustomer = custRepo.findById(id);
	    CarCustomerResponsiveStructure<Customer> response = new CarCustomerResponsiveStructure<>();
	    if (optionalCustomer.isPresent()) {
	        response.setStatuscode(HttpStatus.OK.value());
	        response.setMesg("Customer data fetched successfully");
	        response.setData(optionalCustomer.get());
	    } else {
	        response.setStatuscode(HttpStatus.NOT_FOUND.value());
	        response.setMesg("Customer not found");
	        response.setData(null);
	    }
	    return response;
	}
	
	@GetMapping("/fetchAll")
	public CarCustomerResponsiveStructure<List<Customer>> fetchAll() {
	    List<Customer> customers = custRepo.findAll();
	    
	    CarCustomerResponsiveStructure<List<Customer>> res = new CarCustomerResponsiveStructure<>();
	    
	    if (!customers.isEmpty()) {
	        res.setStatuscode(HttpStatus.OK.value());
	        res.setMesg("Customer data fetched successfully");
	        res.setData(customers);
	    } else {
	        res.setStatuscode(HttpStatus.NOT_FOUND.value());
	        res.setMesg("No customers found");
	        res.setData(null);
	    }
	    
	    return res;
	}


}
