package com.revature.services;

import java.util.List;

import com.revature.daos.CustomerDAO;
import com.revature.daos.CustomerDAOImpl;
import com.revature.models.Customer;

public class CustomerService {

	private CustomerDAO customerDao = new CustomerDAOImpl();
	
	public List<Customer> getAllCustomers(){
		return customerDao.getAllCustomers();
	}
	
	
	
}
