package org.bran.branroom.service;

public interface RobotService {
	boolean isEnable();
	
	String reply(String message,String userId);
}
