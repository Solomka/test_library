package dao;

import java.util.List;

import vo.Book;

public interface BookDao {

	public List<Book> getAllBooks();

	public void addBook(Book book);

	public Book getBook(int bookId);

	public void updateBook(Book book);

	public void deleteBook(int bookId);

	// public List<Book> getOrderedBooks() throws RemoteException;

}
