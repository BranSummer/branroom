package org.bran.branroom.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.bran.branroom.dao.BlogDao;
import org.bran.branroom.dto.Result;
import org.bran.branroom.entity.Blog;
import org.bran.branroom.entity.User;
import org.bran.branroom.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/{userId}")
@SessionAttributes("user")
public class BlogController {
	@Resource
	BlogService blogService;
	
	@Resource
	BlogDao blogDao;
	
	//导向blog首页
	@RequestMapping(value="/blogHome")
	public ModelAndView blogHomePage(){
		int blogNum=blogDao.queryAll().size();
		return new ModelAndView("/blog/blogHome","blogNum",blogNum);
	}
	
	//导向个人主页
	@RequestMapping(value="/blogPersonal/{author}")
	public ModelAndView blogPersonalPage(@PathVariable("author") String author){
		int blogCount =blogService.getCountByAuthor(author);
		return new ModelAndView("/blog/blogPersonal", "count", blogCount);
		
	}
	
	//个人主页获取分页预览blog内容
	@RequestMapping(value="/fetchBlogList/{author}",method=RequestMethod.POST,produces="application/json; charset=utf-8")
	@ResponseBody //若无此注解,则返回  HTTP Status 405 - Request method 'GET' not supported
	public String fetchBlogList(@PathVariable("author")String author,@RequestParam("offset")Integer offset,@RequestParam("size")Integer size){
		
		Result result=blogService.getBlogsByAuthorByPage(author, offset, size);
		return result.toJson();		
	}
	
	//在blog首页获取预览blog内容
	@RequestMapping(value="/fetchBlogs",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	@ResponseBody
	public String fetchBlogs(){
		Result result=blogService.getBlogsByPage(0, 10);
		return result.toJson();
	}
	
	//在blog首页加载获取非初始预览blog内容,分页获取
		@RequestMapping(value="/fetchBlogList",method=RequestMethod.GET,produces="application/json;charset=utf-8")
		@ResponseBody
		public String fetchBlogs(@RequestParam("offset")Integer offset,@RequestParam("size")Integer size){
			Result result=blogService.getBlogsByPage(offset, size);
			return result.toJson();
		}
	
	
	//导向{blogid}指定的blog展示页面
	@RequestMapping(value="/blogPostPage/{blogid}")
	public ModelAndView blogPostPage(@PathVariable("blogid") Integer blogid){
		return new ModelAndView("/blog/blogpost","blogid",blogid);
	}
	
	//在blog展示页面获取blog内容
	@RequestMapping(value="/fetchblog/{blogid}",method=RequestMethod.GET,produces="application/json; charset=utf-8")
	@ResponseBody
	public String fetchBlog(@PathVariable("blogid") Integer blogid){
		Result response=blogService.getBlogById(blogid);
		return response.toJson();
	}
	
	//导向blog编辑页面,空白编辑
	@RequestMapping(value="/blogEdit")
	public String blogEditPage(){
		return "/blog/blogedit";
	}
	
	//提交文章,首次提交
	@RequestMapping(value="/submitBlog",method=RequestMethod.POST,produces="application/json; charset=utf-8")
	@ResponseBody
	public String submitBlog(@RequestParam("title")String title,@RequestParam("content")String content,Model model){
		LocalDateTime time=LocalDateTime.now();
		Result r=new Result();
		Blog b=new Blog();
		String author=((User)model.asMap().get("user")).getUserId();
		b.setAuthor(author);
		b.setContent(content);
		b.setTitle(title);
		b.setPosttime(time);
		blogService.submitNewBlog(b);
		r.setMessage("submitted blog");
		r.setStatus(Result.SUCCESS);
		return r.toJson();
		
	}
	
	//到向blog编辑页面,已存在的blog,用于更新blog
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/blogUpdatePage/{blogid}")
	public ModelAndView blogEditPage(@PathVariable Integer blogid,Model model){
		User user=(User) model.asMap().get("user");
		Blog blog=blogDao.queryById(blogid);
		if(!user.getUserId().equals(blog.getAuthor())){   //判断blog作者是否与当前登录用户一致
			return new ModelAndView("404");
		}
		
		Map map=new HashMap<String,String>();
		map.put("blogContent", blog.getContent());
		map.put("title", blog.getTitle());
		map.put("isUpdate", "true");
		map.put("blogid", blogid);
		return new ModelAndView("/blog/blogedit", map); 
		
	}
	
	@RequestMapping(value="/updateBlog",method=RequestMethod.POST,produces="application/json; charset=utf-8")
	@ResponseBody
	public String updateBlog(@RequestParam("title")String title,@RequestParam("content")String content,@RequestParam("blogid")Integer blogid){
		Result r=new Result();
		blogService.updateBlog(title, blogid, null, content);
		r.setStatus(Result.SUCCESS);
		r.setMessage("update blog");
		return r.toJson();	
	}
	
	
}
