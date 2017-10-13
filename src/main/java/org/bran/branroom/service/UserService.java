package org.bran.branroom.service;

import org.bran.branroom.entity.User;

public interface UserService {
	
	boolean resetPassword(User user,String pwd);
	
	boolean updateyInfo(User user,String email,String introduction);
	
	boolean chageAvatar(User user,String avatar);
	
	
}
