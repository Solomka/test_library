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

import vo.Book;
import vo.Order;
import vo.Role;
import vo.User;
import dao.OrderBookDao;
import dao.OrderBookDaoImpl;
import dao.OrderDao;
import dao.OrderDaoImpl;

/**
 * Servlet implementation class OrderDetails
 */

public class OrderDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/jsp");  
		
		 int orderId = Integer.parseInt(request.getParameter("orderId"));
		 System.out.println("orderId: "+ orderId);
		 
		 HttpSession session = request.getSession(false);
		 User user = (User) session.getAttribute("user");
		 
		
			OrderBookDao orderBookDao = new OrderBookDaoImpl();
			List<Book> books = orderBookDao.getOrderBooks(orderId);
			System.out.println(books.toString());
			request.setAttribute("oBooks", books);
			if(user.getRole() == Role.STUDENT){
		 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/myOrderDetails.jsp");
		 dispatcher.forward(request,response);	
			}
			else{
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/allOrdersDetails.jsp");
				 dispatcher.forward(request,response);	
			}
		
	}

	

}
