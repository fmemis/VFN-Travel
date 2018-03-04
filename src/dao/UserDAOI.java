package dao;

import java.util.List;

import model.User;

public interface UserDAOI {

	public boolean create(User user);
	public User findByUsername(String username);
	public List<User> getUsers();
}
