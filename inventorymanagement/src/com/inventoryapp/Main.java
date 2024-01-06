package com.inventoryapp;

import java.util.Scanner;

public class Main {
	
	public static void main(String [] args) {
	String name;
	int id;
	
//	// Create new object of the interface
	InventoryIntrf dao = new InventoryImpl();
	System.out.println("Welcome to the inventory management system");
	Scanner sc = new Scanner(System.in);
	do {
		System.out.println("1. Add a new item: add\n" +
						   "2. Show all items: all\n" +
				           "3. Show item based on ID: search" +
						   "4. Update the item: update");
		System.out.println("Enter option");
		String ch = sc.next();
		
		// Switch statement 
		switch(ch) {
		case "add":
			Inventory item = new Inventory();
			System.out.println("Enter the id of the new item");
			id = sc.nextInt();
			System.out.println("Enter the name of the product");
			name = sc.next();
			System.out.println("Enter the department the item is in");
			String dept = sc.next();
			System.out.println("Enter the quantity of the item");
			int quantity = sc.nextInt();
			item.setId(id);
			item.setItem(name);
			item.setQuantity(quantity);
			item.setDepartment(dept);
			dao.createItem(item);
			break;
		case "all":
			dao.showAllItems();
			break;
		case "exit":
			System.out.println("Closing the program.");
			sc.close();
			System.exit(0);
		case "search":
			System.out.println("Enter the ID of the item");
			id = sc.nextInt();
			dao.searchItemByID(id);
			break;
		case "update":
			System.out.println("Enter the ID of the item to update");
			id = sc.nextInt();
			System.out.println("What would you like to update?\n" +
								"1. Name\n" + 
								"2. Quantity");
			int choice = sc.nextInt();
			if (choice == 1) {
				System.out.println("Enter the new name of the item");
				String newName = sc.next();
				dao.updateItemName(id, newName);
			}
			if (choice == 2) {
				System.out.println("Enter the updated quantity");
				int Newquantity = sc.nextInt();
				dao.updateItemQuantity(id, Newquantity);
			}
		default:
			System.out.println("Please enter a valid option");
			}
		} while(true);
	
	}
}
