package org.bran.branroom.service;

import org.bran.branroom.entity.User;

public interface LoginService {
	
	User loginAuth(String userId,String password);
	
	
}
