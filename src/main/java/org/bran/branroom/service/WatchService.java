package org.bran.branroom.service;

import java.util.List;

import org.bran.branroom.entity.User;

public interface WatchService {
	
	void watch(User a,User b);
	
	void unwatch(User a,User b);
	
	int getWatchedCount(User a);
	
	int getFollowCount(User a);
	
	List<User> getWatchers(User a);
	
	List<User> getFollowers(User a);
 }
