package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BankCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankCustomerApplication.class, args);
		System.out.println("Spring Boot Working...");
	}

	@Bean
	BCryptPasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder();
	}
}
