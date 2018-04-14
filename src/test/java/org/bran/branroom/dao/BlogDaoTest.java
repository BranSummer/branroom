package org.bran.branroom.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.bran.branroom.base.BaseTest;
import org.bran.branroom.entity.Blog;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BlogDaoTest extends BaseTest {

	@Autowired
	private BlogDao blogDao;
	
	private Blog b=new Blog();
	
	@Before
	public void initial(){
		b.setAuthor("admin");
		b.setContent("hello world,this is a simple content !");
		b.setTitle("blog insert test");
		LocalDateTime time=LocalDateTime.now();
		b.setPosttime(time);
	}
	
	@Test
	public void testInsert(){
		boolean tag=blogDao.insert(b);
		System.out.println(tag+"");
	}
	
	@Test
	public void testQueryByAuthor(){
		List<Blog> list=blogDao.queryBlogByAuthor("ad");
		for(Blog b:list){
			System.out.println(b.getId()+","+b.getAuthor()+","+b.getPosttime());
		}
	}

}
