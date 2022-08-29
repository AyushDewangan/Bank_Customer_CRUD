package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerModel;

public interface CustomerService {
	
	public List<CustomerModel> getAllCustomer();
	
	public CustomerModel getCustomerById(Long account_no);
	
	public boolean save(CustomerModel customerModel);
	
	public void delete(Long account_no);
	
	public void update(CustomerModel customerModel, Long account_no);

}
