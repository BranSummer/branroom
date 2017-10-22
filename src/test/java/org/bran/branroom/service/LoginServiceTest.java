package org.bran.branroom.service;

import static org.junit.Assert.*;

import org.bran.branroom.base.BaseTest;
import org.bran.branroom.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginServiceTest extends BaseTest {

	@Autowired
	private  LoginService loginService;
	
	@Test
	public void testLoginAuth() {
		User user=loginService.loginAuth("test01","123456");
		assertEquals("test@bran.com", user.getEmail());
	}
	
}
