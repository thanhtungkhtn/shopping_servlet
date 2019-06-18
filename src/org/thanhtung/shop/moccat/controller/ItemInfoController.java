package org.thanhtung.shop.moccat.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thanhtung.shop.moccat.CartBean;
import org.thanhtung.shop.moccat.Item;
import org.thanhtung.shop.moccat.ItemListImpl;
import org.thanhtung.shop.moccat.connsqljdbc.ConnectionPool;
import org.thanhtung.shop.moccat.service.AdminService;
import org.thanhtung.shop.moccat.service.IAdminService;

/**
 * Servlet implementation class ItemInfoController
 */
@WebServlet("/ItemInfoController")
public class ItemInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static ConnectionPool connpool;
	
	private Item item;
	// ItemListImpl listitem = new ItemListImpl(); // user
	CartBean cart = new CartBean();
	Map<String, Item> listitems;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemInfoController() {
		super();
		// TODO Auto-generated constructor stub
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
			showDetail(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showDetail(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		IAdminService list = AdminService.makeInstance(connpool); // dao

		// int id = Integer.parseInt(request.getParameter("id"));
		String itemID = request.getParameter("itemID");
		
		item = list.detailItem(itemID);
		//item = ItemListImpl.search(itemID);

		request.setAttribute("item", item);

		RequestDispatcher dispatcher = request.getRequestDispatcher("itemInfo.jsp");
		dispatcher.forward(request, response);
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
