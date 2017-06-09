package dao;

import java.util.List;

import vo.Order;

public interface OrderDao {

	// reader
	public void addOrder(Order order);

	public List<Order> getReaderOrders(int orderId);

	// librarian
	public List<Order> getAllOrders();

	public Order getOrder(int orderId);

	public List<Order> getUnexecutedOrders();

	public void updateOrder(Order order);

	public void deleteOrder(int orderId);

}
