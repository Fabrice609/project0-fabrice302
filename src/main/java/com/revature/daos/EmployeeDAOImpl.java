package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;
 


public class EmployeeDAOImpl implements EmployeeDAO {

	public Employee getEmployeeById(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql ="SELECT * FROM employee WHERE employee_id = "+id+";";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			if(result.next()) {
				
				Employee employee = new Employee(
						result.getInt("store_id"),
						result.getString("empfirst_name"),
						result.getString("emplast_name"),
						result.getDouble("hourly_rate")					
						);
				return employee;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public void insertEmployee(Employee employee) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO employee (empfirst_name, emplast_name, hourly_rate) "
					+ "VALUES(?, ?, ?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int count=0;
			statement.setString(++count, employee.getEmpFirstName());
			statement.setString(++count, employee.getEmpLastName());
			statement.setDouble(++count, employee.getHourlyRate());
			
			statement.execute();
					
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}


	public List<Employee> getAllEmployees() {
	try(Connection conn = ConnectionUtil.getConnection()){
		String sql ="SELECT * FROM employee; ";
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		List<Employee>employeeList = new LinkedList<Employee>();
		
		while(result.next()) {
			Employee employee = new Employee(
					result.getInt("store_id"),
					result.getString("empfirst_name"),
					result.getString("emplast_name"),
					result.getDouble("hourly_rate")	
					);
			employeeList.add(employee);
		}
		return employeeList;
	}catch(SQLException e) {
		e.printStackTrace();
	}
		return null;
	}
	
}
