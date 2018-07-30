package org.bran.branroom.service.impl;

import javax.annotation.Resource;

import org.bran.branroom.dao.UserDao;
import org.bran.branroom.entity.User;
import org.bran.branroom.exception.RepeatPasswordException;
import org.bran.branroom.service.UserService;
import org.bran.branroom.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Autowired
	private PasswordUtil passwordUtil;

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

	@Override
	public void cancelUser(User user) {
		userDao.delete(user);
		
	}
	
	/**
	 * The user registration for business logic processing
	 * <p>the client give the necessary userId,password and email</P>
	 * so this method give the default values for other properties 
	 */
	@Override
	@Transactional
	public User signUp(User user) {
		user.setAvatar(User.DEFAULT_AVATAR);
		user.setGender(User.GENDER_MALE);
		user.setPermission(User.PERMI_USER_C);
		user.setIntroduction(User.DEFAULT_INTRRO);
		//加盐并给密码加密
		user = passwordUtil.encryptPassword(user);
		userDao.insert(user);
		return user;
		
	}

	@Override
	public User findUserByName(String name) {
		return userDao.queryByUserId(name);
	}


}
