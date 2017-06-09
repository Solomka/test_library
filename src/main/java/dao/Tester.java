package dao;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import vo.Book;
import vo.Order;
import vo.Role;
import vo.User;

public class Tester {
	public static void main(String[] args) throws RemoteException {
		// ------------------------------ Book testing
		
	BookDao bookDao = new BookDaoImpl();
		
		 Book book1 = new Book(); 
		 book1.setId(1);
		 book1.setTitle("C++");
		 book1.setAuthorName("Bjarne");
		 book1.setAuthorSurname("Stroustrup");
		 //bookDao.addBook(book1);
		 Book book2 = new Book(); 
		 book2.setId(2);
		 book2.setTitle("Java");
		 book2.setAuthorName("David");
		 book2.setAuthorSurname("Etheridge");
		 //bookDao.addBook(book2);

		// delete book

		// bookDao.deleteBook(1);
		

	
		 Book intr = bookDao.getBook(1);
		 System.out.println("Book with id  " +
		 intr.getId() + " " + intr.toString());
		
	
		System.out.println();
		System.out
				.println("-------------------------Print all the Books--------------------------------Start ");

		// print all Books
		for (Book book : bookDao.getAllBooks()) {
			System.out.println(book.toString());
		}

		System.out
				.println("-------------------------Print all the Books-------------------------------- End");
		System.out.println();

		
	
	
		// ------------------------------ User testing

	   UserDao userDao = new UserDaoImpl();
		
		User user = new User();
		user.setId(1);
		user.setLogin("sonka");
		user.setPassword("sonka");
		user.setName("Sofiya");
		user.setSurname("Yaremko");
		user.setRole(Role.STUDENT);
		//userDao.addUser(user);
				

		// delete
		//userDao.deleteUser(1);

		// getReader
	  
		User r = userDao.getUser("sonka", "sonka");
		//System.out.println("Reader (getReader) = " + r);

		User r2 = userDao.getUser(1);
	//	System.out.println("Reader (getReader id) = " + r2);

	   
		// ------------------------------ Order testing
		
		/*
		OrderDao orderDao = new OrderDaoImpl();
			
		Order order1 = new Order();
		order1.setId(1);
		order1.setUser(userDao.getUser("sonka", "sonka"));
		
		List<Book> books = new ArrayList<Book>(); 
		books.add(book1);
		books.add(book2);
		
		order1.setBooks(books);
		
		//orderDao.addOrder(order1);
	
	//getOrder(id)
		Order getTest = orderDao.getOrder(1);
		System.out.println("Order (getOrder): "+ getTest);
		
		//updateOrder
		getTest.setExecutedStatus();
		orderDao.updateOrder(getTest);
		System.out.println("Order (updateOrder): "+ getTest);
		
		System.out.println();
		System.out
				.println("-------------------------Print all the Orders of reader--------------------------------Start ");

		// print all Books
		for (Order order : orderDao.getReaderOrders(2)) {
			System.out.println(order);
		}

		System.out
				.println("-------------------------Print all the Orders of reader- -------------------------------- End");
		System.out.println();
		
		
		System.out.println();
		System.out
				.println("-------------------------Print all the UNEXECUTED Orders -------------------------------Start ");

		// print all Books
		for (Order order : orderDao.getUnexecutedOrders()) {
			System.out.println(order.toString());
		}

		System.out
				.println("-------------------------Print all the UNEXECUTED Orders-------------------------------- End");
		System.out.println();
		
		
		System.out.println();
		System.out
				.println("-------------------------Print all the Orders--------------------------------Start ");

		// print all Books
		for (Order order : orderDao.getAllOrders()) {
			System.out.println(order.toString());
		}

		System.out
				.println("-------------------------Print all the Orders-------------------------------- End");
		System.out.println();
		*/
		
		// ------------------------------ BookOrder testing
		OrderBookDao oBDao = new OrderBookDaoImpl();
		
		System.out.println();
		System.out
				.println("-------------------------Print Order Books--------------------------------Start ");

		// print all Books
		for (Book book : oBDao.getOrderBooks(2)) {
			System.out.println(book);
		}

		System.out
				.println("-------------------------Print Order Books-------------------------------- End");
		System.out.println();
	
	}

}

