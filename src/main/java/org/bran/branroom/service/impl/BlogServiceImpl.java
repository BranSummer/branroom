package org.bran.branroom.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.bran.branroom.dao.BlogDao;
import org.bran.branroom.entity.Blog;
import org.bran.branroom.service.BlogService;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {

	@Resource
	private BlogDao blogDao;
	
	
	@Override
	public void submitNewBlog(Blog b) {
		blogDao.insert(b);
	}

	@Override
	public void deleteBlog(Blog b) {
		blogDao.delete(b);
	}

	@Override
	public void updateBlog(Blog b) {
		blogDao.update(b);
	}

	@Override
	public Blog getBlogById(int id) {
		Blog b=blogDao.queryById(id);
		return b;
	}

	@Override
	public List<Blog> getBlogsByAuthor(String author) {
		List<Blog> list=blogDao.queryBlogByAuthor(author);
		return list;
	}

	@Override
	public List<Blog> getBlogsByTitle(String title) {
		List<Blog> list=blogDao.queryBlogByTitle(title);
		return list;
	}

	@Override
	public List<Blog> getAllBlogs() {
		List<Blog> list=blogDao.queryAll();
		return list;
	}

}
