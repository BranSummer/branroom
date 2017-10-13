package org.bran.branroom.dao;

import java.util.List;

import org.bran.branroom.entity.User;

public interface UserDao {
	
	User queryByUserId(String id);
	
	List<User> queryAllByUserId(String userId);
	
	boolean update(User user);
	
	boolean insert(User user);
	
	boolean delete(User user);
}
