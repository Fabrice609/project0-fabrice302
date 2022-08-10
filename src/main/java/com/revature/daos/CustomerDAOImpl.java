package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.models.Customer;
import com.revature.utils.ConnectionUtil;

public class CustomerDAOImpl implements CustomerDAO{

	public Customer getCustomerById(int id) {
		try(Connection conn =ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM customer WHERE customer_id ="+id+";";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			if(result.next()) {
				Customer customer = new Customer(
						result.getInt("customer_id"),
						result.getString("first_name"),
						result.getString("last_name"),
						result.getDouble("customer_spending"),
						result.getString("customer_selection")
						);
				return customer;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Customer>getAllCustomers(){
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM customer;";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			List<Customer>customerList = new LinkedList<Customer>();
			
			while(result.next()) {
				
				Customer customer = new Customer(
						result.getInt("customer_id"),
						result.getString("first_name"),
						result.getString("last_name"),
						result.getDouble("customer_spending"),
						result.getString("customer_selection")
						);
				customerList.add(customer);
			}
			return customerList;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

//public static void main(String [] args) {
		//CustomerDAO cDao = new CustomerDAOImpl();
		//
		//Customer c =cDao.getCustomerById(1);
		//System.out.println(c);
		//
		//List<Customer> list =cDao.getAllCustomer();
		//
		//// Customer cs =CDao.getCustomerBySpending(2);
		// //System.out.println(cs);	 
		//}
