package org.bran.branroom.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.bran.branroom.dao.BlogDao;
import org.bran.branroom.dao.UserDao;
import org.bran.branroom.dto.PreviewBlog;
import org.bran.branroom.dto.Result;
import org.bran.branroom.entity.Blog;
import org.bran.branroom.exception.NoUserException;
import org.bran.branroom.service.BlogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BlogServiceImpl implements BlogService {

	@Resource
	private BlogDao blogDao;
	
	@Resource
	private UserDao userDao;
	
	
	@Override
	@Transactional
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
	public Result getBlogById(int id) {
		Blog b=blogDao.queryById(id);
		Result r=new Result();
		r.setUmessage(b);
		r.setStatus(Result.SUCCESS);
		return r;
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

	@Override
	public int getCountByAuthor(String author) {
		if(userDao.queryByUserId(author)==null){
			throw new  NoUserException("no such user");
		}
		return blogDao.queryCountByAuthor(author);
	}

	@Override
	public Result getBlogsByAuthorByPage(String author, int offset, int size) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("author", author);
		map.put("offset", offset);
		map.put("size", size);
		List<Blog> list=blogDao.queryBlogByAuthorOnPage(map);
		List<PreviewBlog> listResult=new ArrayList<PreviewBlog>();
		for(Blog b:list){
			PreviewBlog pb=new PreviewBlog(b);
			listResult.add(pb);
		}
		Result result=new Result(Result.SUCCESS, "query");
		result.setUmessage(listResult);
		return result;
	}

}
