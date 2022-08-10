package com.revature.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.models.Store;
import com.revature.services.StoreService;
import com.revature.utils.ConnectionUtil;



public class AdminMenuController {
	
	private StoreService storeService = new StoreService();
	
	
	//private AdminService adminService = new AdminService();
	private Scanner scan = new Scanner(System.in);
	
	public void adminMenu() {
			String choice ="";
			while(!choice.equals("0")){
				System.out.println("Please type the number to what administrative decison"
						+ " you'd like to make."
						+"\n 1.)  Add a Store to your collection"
						+"\n 2.)  Count the amount of Stores you have" 
						+"\n 3.)  Exit"); 
						
				choice =scan.nextLine();
				switchChoice:
					switch(choice) {
					case"1":
						addorUpdateStore();
						
						break switchChoice;
					case"2": 
						countStore();
						break switchChoice;
					case"3":
						break switchChoice;
						default:
							System.out.println("I'm Sorry, this isn't a correct entry, please try again. ");
							break switchChoice;
					}
			}
	}
	
	private void addorUpdateStore() {
	System.out.println("Please type 'new' to add a new Store");
	String choice = scan.nextLine();
	
	if(choice.equalsIgnoreCase("new")) {
		createStoreMenu();
		}else {	
		}	
	}
	public void createStoreMenu() {
		System.out.println("Success! Let your viewers know about the new Store"
				+ "\n What is the Store's name?");
		
		Store store = new Store();
		store.setStoreName(scan.nextLine());
		
		System.out.println("What is the name of the Item?");
		store.setFoodName(scan.nextLine());
		
		System.out.println("How much does it cost?");
		store.setFoodPrice(Double.parseDouble(scan.nextLine()));
		storeService.newStore(store);
	}
public int countStore (){
		
		try( Connection connection = ConnectionUtil.getConnection()){
				String sql ="SELECT count(*) FROM store; ";
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				result.next();
			int x = result.getInt("count");
			System.out.println("Success! Here are the amount of stores you own: "+x);
			return x;
			
	}catch(SQLException e) {
		e.printStackTrace();	
		
	}
		return 0;
		
}
	
}
