package com.inventoryapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InventoryImpl implements InventoryIntrf {
	Connection con;

	// Create an item in the database
	@Override
	public void createItem(Inventory item) {
		// Create the connection 
		con = DBConnection.createDBConnection();
		
		// Write the command 
		String query = "insert into inventory values(?,?,?,?)";
		
		try {
			// Prepare the query command for SQL
			PreparedStatement pstm = con.prepareStatement(query);
			// Set/Get the item's id
			pstm.setInt(1, item.getId());
			// Set/Get the name of the item 
			pstm.setString(2, item.getItem());
			// Set/Get the department the item is in 
			pstm.setString(3, item.getDepartment());
			// Set/Get the quantity of the item 
			pstm.setInt(4, item.getQuantity());
			int cnt = pstm.executeUpdate();
			if (cnt!=0) {
				
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	// Show all items in the database
	@Override
	public void showAllItems() {
		// Create the connection 
		con = DBConnection.createDBConnection();
		
		// Write the query command
		String query = "select * from inventory";
		System.out.println("Iventory Details :");
		System.out.format("%s\t%s\t%s\t%s\n", "ID", "Item", "Dept", "Quantity");
		try {
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				System.out.format("%d\t%s\t%s\t%d\n",
						result.getInt(1),
						result.getString(2),
						result.getString(3),
						result.getInt(4));
				System.out.println("_____________________");
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	// Search item by ID
	@Override
	public void searchItemByID(int id) {
		con = DBConnection.createDBConnection();
		String query = "select * from inventory where id=" + id;
		System.out.println("Search results: ");
		System.out.format("%s\t%s\t%s\t%s\n", "ID", "Item", "Dept", "Quantity");
		try {
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				System.out.format("%d\t%s\t%s\t%d\n",
						result.getInt(1),
						result.getString(2),
						result.getString(3),
						result.getInt(4));
				System.out.println("_____________________");
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	// Update the item's name
	@Override
	public void updateItemName(int id, String name) {
		con = DBConnection.createDBConnection();
		String query = "update inventory set item=? where id=?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, name);
			pstm.setInt(2, id);
			int cnt = pstm.executeUpdate();
			if (cnt!=0) {
				System.out.println("Successfully updated the item name");
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	// Update the item's quantity 
	@Override
	public void updateItemQuantity(int id, int quantity) {
		con = DBConnection.createDBConnection();
		String query = "update inventory set quantity=? where id=?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, quantity);
			pstm.setInt(2, id);
			int cnt = pstm.executeUpdate();
			if (cnt!=0) {
				System.out.println("Successfully updated the item name");
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}

}
