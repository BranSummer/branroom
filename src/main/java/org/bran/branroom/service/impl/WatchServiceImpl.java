package org.bran.branroom.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.bran.branroom.dao.WatchDao;
import org.bran.branroom.entity.User;
import org.bran.branroom.service.WatchService;

public class WatchServiceImpl implements WatchService {

	@Resource
	private WatchDao watchDao;
	
	@Override
	public void watch(User a, User b) {
		watchDao.insert(a.getUserId(), b.getUserId());

	}

	@Override
	public void unwatch(User a, User b) {
		watchDao.delete(a.getUserId(), b.getUserId());
	}

	@Override
	public int getWatchedCount(User a) {
		 
		return watchDao.queryWatchCount(a.getUserId());
	}

	@Override
	public int getFollowCount(User a) {
	
		return watchDao.queryFollowCount(a.getUserId());
	}

	@Override
	public List<User> getWatchers(User a) {
		
		return watchDao.queryWatchers(a.getUserId());
	}

	@Override
	public List<User> getFollowers(User a) {
		
		return watchDao.queryFollowers(a.getUserId());
	}

}
