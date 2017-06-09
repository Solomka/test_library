package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.Book;

public class OrderBookDaoImpl implements OrderBookDao {

	public List<Book> getOrderBooks(int orderId) {
		DataSource dataSource = new DataSource();
		Connection con = dataSource.createConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<Book> bookList = new ArrayList<Book>();
		BookDao bookDao = new BookDaoImpl();
		try {
			String query = "SELECT * FROM bookorder WHERE order_id=" + orderId;
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Book book = bookDao.getBook(rs.getInt("book_id"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception exe) {
				exe.printStackTrace();
			}

		}
		return bookList;

	}

}
