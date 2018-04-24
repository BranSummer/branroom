package org.bran.branroom.dao;

import java.util.List;
import java.util.Map;

import org.bran.branroom.entity.Blog;

public interface BlogDao {
	
	List<Blog> queryBlogByAuthor(String userid);
	
	List<Blog> queryBlogByTitle(String title);
	
	List<Blog> queryBlogByPage(Map<String,Object> map);
	
	int queryCountByAuthor(String author);
	
	List<Blog> queryAll();
	
	Blog queryById(int id);
	
	boolean insert(Blog blog);
	
	void delete(Blog blog);
	
	void update(Blog blog);
	
	
}
