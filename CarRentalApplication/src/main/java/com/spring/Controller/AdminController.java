package com.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.helper.AdminResponsiveStructure;
import com.spring.model.Admin;
import com.spring.repository.AdminRepository;

//This contaoller class is Admin
@RestController
public class AdminController {
	
	@Autowired
	AdminRepository adminRepo;
	
	
	@PostMapping("/newAdmin")
	public AdminResponsiveStructure<Admin> newAdmin(@RequestBody Admin admin){
		adminRepo.save(admin);
		AdminResponsiveStructure<Admin> res= new AdminResponsiveStructure<>();
		res.setStatuscode(HttpStatus.CREATED.value());
		res.setMesg("Admin saved successfully");
		res.setData(admin);
		return res;
				
	}
	
	//http://localhost:8080/LoginAdmin?email=pavankumar@gmail.com&password=chinnaKothi
	@GetMapping("/LoginAdmin")
	public AdminResponsiveStructure<Admin> LoginAdmin(@RequestParam String email, @RequestParam String password){
		Admin admin=adminRepo.findByEmailAndPassword(email, password);
		AdminResponsiveStructure<Admin> res= new AdminResponsiveStructure<>();
		if(admin!=null) {
			res.setStatuscode(HttpStatus.OK.value());
			res.setMesg("loginSuccessfully");
			res.setData(admin);
		}else {
			res.setStatuscode(HttpStatus.UNAUTHORIZED.value());
			res.setMesg("invalid email or password");
			res.setData(null);
		}
		return res;
	}


}
