package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Order;
import dao.OrderDao;
import dao.OrderDaoImpl;

/**
 * Servlet implementation class AllOrders
 */

public class AllOrdersExecute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AllOrdersExecute() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/jsp");

		OrderDao orderDao = new OrderDaoImpl();
		List<Order> orders = orderDao.getAllOrders();
		System.out.println(orders.toString());
		request.setAttribute("orders", orders);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/executeOrders.jsp");
		dispatcher.forward(request, response);
	}

}
