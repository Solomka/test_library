package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vo.Role;
import vo.User;

public class UserDaoImpl implements UserDao {

	@Override
	public void addUser(User user) {
		Connection dbConnection = null;
		Statement statement = null;

		String sql = "insert into user values(" + user.getId() 
				+ "," + "'" + user.getLogin() + "'" + "," + "'"
				+ user.getPassword() + "'" + "," + "'" + user.getName() + "'"
				+ "," + "'" + user.getSurname()+"'" + "," + "'" + user.getRole()
				+ "'" + ")";

		try {
			DataSource dataSource = new DataSource();
			dbConnection = dataSource.createConnection();
			statement = dbConnection.prepareStatement(sql);
			statement.executeUpdate(sql);

			System.out
					.println("Record is inserted into user-table for  reader : "
							+ user.getName() + " " + user.getSurname());

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
	public User getUser(int userId){
		DataSource dataSource = new DataSource();
		Connection con = dataSource.createConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM user where user_id="+ userId;
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("user_id"));
				user.setLogin(rs.getString("login"));
				user.setPassword(rs.getString("pass"));
				user.setName(rs.getString("name"));
				user.setSurname(rs.getString("surname"));
				user.setRole(Role.valueOf(rs.getString("role")));
				return user;
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
	
	@Override
	public User getUser(String login, String pass) {
		DataSource dataSource = new DataSource();
		Connection con = dataSource.createConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM user where login=" + "'" + login
					+ "'" + " AND pass=" + "'" + pass + "'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("user_id"));
				user.setLogin(rs.getString("login"));
				user.setPassword(rs.getString("pass"));
				user.setName(rs.getString("name"));
				user.setSurname(rs.getString("surname"));
				user.setRole(Role.valueOf(rs.getString("role")));
				return user;
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

	@Override
	public void deleteUser(int userId) {
		Connection dbConnection = null;
		Statement statement = null;

		String sql = "delete from user where user_id=" + userId;

		try {
			DataSource dataSource = new DataSource();
			dbConnection = dataSource.createConnection();
			statement = dbConnection.prepareStatement(sql);
			statement.executeUpdate(sql);

			System.out
					.println("Record is deleted from User - table for User id : "
							+ userId);

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
