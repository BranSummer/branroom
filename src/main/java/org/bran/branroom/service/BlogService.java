package org.bran.branroom.service;

import java.util.List;

import org.bran.branroom.dto.Result;
import org.bran.branroom.entity.Blog;

public interface BlogService {
	
	void submitNewBlog(Blog b);
	
	void deleteBlog(Blog b);
	
	void updateBlog(Blog b);
	
	int getCountByAuthor(String author);
	
	Result getBlogById(int id);
	
	List<Blog> getBlogsByAuthor(String author);
	
	List<Blog> getBlogsByTitle(String title);
	
	List<Blog> getAllBlogs();
	
	Result getBlogsByAuthorByPage(String author,int offset,int size);
}
