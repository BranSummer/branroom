package org.bran.branroom.service;

import org.bran.branroom.entity.User;

public interface UserService {
	
	void resetPassword(User user,String pwd);
	
	void updateyInfo(User user,String email,String introduction);
	
	void chageAvatar(User user,String avatar);
	
	void cancelUser(User user);
	
	void signUp(User user);
}
