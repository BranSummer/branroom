package org.bran.branroom.dao;

import java.util.List;

import org.bran.branroom.entity.User;

public interface UserDao {
	
	User queryByUserId(String userId);
	
	List<User> queryAll();
	
	void update(User user);
	
	void insert(User user);
	
	void delete(User user);
}
