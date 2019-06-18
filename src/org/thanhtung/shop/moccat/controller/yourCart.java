package org.thanhtung.shop.moccat.controller;

import java.io.IOException;
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
import org.thanhtung.shop.moccat.ItemOrderBean;
import org.thanhtung.shop.moccat.connsqljdbc.ConnectionPool;
import org.thanhtung.shop.moccat.service.AdminService;
import org.thanhtung.shop.moccat.service.IAdminService;

/**
 * Servlet implementation class yourCart
 */
@WebServlet("/yourCart")
public class yourCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	private static ConnectionPool connpool;
	
	CartBean cart = new CartBean();
	Map<String, Item> listitems;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public yourCart() {
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		loadCart(request,response );
	}

	protected void loadCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//IAdminService list = AdminService.makeInstance(connpool); // dao

		String itemID = request.getParameter("itemID");
		String address;

		System.out.println("Id" + itemID);
		HttpSession session = request.getSession();

		synchronized (session) {
			cart = (CartBean) session.getAttribute("shoppingCart");
			if (cart == null) {
				cart = new CartBean();
				session.setAttribute("shoppingCart", cart);
			}

			if (itemID != null) {
				// cách khác
				String numItemsString = request.getParameter("numItems");
				if (numItemsString == null) {
					cart.addItem(itemID);
				} else if (numItemsString != null) {
					int numItems;
					try {
						numItems = Integer.parseInt(numItemsString);
					} catch (NumberFormatException nfe) {
						numItems = 0;
					}
					cart.setNumOrdered(itemID, numItems);
				}
			}

			Map<String, ItemOrderBean> itemsOrdered = cart.getCart();
			if (itemsOrdered.isEmpty()) {
				address = "/notItem.jsp";
			} else {
				System.out.println(itemsOrdered.size());

				NumberFormat formatter = NumberFormat.getCurrencyInstance();

				request.setAttribute("itemsOrdered", itemsOrdered);
				request.setAttribute("formatter", formatter);

				System.out.println(cart.totalprices());
				request.setAttribute("prices", cart.totalprices());

				address = "/cart.jsp";
			}
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
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
