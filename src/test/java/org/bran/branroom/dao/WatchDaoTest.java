package org.bran.branroom.dao;

import java.util.List;

import org.bran.branroom.base.BaseTest;
import org.bran.branroom.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WatchDaoTest extends BaseTest {

	@Autowired
	private WatchDao watchDao;

	@Test
	public void testInsert(){
		System.out.println("start test insert()");
		watchDao.insert("admin", "test01");
	}
	
	@Test
	public void testQueryFollowCount(){
		System.out.println("start test queryFollowCount()");
		int num=watchDao.queryFollowCount("admin");
		System.out.println("num="+num);
	}
	
	@Test
	public void testQueryWatchCount(){
		System.out.println("start test QueryWatchCount()");
		int num=watchDao.queryWatchCount("admin");
		System.out.println("num="+num);
	}
	
	@Test
	public void testQueryFollowers(){
		System.out.println("start test QueryFollowers()");
		List<User> list=watchDao.queryFollowers("admin");
		for(User item:list){
			System.out.println("follower:"+item);
		}
	}
	
	@Test
	public void testQueryWatchers(){
		System.out.println("start test QueryWatchers()");
		List<User> list=watchDao.queryWatchers("admin");
		for(User item:list){
			System.out.println("watcher:"+item);
		}
	}
	
	@Test
	public void testDelete(){
		System.out.println("start test Delete()");
		watchDao.delete("admin", "test01");
	}
}
