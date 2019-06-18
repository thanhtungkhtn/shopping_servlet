package org.thanhtung.shop.moccat;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
//import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

//import java.util.List;

public class test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		
		ItemListImpl a=	new ItemListImpl();
		
		a.connect();
		a.disconnect();
		
	}

	public test() {

	}
}