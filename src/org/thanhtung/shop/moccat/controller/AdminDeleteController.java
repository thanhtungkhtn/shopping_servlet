package org.thanhtung.shop.moccat.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thanhtung.shop.moccat.CartBean;
import org.thanhtung.shop.moccat.Item;
import org.thanhtung.shop.moccat.connsqljdbc.ConnectionPool;
import org.thanhtung.shop.moccat.service.AdminService;
import org.thanhtung.shop.moccat.service.IAdminService;

/**
 * Servlet implementation class AdminDeleteController
 */
@WebServlet("/AdminDeleteController")
public class AdminDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static ConnectionPool connpool;

	CartBean cart = new CartBean();
	Map<String, Item> listitems;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			deleteItem( request,  response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	private void deleteItem(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		IAdminService list = AdminService.makeInstance(connpool); // dao
		
		String itemID = request.getParameter("itemID");

		// item = new Item(itemID);
		list.deleteItem(itemID);
		response.sendRedirect("list");

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
