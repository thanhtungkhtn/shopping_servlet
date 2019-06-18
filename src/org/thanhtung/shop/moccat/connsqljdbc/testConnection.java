package org.thanhtung.shop.moccat.connsqljdbc;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


public class testConnection {
	public static void main(String[] args) {
		try {
			
			
			ConnectionPool conn = new ConnectionPool("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/shop", "root", "root", 20, 50, true);
			
			Connection connection = conn.getConnection();
	
			System.out.println(conn.totalConnections());
			
			System.out.println(conn.toString());
			
			//conn.closeAllConnections();
			
			String query ="SELECT * FROM Shop";
			
			Statement stmt = connection.createStatement();   
			ResultSet rs = stmt.executeQuery(query);
			     
			while (rs.next()) {
				// Retrieve by column name
				String itemID = rs.getString("itemID");
				String itemName = rs.getString("itemName");
				String imagePath = rs.getString("imagePath");
				String cost = rs.getString("cost");

				double prices = Double.parseDouble(cost);

				System.out.print("itemID: " + itemID);
				System.out.print(", itemName: " + itemName);
				System.out.print(", imagePath: " + imagePath);
				System.out.println(", cost: " + cost);
			}
			
			System.out.println(conn.toString());
			
			System.out.println(rs.toString());
			rs.close();
			System.out.println(rs.isClosed());
			System.out.println(rs.toString());
			
			System.out.println(stmt.isClosed());
			System.out.println(stmt.toString());		
			stmt.close();
			System.out.println(stmt.isClosed());
			
			conn.free(connection);
			
			System.out.println(conn.toString());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
