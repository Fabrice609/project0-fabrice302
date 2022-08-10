package com.revature.daos;

import java.util.List;

import com.revature.models.Customer;
import com.revature.models.Store;

public interface CustomerDAO {

	public abstract Customer getCustomerById(int id);
	List <Customer>getAllCustomers();
	 
	
}

