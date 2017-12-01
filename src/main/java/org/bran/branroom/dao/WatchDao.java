package org.bran.branroom.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.bran.branroom.entity.User;

public interface WatchDao {
	
	int queryFollowCount(String userId);
	
	int queryWatchCount(String wUser);
	
	List<User> queryFollowers(String userId);
	
	List<User> queryWatchers(String wUser);
	
	void insert(@Param("userId") String userId,@Param("wUser") String wUser);
	
	void delete(@Param("userId") String userId,@Param("wUser") String wUser);
}
