package com.revature;

import java.util.Scanner;

import com.revature.controllers.AdminMenuController;
import com.revature.controllers.CustomerMenuController;
import com.revature.controllers.StoreMenuController;


public class Login {
	public static void main(String[] args) {
			
		
		try ( Scanner scanner  = new Scanner(System.in)) {
			System.out.println(" Welcome! Please enter your Role. \n"
					+ "Are you an Admin, Store Owner, Employee, or a Customer? ");
			String userName = scanner.nextLine();
			
			System.out.println(" Please Enter your Password ");
			String password = scanner.nextLine();
			
			if ("admin".equals(userName) && "password".equals(password)) {
				System.out.println(" Fabrice, you've successfully logged into Administration!");
				
				AdminMenuController amc = new AdminMenuController();
				amc.adminMenu(); 
				
				System.out.println("Thank you for working as an Administrator Fabrice!");
						 		 
		}
			else if("store owner".equals(userName) && "password".equals(password)) {
			System.out.println(" Boss, you've successfully logged into your Store!");	
			
			StoreMenuController smc = new StoreMenuController();
			smc.storeMenu();
			
			System.out.println("Thank you for logging in as a Store owner!");
		}
			else if("customer".equals(userName) && "password".equals(password) ) {
				System.out.println(" Welcome to Fabrice's Food ordering service! ");	
				
				CustomerMenuController cmc = new CustomerMenuController();
				cmc.customerMenu();
				
				System.out.println("Thank you for shopping today! Hope your experience went well!");
					} 
		
					}
				}
			}

	