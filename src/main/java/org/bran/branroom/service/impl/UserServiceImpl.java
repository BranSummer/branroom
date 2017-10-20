package org.bran.branroom.service.impl;

import javax.annotation.Resource;

import org.bran.branroom.dao.UserDao;
import org.bran.branroom.entity.User;
import org.bran.branroom.exception.RepeatPasswordException;
import org.bran.branroom.service.UserService;
import org.springframework.stereotype.Service;
/**
 * 
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @author: BranSummer
 * @date: 2017/10/13 21:16:04
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;

	@Override
	public void resetPassword(User user, String pwd) {
		if(user.getPassword().equals(pwd)){
			throw new RepeatPasswordException("repeat password");
		}
		user.setPassword(pwd);
		userDao.update(user);
	}

	@Override
	public void updateyInfo(User user, String email, String introduction) {
		user.setEmail(email);
		user.setIntroduction(introduction);
		userDao.update(user);
	}

	@Override
	public void chageAvatar(User user, String avatar) {
		user.setAvatar(avatar);
		userDao.update(user);
	}

}
