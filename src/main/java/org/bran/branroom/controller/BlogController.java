package org.bran.branroom.controller;

import java.time.LocalDateTime;

import javax.annotation.Resource;

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
	
	@RequestMapping(value="/blogPersonal/{author}")
	public ModelAndView blogPersonalPage(@PathVariable("author") String author){
		int blogCount =blogService.getCountByAuthor(author);
		return new ModelAndView("/blog/blogPersonal", "count", blogCount);
		
	}
	
	@RequestMapping(value="/fetchBlogList/{author}",method=RequestMethod.POST,produces="application/json; charset=utf-8")
	@ResponseBody //若无此注解,则返回  HTTP Status 405 - Request method 'GET' not supported
	public String fetchBlogList(@PathVariable("author")String author,@RequestParam("offset")Integer offset,@RequestParam("size")Integer size){
		Result result=blogService.getBlogsByAuthorByPage(author, offset, size);
		return result.toJson();		
	}
	
	@RequestMapping(value="/blogPostPage/{blogid}")
	public ModelAndView blogPostPage(@PathVariable("blogid") Integer blogid){
		return new ModelAndView("/blog/blogpost","blogid",blogid);
	}
	
	@RequestMapping(value="/fetchblog/{blogid}",method=RequestMethod.GET,produces="application/json; charset=utf-8")
	@ResponseBody
	public String fetchBlog(@PathVariable("blogid") Integer blogid){
		Result response=blogService.getBlogById(blogid);
		return response.toJson();
	}
	
	@RequestMapping(value="/blogEdit")
	public String blogEditPage(){
		return "/blog/blogedit";
	}
	
	
	
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
		r.setMessage("save blog");
		r.setStatus(Result.SUCCESS);
		return r.toJson();
		
	}
	
	
}
