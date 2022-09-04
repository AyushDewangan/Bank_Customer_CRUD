package com.example.demo.service;

import java.util.List;

import com.example.demo.model.CustomerModel;

public interface CustomerService {

	public List<CustomerModel> getAllCustomer();

	public CustomerModel getCustomerById(Long accountNo);

	public boolean save(CustomerModel customerModel);

	public Long delete(Long accountNo);

	public Boolean update(CustomerModel customerModel);

}
