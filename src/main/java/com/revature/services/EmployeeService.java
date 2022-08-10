package com.revature.services;

import java.util.List;

import com.revature.daos.EmployeeDAO;
import com.revature.daos.EmployeeDAOImpl;
import com.revature.models.Employee;

public class EmployeeService {

	private EmployeeDAO employeeDao = new EmployeeDAOImpl();
	
	 public List<Employee>showEmployees(){
		 return employeeDao.getAllEmployees();
	 }
	 public void newEmployee(Employee employee) {
		 employeeDao.insertEmployee(employee);
	 }
}
