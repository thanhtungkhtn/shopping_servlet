/**
 * 
 */
package org.thanhtung.shop.moccat.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import org.thanhtung.shop.moccat.Item;

/**
 * @author Thanh_Tung
 *
 */
public interface IAdminService {
		
	public Map<String, Item> getData() throws SQLException, ClassNotFoundException, IOException;
	
	//public Item search(String itemID);
	
	//Crud // design parttern data access
	public boolean insertItem(Item item) throws SQLException;
	public Item detailItem(String itemID) throws SQLException;
	
	public boolean deleteItem(String itemID) throws SQLException;

	boolean editItem(String itemID, String itemName, String imagePath, double price) throws SQLException;	
}
