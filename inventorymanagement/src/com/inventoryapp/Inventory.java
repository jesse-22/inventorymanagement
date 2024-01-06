package com.inventoryapp;

public class Inventory {
	private String item;
	private String department;
	private int quantity;
	private int id;
	


	// Default constructor 
	public Inventory() {
		
	}
	
	// Constructor 
	public Inventory(String item, String department, int quantity) {
		this.item = item;
		this.department = department;
		this.quantity = quantity;
	}

	// Getters and setters
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", quantity=" + quantity + ", department=" + department + "]";
	}
	
}
