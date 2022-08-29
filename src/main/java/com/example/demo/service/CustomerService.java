package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerModel;

public interface CustomerService {
	
	public List<CustomerModel> getAllCustomer();
	
	public Customer getCustomerById(Long account_no);
	
	public boolean save(Customer customer);
	
	public void delete(Long account_no);
	
	public void update(Customer customer, Long account_no);

}
