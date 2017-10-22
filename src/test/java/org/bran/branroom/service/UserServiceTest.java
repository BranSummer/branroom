package org.bran.branroom.service;

import org.bran.branroom.base.BaseTest;
import org.bran.branroom.dao.UserDao;
import org.bran.branroom.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends BaseTest {

	private static User testUser;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private  UserDao userDao;
	
	@Before
	public void initUser(){
		testUser=userDao.queryByUserId("test01");
	}
	
	@Test
	public void testResetPassword() {
		String oldPwd=testUser.getPassword();
		String newPwd=(Integer.parseInt(oldPwd)+1)+"";
		userService.resetPassword(testUser, newPwd);
	}

	@Test
	public void testUpdateyInfo() {
		userService.updateyInfo(testUser, "test@email.com", "hello test!");
	}

	@Test
	public void testChageAvatar() {
		userService.chageAvatar(testUser, "test.jpg");
	}

}
