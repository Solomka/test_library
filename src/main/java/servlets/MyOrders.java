package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import vo.Book;
import vo.Order;
import vo.User;
import dao.BookDao;
import dao.BookDaoImpl;
import dao.OrderDao;
import dao.OrderDaoImpl;

/**
 * Servlet implementation class MyOrders
 */

public class MyOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyOrders() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/jsp");  
		 
		 HttpSession session = request.getSession(false);  
		 User user = (User) session.getAttribute("user");
		 System.out.println("User id: "+ user.getId());
		 
			OrderDao orderDao = new OrderDaoImpl();
			List<Order> orders = orderDao.getReaderOrders(user.getId());
			System.out.println(orders.toString());
			request.setAttribute("orders", orders);
		 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/myOrders.jsp");
		 //redirect
		 dispatcher.forward(request,response);
	}

	

}
