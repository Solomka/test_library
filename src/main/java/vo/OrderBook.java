package vo;

import java.io.Serializable;

public class OrderBook implements Serializable{
	private Book idBook;
	private Order idUser;

	public OrderBook() {

	}

	public OrderBook(Book idBook, Order idUser) {
		super();
		this.idBook = idBook;
		this.idUser = idUser;
	}

	public Book getIdBook() {
		return idBook;
	}

	public void setIdBook(Book idBook) {
		this.idBook = idBook;
	}

	public Order getIdUser() {
		return idUser;
	}

	public void setIdUser(Order idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		return "OrderBook [idBook=" + idBook + ", idUser=" + idUser + "]";
	}

}
