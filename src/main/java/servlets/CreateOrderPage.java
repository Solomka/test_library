package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDao;
import dao.OrderDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import vo.Order;
import vo.User;

/**
 * Servlet implementation class CreateOrderPage
 */

public class CreateOrderPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateOrderPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json");

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);

		OrderDao orderDao = new OrderDaoImpl();
		UserDao userDao = new UserDaoImpl();

		Order order = new Order();

		User user = (User) session.getAttribute("user");
		System.out.println("User id: " + user.getId());

		String[] booksId = request.getParameterValues("books");
		System.out.println(booksId.toString());
		// JSONObject newObj = new JSONObject()

		// order.setUser(user);
		// order.setBooks(books);
		// orderDao.addOrder(order);

		/*
		 * JSONObject newObj=null; int id = 0; List<Book> books = null; String
		 * json =""; json = request.getParameter("jsonOrder"); newObj =
		 * (JSONObject) JSONValue.parse(json);
		 * 
		 * 
		 * 
		 * try {
		 * 
		 * 
		 * id = Integer.parseInt(newObj.getJSONObject("order").getString("id"));
		 * books = (List<Book>)
		 * (newObj.getJSONObject("order").getJSONArray("books")); } catch
		 * (JSONException e) { e.printStackTrace(); }
		 */

	}

}
