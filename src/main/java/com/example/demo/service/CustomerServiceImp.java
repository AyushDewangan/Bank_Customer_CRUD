package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public Customer getCustomerById(Long account_no) {					//DONE
		return customerRepository.findById(account_no).get();
	}

	public boolean save(Customer customer) {					//DONE
		Customer cust = new Customer();
		cust.setAccount_no(customer.getAccount_no());
		cust.setAccount_type(customer.getAccount_type());
		cust.setAmount(customer.getAmount());
		cust.setContact(customer.getContact());
		cust.setName(customer.getName());
		try {
		customerRepository.save(cust);
		return true;
		}
		catch (Exception e) {
			System.out.println("Save time Exception : " +e);
		}
		return false;
	}

	public void delete(Long account_no) {					//DONE
		customerRepository.deleteById(account_no);
	}

	public void update(Customer customer, Long account_no) {
		Customer myCustomer = customerRepository.findById(account_no).get();
		//myCustomer.setAccount_no(customer.getAccount_no());
		myCustomer.setAccount_type(customer.getAccount_type());
		myCustomer.setAmount(customer.getAmount());
		myCustomer.setContact(customer.getContact());
		myCustomer.setName(customer.getName());
		customerRepository.save(myCustomer);
		//customerRepository.save(customer);
	}
}
