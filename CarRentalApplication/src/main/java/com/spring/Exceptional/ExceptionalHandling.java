package com.spring.Exceptional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.helper.AdminResponsiveStructure;
import com.spring.helper.CarCustomerResponsiveStructure;
import com.spring.helper.CarRegistrationResponsiveStructure;
import com.spring.helper.CarRentalResponsiveStructure;
import com.spring.helper.CarReturnResponsiveStruture;
import com.spring.model.Admin;
import com.spring.model.CarRegistration;
import com.spring.model.CarRental;
import com.spring.model.CarReturn;
import com.spring.model.Customer;

@RestControllerAdvice
public class ExceptionalHandling {
	
	
	@ExceptionHandler(CarRegistrationNotFound.class)
	public CarRegistrationResponsiveStructure<CarRegistration> m1(CarRegistration stu){
		CarRegistrationResponsiveStructure<CarRegistration> rs= new CarRegistrationResponsiveStructure<>();
		   rs.setStatuscode(HttpStatus.OK.value());
		   rs.setMesg("CarRegistartion not found");
		   rs.setData(stu);
		   return rs;
	}
	
	@ExceptionHandler(AdminRegistartionNotFound.class)
	public AdminResponsiveStructure<Admin> m2 (Admin ad){
		AdminResponsiveStructure<Admin> rs= new AdminResponsiveStructure();
		   rs.setStatuscode(HttpStatus.OK.value());
		   rs.setMesg("Admin not found");
		   rs.setData(ad);
		   return rs;
	}

	@ExceptionHandler(CarCustomerNotFound.class)
	public CarCustomerResponsiveStructure<Customer> m3 (Customer cust){
		CarCustomerResponsiveStructure<Customer> rs= new CarCustomerResponsiveStructure<>();
		   rs.setStatuscode(HttpStatus.OK.value());
		   rs.setMesg("Customer not found");
		   rs.setData(cust);
		   return rs;
	}

	@ExceptionHandler(RentalNotFound.class)
	public CarRentalResponsiveStructure<CarRental> m4 (CarRental rental){
		CarRentalResponsiveStructure<CarRental> rs= new CarRentalResponsiveStructure<>();
		   rs.setStatuscode(HttpStatus.OK.value());
		   rs.setMesg("CarRegistartion not found");
		   rs.setData(rental);
		   return rs;
	}

	
	@ExceptionHandler(ReturnNotFound.class)
	public CarReturnResponsiveStruture<CarReturn> m5 (CarReturn return1){
		CarReturnResponsiveStruture<CarReturn> rs= new CarReturnResponsiveStruture<>();
		   rs.setStatusCode(HttpStatus.OK.value());
		   rs.setMesg("CarRegistartion not found");
		   rs.setData(return1);
		   return rs;
	}

}
