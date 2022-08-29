package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerModel;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import com.example.demo.service.CustomerServiceImp;

@RestController
public class CustomerController{
	
	@Autowired						
	CustomerService customerService;
	CustomerRepository customerRepository;

	@GetMapping("/customer")									//DONE
	private List<CustomerModel> getAllCustomer() {
		return customerService.getAllCustomer();
	}

	@GetMapping("/customer/{account_no}")						//DONE
	private CustomerModel getCustomer(@PathVariable("account_no") Long account_no) {		
		return customerService.getCustomerById(account_no);
	}

	@DeleteMapping("/customer/{account_no}")					//DONE
	private void deleteCostomer(@PathVariable("account_no") Long account_no) {
		customerService.delete(account_no);
	}

	@PostMapping("/customer")
	private boolean createCustomer(@RequestBody CustomerModel customer) {	
		return customerService.save(customer);
		
	}

	@PutMapping("/customer/{account_no}")								
	private CustomerModel update(@RequestBody CustomerModel customerModel,@PathVariable("account_no") Long account_no) {
		customerService.update(customerModel, account_no);
		return customerModel;
	}

	
}
