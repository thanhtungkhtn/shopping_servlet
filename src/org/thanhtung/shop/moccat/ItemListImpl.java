package org.thanhtung.shop.moccat;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import org.thanhtung.shop.moccat.connsqljdbc.ConnUtils_SQLJDBC;
import org.thanhtung.shop.moccat.connsqljdbc.ConnectionPool;
import org.thanhtung.shop.moccat.service.IAdminService;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ItemListImpl implements IAdminService {
	private static Map<String, Item> items;
	public Connection conn;
	private ConnectionPool connection;
	boolean created = false;
	private ResultSet rs;

	public ItemListImpl() {

	}

//	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
//
//		new ItemListImpl().createData();
//	}

	public void setItemList(Map<String, Item> items) {
		this.items = items;
	}

	// protected // statics
	public Connection connect() throws SQLException, ClassNotFoundException {
		if (conn == null || conn.isClosed()) {
			System.out.println("Get connection ... ");

			// conn = ConnUtils_SQLJDBC.getSQLConnection(); // connect

			connection = new ConnectionPool("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/shop", "root", "root",
					20, 50, true);

			conn = connection.getConnection();

			if (conn != null) {
				
				DatabaseMetaData info = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + info.getDriverName());
				System.out.println("Driver version: " + info.getDriverVersion());
				System.out.println("Product name: " + info.getDatabaseProductName());
				System.out.println("Product version: " + info.getDatabaseProductVersion());

				System.out.println("\nConnect successfully!!");
				System.out.println("\nDone!");

				System.out.println("\nGet connection = " + conn);
				System.out.println("\n---------------------------");
				
				System.out.println("Total connection " + connection.totalConnections());
				System.out.println(connection.toString());
				System.out.println("\n---------------------------");

				return conn;
			}
		}
		return conn;
	}

	// protected
	public void disconnect() throws SQLException {
		if (conn != null && !conn.isClosed()) {
			
			connection.free(conn);
			
			System.out.println("Total connection " + connection.totalConnections());
			System.out.println(connection.toString());
		}
	}

	public boolean insertItem(Item e) throws SQLException {
		String sql = "INSERT INTO Shop (itemID, itemName, imagePath, cost) VALUES (?, ?, ?, ?)";

		try {
			//connect();

			PreparedStatement statement = (PreparedStatement) connect().prepareStatement(sql);
			statement.setString(1, e.getItemID());
			statement.setString(2, e.getItemName());
			statement.setString(3, e.getImagePath());
			statement.setDouble(4, e.getCost());

			boolean rowInserted = statement.executeUpdate() > 0;
			statement.close();
			disconnect();
			return rowInserted;

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return true;
	}

	public boolean createData() throws ClassNotFoundException {
		try {

			// Creating table in given database...
			// check exist table

			Statement stmt = connect().createStatement();

			String sql = "CREATE TABLE Shop( id int(11) NOT NULL AUTO_INCREMENT, itemID VARCHAR(30), itemName VARCHAR(255), imagePath VARCHAR(255), cost VARCHAR(255), CONSTRAINT Shop PRIMARY KEY (id))";
			stmt.executeUpdate(sql);

			stmt.executeUpdate("INSERT INTO Shop(itemID, itemName, imagePath, cost)"
					+ "VALUES ('A1', '<b>Book Foo</b>', 'pic01.png', '22')");
			stmt.executeUpdate("INSERT INTO Shop(itemID, itemName, imagePath, cost)"
					+ "VALUES ('A2', '<b>Book Mathematics</b> (Analytical Book Tuan Teacher)', 'pic01.png', '299.99')");
			stmt.executeUpdate("INSERT INTO Shop(itemID, itemName, imagePath, cost)"
					+ "VALUES ('A3', '<b>Book Mathematics</b> for graduate 10 with Some subject Mathematics', 'pic01.png', '199')");
			stmt.executeUpdate("INSERT INTO Shop(itemID, itemName, imagePath, cost)"
					+ "VALUES ('A4', '<b>Analytics 1A DUONG MINH DUC Professor</b> Basic Analys for feshman', 'pic01.png', '999')");
			stmt.executeUpdate("INSERT INTO Shop(itemID, itemName, imagePath, cost)"
					+ "VALUES ('B1', '<b>Truyen Kieu</b> by Nguyen Du', 'pic01.png', '599.99')");

			stmt.close();
			disconnect();

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public void CreateItem(Item item) {
		items.put(item.getItemID(), item);
	}

	public Map<String, Item> setData() throws SQLException, ClassNotFoundException, IOException {
		try {
			items = new HashMap<String, Item>();

			Statement stmt = connect().createStatement();
			String data = "SELECT * FROM Shop";
			rs = stmt.executeQuery(data);

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

				CreateItem(new Item(itemID, itemName, imagePath, prices));
			}
			rs.close();
			stmt.close();
			disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (items.isEmpty()) {
			// No users found in database
			return null;
		}
		return (items);
	}

	public Map<String, Item> getData() throws SQLException, ClassNotFoundException, IOException {

		try {

			// createData(); // set data sql
			setData();

			return (items);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (items);
	}

	@Override
	public boolean deleteItem(String itemID) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Shop where itemID = ?";

		try {
			//connect();
			
			PreparedStatement statement = (PreparedStatement) connect().prepareStatement(sql);
			statement.setString(1, itemID);

			boolean rowDeleted = statement.executeUpdate() > 0;
			statement.close();
			disconnect();
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editItem(String itemID, String itemName, String imagePath, double price) throws SQLException {
		String sql = "UPDATE Shop SET itemID = ?, itemName = ?, imagePath = ?, cost = ?";
		sql += " WHERE itemID = ?";
		try {
			//connect();

			PreparedStatement statement = (PreparedStatement) connect().prepareStatement(sql);
			statement.setString(1, itemID);
			statement.setString(2, itemName);
			statement.setString(3, imagePath);
			statement.setDouble(4, price);
			// WHERE
			statement.setString(5, itemID);

			boolean rowUpdated = statement.executeUpdate() > 0;
			statement.close();
			disconnect();
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Item detailItem(String itemID) throws SQLException {
		Item item = null;
		String sql = "SELECT * FROM Shop WHERE itemID = ?";

		try {
			//connect();

			PreparedStatement statement = (PreparedStatement) connect().prepareStatement(sql);
			statement.setString(1, itemID);

			rs = statement.executeQuery();

			if (rs.next()) {
				itemID = rs.getString("itemID");
				String itemName = rs.getString("itemName");
				String imagePath = rs.getString("imagePath");
				String cost = rs.getString("cost");

				double prices = Double.parseDouble(cost);

				item = new Item(itemID, itemName, imagePath, prices);

				System.out.print("itemID: " + item.getItemID());
				System.out.print(", itemName: " + item.getItemName());
				System.out.print(", imagePath: " + item.getImagePath());
				System.out.println(", cost: " + item.getCost());
			}

			disconnect();
			statement.close();

			return item;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// ---------------------------------------------//
	// ---------------------------------------------//
	public static Item search(String itemID) {
		Item item;
		if (itemID == null) {
			return (null);
		}

		for (String key : items.keySet()) {
			if (key.equals(itemID)) {
				item = items.get(key);
				return (item);
			}
		}
		/*
		 * for (int i = 0; i < arrItem.size(); i++) { item = arrItem.get(i); if
		 * (itemID.equals(item.getItemID())) { return (item); } }
		 */
		return (null);
	}
}
