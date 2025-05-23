package com.spring.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com.spring")
@EnableJpaRepositories(basePackages = "com.spring.repository")
@EntityScan(basePackages = "com.spring.model")
public class CarRentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarRentalApplication.class, args);
		System.out.println("Spring Run successfully , welcome ....");
	}

}
