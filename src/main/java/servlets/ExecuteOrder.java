package servlets;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDao;
import dao.OrderDaoImpl;
import vo.Order;
import vo.OrderStatus;

/**
 * Servlet implementation class ExecuteOrder
 */

public class ExecuteOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExecuteOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		System.out.println("orderId: " + orderId);

		OrderDao orderDao = new OrderDaoImpl();
		Order order = orderDao.getOrder(orderId);
		order.setStatus(OrderStatus.EXECUTED);
		orderDao.updateOrder(order);
		System.out.println("Updated order: " + order);
		String message = "Order is executed";
		response.sendRedirect("AllOrdersExecute?message=" + URLEncoder.encode(message, "UTF-8"));

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
