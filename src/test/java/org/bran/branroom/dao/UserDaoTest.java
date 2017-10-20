package org.bran.branroom.dao;

import java.util.List;

import org.bran.branroom.base.BaseTest;
import org.bran.branroom.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoTest extends BaseTest {
	@Autowired
	private UserDao userDao;
	
	@Test
	public void testQueryAll(){
		List<User> list=userDao.queryAll();
		for(User item:list){
			System.out.println(item.getUserId());
		}
	}
}
