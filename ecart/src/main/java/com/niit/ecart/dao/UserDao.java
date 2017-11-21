package com.niit.ecart.dao;
import java.util.List;

import com.niit.ecart.model.User;



public interface UserDao {
	public boolean addUsers(User users);
	
    public boolean deleteUser(User user);
	
	public User getUsersById(String userId);
	
	public boolean editUsers(User users);

	public List<User> getAllUsers(String un);

	public User getUsersByUsername(String userName);
	
}
