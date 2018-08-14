package com.retail.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.retail.core.Cities;

/**
 * Servlet implementation class CitiesServlet
 */
@WebServlet("/CitiesServlet")
public class CitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fromTo = request.getParameter("fc") + "-" + request.getParameter("tc");
		String toFrom = request.getParameter("tc") + "-" + request.getParameter("fc");

		Map<String, String> destinations = Cities.getDistanceMap();

		String dist = "0000";
		if ((destinations.containsKey(fromTo)) || (destinations.containsKey(toFrom))) {
			dist = destinations.get(fromTo);
		}

		response.setContentType("text/plain"); // Set content type of the response so that jQuery knows what it can
												// expect.
		response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
		response.getWriter().write(dist);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}
}
