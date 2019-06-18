package org.thanhtung.shop.moccat.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thanhtung.shop.moccat.CartBean;
import org.thanhtung.shop.moccat.Item;
import org.thanhtung.shop.moccat.ItemListImpl;
import org.thanhtung.shop.moccat.ItemOrderBean;
import org.thanhtung.shop.moccat.connsqljdbc.ConnectionPool;
import org.thanhtung.shop.moccat.service.AdminService;
import org.thanhtung.shop.moccat.service.IAdminService;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// IAdminService list = new ItemList(); //beans list item // khai baos
	private static ConnectionPool connpool;
	
	CartBean cart = new CartBean();
	Map<String, Item> listitems;

	private String[] itemIDs;
	private String title = "Wellcome to Thanh Tung Shop";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void setTitle(String title) {
		this.title = title;
	}

	protected void setItems(String[] itemIDs) {
		this.itemIDs = itemIDs;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			listItem(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void listItem(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		IAdminService list = AdminService.makeInstance(connpool); // dao

		try {
			listitems = list.getData();

			if (listitems.size() == 0) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("notItem.jsp");
				dispatcher.forward(request, response);
			} else {
				System.out.println("size la_" + listitems.size());

				request.setAttribute("listitems", listitems);

				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
