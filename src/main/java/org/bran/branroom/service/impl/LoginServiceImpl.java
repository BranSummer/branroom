package org.bran.branroom.service.impl;

import javax.annotation.Resource;

import org.bran.branroom.dao.UserDao;
import org.bran.branroom.entity.User;
import org.bran.branroom.exception.NoUserException;
import org.bran.branroom.exception.WrongPwdException;
import org.bran.branroom.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Resource
	private UserDao userDao;

	@Override
	public User loginAuth(String userId, String password) {
		User user=userDao.queryByUserId(userId);
		if(user==null){
			throw new NoUserException("No such user");
		}
		if(!user.getPassword().equals(password)){
			throw new WrongPwdException("Incorrect password");
		}
		return user;
	}

	

}
