package dao;

import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.Book;
import vo.Order;
import vo.OrderStatus;
import vo.User;

public class OrderDaoImpl implements OrderDao {

	@Override
	public void addOrder(Order order) {
		try {
			Connection conn = null;
			PreparedStatement preparedStmt = null;

			DataSource dataSource = new DataSource();
			conn = dataSource.createConnection();

			String query = "INSERT INTO `order` (order_id, user_id, status) VALUES (?, ?, ?)";

			User user = order.getUser();

			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, order.getId());
			preparedStmt.setInt(2, user.getId());
			preparedStmt.setString(3, order.getStatus().toString());
			preparedStmt.execute();

			System.out
			.println("Record is inserted into order for  order : "
					+ order.getId());
			
			String query2 = "INSERT INTO `bookorder` (book_id, order_id) VALUES (?, ?)";

			List<Book> books = order.getBooks();

			preparedStmt = conn.prepareStatement(query2);
			for (Book book : books) {
				preparedStmt.setInt(1, book.getId());
				preparedStmt.setInt(2, order.getId());
				preparedStmt.addBatch();
			}
			preparedStmt.executeBatch();
			
			System.out
			.println("Record is inserted into bookorder for  order : "
					+ order.getId());

			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}

		
	}
	
	@Override
	// вивести всі замовлення певного читача
	public List<Order> getReaderOrders(int readerId) {
		DataSource dataSource = new DataSource();
		Connection con = dataSource.createConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<Order> orderList = new ArrayList<Order>();
		try {
			String query = "SELECT * FROM `order` where user_id="
					+ readerId;
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("order_id"));
				
				UserDao userDao = new UserDaoImpl();
				User readerRef = userDao.getUser(rs.getInt("user_id"));
				order.setUser(readerRef);
				
				order.setStatus(OrderStatus.valueOf(rs.getString("status")));
					
				orderList.add(order);
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
		return orderList;
	}

	@Override
	public List<Order> getAllOrders() {
		DataSource dataSource = new DataSource();
		Connection con = dataSource.createConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<Order> orderList = new ArrayList<Order>();
		try {
			String query = "SELECT * \n FROM  `order`";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("order_id"));
				
				UserDao userDao = new UserDaoImpl();
				User readerRef = userDao.getUser(rs.getInt("user_id"));
				order.setUser(readerRef);
				
				order.setStatus(OrderStatus.valueOf(rs.getString("status")));
					
				orderList.add(order);

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
		return orderList;
	}


	@Override
	public Order getOrder(int orderId) {
		DataSource dataSource = new DataSource();
		Connection con = dataSource.createConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM `order` where order_id=" + orderId;
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("order_id"));
				
				UserDao userDao = new UserDaoImpl();
				User readerRef = userDao.getUser(rs.getInt("user_id"));
				order.setUser(readerRef);
				
				order.setStatus(OrderStatus.valueOf(rs.getString("status")));

				return order;
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
		return null;

	}

	// вивести всі замовлення, які є UNEXECUTED
	@Override
	public List<Order> getUnexecutedOrders() {
		DataSource dataSource = new DataSource();
		Connection con = dataSource.createConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<Order> orderList = new ArrayList<Order>();
		try {
			String query = "SELECT * FROM `order` where status=" + "'"
					+ OrderStatus.UNEXECUTED + "'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("order_id"));
				
				UserDao userDao = new UserDaoImpl();
				User readerRef = userDao.getUser(rs.getInt("user_id"));
				order.setUser(readerRef);
				
				order.setStatus(OrderStatus.valueOf(rs.getString("status")));
				orderList.add(order);
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
		return orderList;
	}

	@Override
	public void updateOrder(Order order) {
		Connection dbConnection = null;
		Statement statement = null;

		String sql = "update `order` set status= " + "'"
				+ order.setExecutedStatus() + "'" + " where order_id="
				+ order.getId();
		try {
			DataSource dataSource = new DataSource();
			dbConnection = dataSource.createConnection();
			statement = dbConnection.prepareStatement(sql);
			statement.executeUpdate(sql);

			System.out
					.println("Record is updated into order-table for Order id : "
							+ order.getId());

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public void deleteOrder(int orderId) {
		Connection dbConnection = null;
		Statement statement = null;

		String sql = "delete from order where order_id=" + orderId;

		try {
			DataSource dataSource = new DataSource();
			dbConnection = dataSource.createConnection();
			statement = dbConnection.prepareStatement(sql);
			statement.executeUpdate(sql);

			System.out
					.println("Record is deleted from order - table for Order id : "
							+ orderId);

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

	}

}
