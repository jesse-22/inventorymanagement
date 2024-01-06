package com.inventoryapp;

public interface InventoryIntrf {
	// Create item
	public void  createItem(Inventory item);
	// Show all items
	public void showAllItems();
	// Show item based on id
	public void searchItemByID(int id);
	// Update item name
	public void updateItemName(int id, String name);
	// Update item quantity 
	public void updateItemQuantity(int id, int quantity);
}
