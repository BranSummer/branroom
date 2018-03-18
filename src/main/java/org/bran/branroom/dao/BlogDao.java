package org.bran.branroom.dao;

import java.util.List;

import org.bran.branroom.entity.Blog;

public interface BlogDao {
	
	List<Blog> queryBlogByAuthor(String userid);
	
	List<Blog> queryBlogByTitle(String title);
	
	List<Blog> queryAll();
	
	Blog queryById(int id);
	
	void insert(Blog blog);
	
	void delete(Blog blog);
	
	void update(Blog blog);
	
	
}
