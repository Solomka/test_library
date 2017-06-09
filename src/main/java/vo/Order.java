package vo;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable{

	private int id;

	private OrderStatus status = OrderStatus.UNEXECUTED;

	/** Reference to the user */
	private User user;
	private List<Book> books;

	public Order() {

	}

	public Order(OrderStatus status, User user, List<Book> books) {

		this.status = status;
		this.user = user;
		this.books = books;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
	public OrderStatus setExecutedStatus() {
		return this.status = OrderStatus.EXECUTED;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + ", user=" + user
				+ "]";
	}

}
