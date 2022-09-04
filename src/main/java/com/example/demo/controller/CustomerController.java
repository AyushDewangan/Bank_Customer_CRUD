package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CustomerModel;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping
	public ResponseEntity<List<CustomerModel>> getAllCustomer() {
		return ResponseEntity.ok().body(customerService.getAllCustomer());
	}

	@GetMapping("/{accountNo}")
	private ResponseEntity<CustomerModel> getCustomer(@PathVariable("accountNo") Long accountNo) {
		return ResponseEntity.ok().body(customerService.getCustomerById(accountNo));
	}

	@DeleteMapping("/{accountNo}")
	private ResponseEntity<Long> deleteCostomer(@PathVariable("accountNo") Long accountNo) {
		return ResponseEntity.ok().body(customerService.delete(accountNo));
	}

	@PostMapping
	public ResponseEntity<Boolean> createCustomer(@RequestBody CustomerModel customer) {
		return ResponseEntity.ok().body(customerService.save(customer));

	}

	@PutMapping
	public ResponseEntity<CustomerModel> update(@RequestBody CustomerModel customerModel) {
		customerService.update(customerModel);
		return ResponseEntity.ok().body(customerModel);
	}

}
