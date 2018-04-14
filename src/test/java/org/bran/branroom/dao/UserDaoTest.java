package org.bran.branroom.dao;

import java.util.List;

import org.bran.branroom.base.BaseTest;
import org.bran.branroom.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoTest extends BaseTest {
	@Autowired
	private UserDao userDao;
	
	private User testUser=new User();
	
	@Before
	public void initialUser(){
		testUser.setUserId("test");
		testUser.setPassword("testPWD");
		testUser.setAvatar("avatarTest.jpg");
		testUser.setEmail("test@bran.com");
		testUser.setIntroduction("");
		testUser.setPermission("test_permission");
		testUser.setGender(false);
	}
	
	
	@Test
	public void testQueryAll(){
		System.out.println("————testQueryAll————");
		List<User> list=userDao.queryAll();
		for(User item:list){
			System.out.println(item.getUserId());
		}
		
	}
	
	@Test
	public void testQueryByUserId(){
		System.out.println("————testQueryByUserId————");
		User user=userDao.queryByUserId("admin");
		System.out.println(user.getUserId()+","+user.getPassword());
	}
	
	@Test
	public void testInsert(){
		System.out.println("————testInsert————");
		boolean tag=userDao.insert(testUser);
		System.out.println(tag);
		List<User> list=userDao.queryAll();
		for(User item:list){
			System.out.println(item.getUserId()+","+item.getPassword());
		}
	}
	
	@Test
	public void testUpdate(){
		System.out.println("————testUpdate————");
		testUser.setPassword("testPWD123");
		userDao.update(testUser);
		List<User> list=userDao.queryAll();
		for(User item:list){
			System.out.println(item.getUserId()+","+item.getPassword());
		}
	}
	@Test
	public void testDelete(){
		System.out.println("————testDelete————");
		userDao.delete(testUser);
		List<User> list=userDao.queryAll();
		for(User item:list){
			System.out.println(item.getUserId()+","+item.getPassword());
		}
	}
}
