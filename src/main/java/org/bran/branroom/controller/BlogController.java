package org.bran.branroom.controller;

import java.time.LocalDateTime;

import javax.annotation.Resource;

import org.bran.branroom.dto.Result;
import org.bran.branroom.entity.Blog;
import org.bran.branroom.entity.User;
import org.bran.branroom.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//@RequestMapping("/{userId}")
@SessionAttributes("user")
public class BlogController {
	@Resource
	BlogService blogService;
	
	@RequestMapping(value="/blogPostPage/{blogid}")
	public String blogPostPage(){
		return "blogpost";
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
		b.setPostTime(time);
		blogService.submitNewBlog(b);
		r.setMessage("save blog");
		r.setStatus(Result.SUCCESS);
		return r.toJson();
		
	}
	
	
}
