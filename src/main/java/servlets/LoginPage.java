package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dao.UserDaoImpl;
import vo.Role;
import vo.User;

public class LoginPage extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String login = (String) request.getParameter("login");
		String pass = request.getParameter("password");

		HttpSession session = request.getSession(false);

		UserDao userDao = new UserDaoImpl();
		User user = userDao.getUser(login, pass);

		if (user != null && user.getRole() == Role.LIBRARIAN) {
			if (session != null)
				session.setAttribute("user", user);
			request.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("librarian.jsp");
			rd.forward(request, response);
		} else if (user != null && user.getRole() == Role.STUDENT) {
			if (session != null)
				session.setAttribute("user", user);
			request.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("student.jsp");
			rd.forward(request, response);

		} else {
			String message = "Wrong login or password. Try again.";
			response.sendRedirect("Library.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			// out.print("<p style=\"color:red\">Wrong login or password. Try
			// again.</p>");
			RequestDispatcher rd = request.getRequestDispatcher("Library.jsp");
			rd.include(request, response);
		}

		out.close();
	}
}