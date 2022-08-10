package com.revature.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.models.Employee;
import com.revature.models.Store;
import com.revature.services.EmployeeService;
import com.revature.services.StoreService;
import com.revature.utils.ConnectionUtil;

public class StoreMenuController {

	//private StoreService storeService = new StoreService();
	
	private EmployeeService employeeService = new EmployeeService();
	
	private Scanner scan = new Scanner(System.in);
	
	public void storeMenu() {
		String choice ="";
		menuLoop:
		while(!choice.equals("e")) {		
			System.out.println(" \n what would you like to do in the application?  "
					+"\n a.) Hire a new Employee" 
					+"\n b.) Count the amount of employess"
					+ "\n c.) Fire an Employee" 
					+"\n e.) exit ");
			choice = scan.nextLine();
			
			switchChoice:
			switch(choice) {
			case"a":
				insertIntoEmployee();
				break switchChoice;
			case "e":
				break switchChoice;
				default:
					System.out.println("That wasn't a valid input, try again..");
					
			case"b":
				countEmployee();
				break switchChoice;	
				
			case"c":
				//fireAnEmployee();
				break switchChoice;
				}
			}
	}

	private void insertIntoEmployee() {
		System.out.println("type 'hire' to add a new employee to work under you!");
		String choice = scan.nextLine();
		
		if(choice.equalsIgnoreCase("hire")) {
			insertEmployee();
			}	else {					
		}	
	}
	
	
	public void insertEmployee() {
		System.out.println("Success! Let's introduce your new hire!! "
			+ "\n What is their first name?");
		
		Employee employee = new Employee();		
		employee.setEmpFirstName(scan.nextLine());
		
		System.out.println("What about their last name?");
		employee.setEmpLastName(scan.nextLine());
		
		System.out.println("How much will they make an hour?");
		employee.setHourlyRate(Double.parseDouble(scan.nextLine()));
		employeeService.newEmployee(employee);
	}
		
	
	
	public int countEmployee (){
		
		try( Connection connection = ConnectionUtil.getConnection()){
				String sql ="SELECT count(*) FROM employee; ";
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				result.next();
			int x = result.getInt("count");
			System.out.println("Success, "+x+" is your staff number!");
			return x;
			
	}catch(SQLException e) {
		e.printStackTrace();	
		
	}
		return 0;
		
}
	
	public void fireAnEmployee(Employee employee) {
		try( Connection connection = ConnectionUtil.getConnection()){
			String sql ="DELETE FROM employee WHERE empfirst_name = '?';";
			//Statement statement = connection.createStatement();
	
			PreparedStatement statement =  connection.prepareStatement(sql);
			int count  = 0;
			statement.setString(++count,  employee.getEmpFirstName());
			statement.execute();
			//System.out.println(0+" has been terminated....");
			//return 0;
				}catch(SQLException e) {
					e.printStackTrace();
				}
		
		//return "";
	}
	
}
