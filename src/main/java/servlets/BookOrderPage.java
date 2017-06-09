package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDao;
import dao.BookDaoImpl;
import vo.Book;
import vo.User;



/**
 * Servlet implementation class BookOrderPage
 */
public class BookOrderPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/jsp");    
	     
		BookDao bookDao = new BookDaoImpl();
		List<Book> books = bookDao.getAllBooks();
		System.out.println(books.toString());
		request.setAttribute("books", books);
	 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/allBooks.jsp");
	 dispatcher.forward(request,response);
		        
		
	}

	
}
