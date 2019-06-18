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
import org.thanhtung.shop.moccat.connsqljdbc.ConnectionPool;
import org.thanhtung.shop.moccat.service.AdminService;
import org.thanhtung.shop.moccat.service.IAdminService;

/**
 * Servlet implementation class AdminEditController
 */
@WebServlet("/AdminEditController")
public class AdminEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static ConnectionPool connpool;
	private Item item;
	// ItemListImpl listitem = new ItemListImpl(); // user
	CartBean cart = new CartBean();
	Map<String, Item> listitems;
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String itemName = request.getParameter("itemName");
		try {
			
			if (itemName == null) {
				showEditForm(request, response);
			} else {
				update( request,  response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		IAdminService list = AdminService.makeInstance(connpool); // dao
		
		String itemID = request.getParameter("itemID");
		String itemName = request.getParameter("itemName");
		String imagePath = request.getParameter("imagePath");

		double price = Double.parseDouble(request.getParameter("price"));
		//String price = request.getParameter("price");
		
//		item = (Item) request.getAttribute("EditItem");
		
//		System.out.print("itemID: " + item.getItemID());
//		System.out.print(", itemName: " + item.getItemName());
//		System.out.print(", imagePath: " + item.getImagePath());
//		System.out.println(", cost: " + item.getCost());
		
		list.editItem(itemID, itemName, imagePath, price);
//
		response.sendRedirect("Admin");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		IAdminService list = AdminService.makeInstance(connpool); // dao

		System.out.println("edit: " + request.getParameter("itemID"));
		// int id = Integer.parseInt(request.getParameter("id"));
		String itemID = request.getParameter("itemID");
		// item = list.search(itemID);

		item = list.detailItem(itemID);
		
		request.setAttribute("EditItem", item);

		RequestDispatcher dispatcher = request.getRequestDispatcher("formEdit.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
