package com.retail.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.retail.core.Cities;
import com.retail.core.Employees;
import com.retail.core.Item;
import com.retail.core.Products;

/**
 * Servlet implementation class ShippingServlet
 */
@WebServlet("/ShippingServlet")
public class ShippingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Item> myItems = Products.getItems();
		request.getSession().setAttribute("items", myItems);

		request.setAttribute("employees", Employees.getAvailableEmployees());

		request.setAttribute("cities", Cities.getCities());

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/shipment.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Do Post Called");
		String[] checkedIds = request.getParameterValues("checkedRows");
		List<Item> shipItems = (List<Item>) request.getSession().getAttribute("items");

		for (Iterator<Item> iter = (Iterator<Item>) shipItems.listIterator(); iter.hasNext();) {
			if (!(Arrays.asList(checkedIds).contains(iter.next().getUpc()))) {
				iter.remove();
			}

		}

		double total = 0.0;
		for (Item item : shipItems) {
			total += item.calculateShippingCost();
		}

		request.setAttribute("employee", request.getParameter("availableEmployees"));
		request.setAttribute("total", total);
		request.getSession().setAttribute("shipItems", shipItems);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/shipConfirmation.jsp");
		dispatcher.forward(request, response);
	}

}
