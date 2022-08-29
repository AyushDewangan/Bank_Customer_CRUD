package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.exception.UserAlredyExist;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerModel;
import com.example.demo.repository.CustomerRepository;


@Service
public class CustomerServiceImp implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	public List<CustomerModel> getAllCustomer() {						//DONE
		Iterable<Customer> cust = customerRepository.findAll();
		List<CustomerModel> customer= new ArrayList<>();
		for(Customer c : cust) {
			CustomerModel cm = new CustomerModel();
			cm.setAccount_no(c.getAccount_no());
			cm.setAccount_type(c.getAccount_type());
			cm.setAmount(c.getAmount());
			cm.setContact(c.getContact());
			cm.setName(c.getName());
			
			customer.add(cm);
		}
		
		return customer;
	}

	public CustomerModel getCustomerById(Long account_no) {					//DONE
		Customer myCustomer = customerRepository.findById(account_no).get();
		
		CustomerModel cust = new CustomerModel();
		cust.setAccount_no(myCustomer.getAccount_no());
		cust.setAccount_type(myCustomer.getAccount_type());
		cust.setAmount(myCustomer.getAmount());
		cust.setContact(myCustomer.getContact());
		cust.setName(myCustomer.getName());
		return cust;
	}

	public boolean save(@Validated CustomerModel customerModel) {					//DONE
		
		Customer custCheck = customerRepository.findFirstByContact(customerModel.getContact());
		if(Objects.nonNull(custCheck)) {
			
			throw new  UserAlredyExist("User Already Exist with Contact : "+custCheck.getContact());
		}
		Customer cust = new Customer();
		cust.setAccount_no(customerModel.getAccount_no());
		cust.setAccount_type(customerModel.getAccount_type());
		cust.setAmount(customerModel.getAmount());
		cust.setContact(customerModel.getContact());
		cust.setName(customerModel.getName());
		customerRepository.save(cust);
		return true;
		
	}

	public Long delete(Long account_no) {					//DONE
		customerRepository.deleteById(account_no);
		return account_no;
	}

	public Boolean update(CustomerModel customerModel, Long account_no) {				//Done
		Customer myCustomer = customerRepository.findById(account_no).get();
		myCustomer.setAccount_no(customerModel.getAccount_no());
		myCustomer.setAccount_type(customerModel.getAccount_type());
		myCustomer.setAmount(customerModel.getAmount());
		myCustomer.setContact(customerModel.getContact());
		myCustomer.setName(customerModel.getName());
		try {
		customerRepository.save(myCustomer);
		return true;
		}
		catch (Exception e) {
			System.out.println("Not able to update...");
		}
		return false;
		
		//customerRepository.save(customer);
	}

}
