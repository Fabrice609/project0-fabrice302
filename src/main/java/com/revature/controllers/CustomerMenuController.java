package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Store;
import com.revature.services.StoreService;

public class CustomerMenuController {

	private StoreService storeService = new StoreService();
	private Scanner scan = new Scanner(System.in);
	
	public void customerMenu() {
		String choice ="";
		menuLoop:
		while(!choice.equals("exit")) {
			System.out.println("What would you like to do? "
					+"\n a. See all of the Stores" 
					+"\n b. Enter the Store ID of where you want to get your food from"
					+ "\n exit");
			
			choice = scan.nextLine();
		
			if(choice.equalsIgnoreCase("a")) {
				List<Store>list = storeService.storeDisplay();
				System.out.println("Here is a list of the Stores: ");
				for(Store s:list) {
					System.out.println(s);
					
				}
				continue;
			}else if(choice.equalsIgnoreCase("exit")) {
				return;
			}else {
				int id = 0;
				try {
						id = Integer.parseInt(choice);
				}catch(NumberFormatException e) {
					System.out.println("wrong entry ID, try again.");
					continue;
				}
				Store store = storeService.getAStore(id);
				System.out.println("Here is your Store: \n "+store);
			}
					
		}
	}
}
