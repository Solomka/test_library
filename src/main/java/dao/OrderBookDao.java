package dao;

import java.util.List;

import vo.Book;

public interface OrderBookDao {
	public List<Book> getOrderBooks(int orderId);

}
