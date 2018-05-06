package org.bran.branroom.service;

import java.time.LocalDateTime;
import java.util.List;

import org.bran.branroom.dto.Result;
import org.bran.branroom.entity.Blog;

public interface BlogService {
	
	void submitNewBlog(Blog b);
	
	void deleteBlog(Blog b);
	
	void updateBlog(String title,int id,List<String> keywords,String content);
	
	int getCountByAuthor(String author);
	
	Result getBlogById(int id);
	
	List<Blog> getBlogsByAuthor(String author);
	
	List<Blog> getBlogsByTitle(String title);
	
	List<Blog> getAllBlogs();
	
	Result getBlogsByAuthorByPage(String author,int offset,int size);
	
	Result getBlogsByPage(int offset,int size);
}
