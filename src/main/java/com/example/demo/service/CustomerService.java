package com.example.demo.service;

import java.util.List;

import com.example.demo.model.CustomerModel;

public interface CustomerService {

	public List<CustomerModel> getAllCustomer();

	public CustomerModel getCustomerById(Long account_no);

	public boolean save(CustomerModel customerModel);

	public Long delete(Long account_no);

	public Boolean update(CustomerModel customerModel, Long account_no);

}
