package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDAO {
	
public abstract void insertEmployee(Employee employee);

public abstract Employee getEmployeeById(int id);

List<Employee>getAllEmployees();


}
