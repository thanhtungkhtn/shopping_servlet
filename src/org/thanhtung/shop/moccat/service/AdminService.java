package org.thanhtung.shop.moccat.service;

import org.thanhtung.shop.moccat.ItemListImpl;
import org.thanhtung.shop.moccat.connsqljdbc.ConnectionPool;

public class AdminService {
	
	private static IAdminService dao;
	
	public AdminService() {}
	
	public static IAdminService makeInstance( ConnectionPool conn) {
		
		if(dao == null) {
			dao = new ItemListImpl();
		}
		
		return dao;
	}
}
