package dao;

import vo.User;

public interface UserDao {

	public void addUser(User user);

	public User getUser(String login, String pass);
	public User getUser(int uesrId);

	public void deleteUser(int userId);

}
