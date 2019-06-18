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
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static ConnectionPool connpool;

	CartBean cart = new CartBean();
	Map<String, Item> listitems;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Admin() {
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
				response.sendError(0, "Not exist Product^^");;
			} else {
				System.out.println("size la: " + listitems.size());

				request.setAttribute("product", listitems);

				RequestDispatcher dispatcher = request.getRequestDispatcher("ManagementItem.jsp");
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
