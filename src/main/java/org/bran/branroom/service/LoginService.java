package org.bran.branroom.service;

import org.bran.branroom.entity.User;

public interface LoginService {
	
	User loginIn(String userId,String password);
	
	
}
