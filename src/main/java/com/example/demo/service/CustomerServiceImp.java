package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.exception.UserAlredyExist;
import com.example.demo.exception.UserNotExist;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerModel;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public List<CustomerModel> getAllCustomer() { // DONE
		Iterable<Customer> cust = customerRepository.findAll();
		List<CustomerModel> customer = new ArrayList<>();
		for (Customer c : cust) {
			CustomerModel cm = new CustomerModel();
			cm.setAccountNo(c.getAccountNo());
			cm.setAccountType(c.getAccountType());
			cm.setAmount(c.getAmount());
			cm.setContact(c.getContact());
			cm.setName(c.getName());

			customer.add(cm);
		}

		return customer;
	}

	public CustomerModel getCustomerById(Long accountNo) { // DONE
		Customer myCustomer = customerRepository.findById(accountNo).get();

		CustomerModel cust = new CustomerModel();
		cust.setAccountNo(myCustomer.getAccountNo());
		cust.setAccountType(myCustomer.getAccountType());
		cust.setAmount(myCustomer.getAmount());
		cust.setContact(myCustomer.getContact());
		cust.setName(myCustomer.getName());
		return cust;
	}

	public boolean save(@Validated CustomerModel customerModel) {

		Customer custCheck = customerRepository.findFirstByContact(customerModel.getContact());
		if (Objects.nonNull(custCheck)) {

			throw new UserAlredyExist("User Already Exist with Contact : " + custCheck.getContact());
		}
		Customer cust = new Customer();
		cust.setAccountNo(customerModel.getAccountNo());
		cust.setAccountType(customerModel.getAccountType());
		cust.setAmount(customerModel.getAmount());
		cust.setContact(customerModel.getContact());
		cust.setName(customerModel.getName());
		customerRepository.save(cust);
		return true;

	}

	public Long delete(@Validated Long accountNo) {
		if(!customerRepository.findById(accountNo).isPresent()) {
			throw new UserNotExist("User not exist : "+accountNo);
		}
		customerRepository.deleteById(accountNo);
		return accountNo;
	}

	public Boolean update(@Validated CustomerModel customerModel) { // Done
		Optional<Customer> myCustomer = customerRepository.findById(customerModel.getAccountNo());
		Customer cust = null;
		if (myCustomer.isPresent()) {
			cust = myCustomer.get();
		cust.setAccountType(customerModel.getAccountType());
		cust.setAmount(customerModel.getAmount());
		cust.setContact(customerModel.getContact());
		cust.setName(customerModel.getName());
		}
		try {
			customerRepository.save(cust);
			return true;
		} catch (Exception e) {
			System.out.println("Not able to update...");
		}
		return false;
	}
}
