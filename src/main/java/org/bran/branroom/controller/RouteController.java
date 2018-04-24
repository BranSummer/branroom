package org.bran.branroom.controller;

import org.bran.branroom.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 
 * @ClassName: RouteController
 * @Description: TODO
 * @author: BranSummer
 * @date: 2017/11/02 18:38:19
 */
@Controller
@SessionAttributes("user")
public class RouteController {
	
	@RequestMapping(value="/")
	public String index(){
		return "redirect:/blogHome";
	}
	
	@RequestMapping(value="/blogHome")
	public String blogHomePage(){
		return "/blog/blogHome";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(){
		return "login";
	}
	
	@RequestMapping(value = "/signUpPage", method = RequestMethod.GET)
	public String signUpPage(){
		return "signUp";
	} 
	
	@RequestMapping(value = "/chat")
	public String chatPage(){
		return "chat";
	}
	
	
	@RequestMapping(value = "/profile")
	public String profile(Model model){
		User user=(User)model.asMap().get("user");
//		if(user.getUserId().equals("admin")||user.getUserId().equals("Kirkland")){
//			return "lovestory";
//		}
		
		return "profile";
	}
	
	@RequestMapping(value = "/returnProfile")
	public String returnProfile(){
		return "profile";
		
	}
	
	@RequestMapping(value ="/searchPage")
	public String searchPage(){
		return "search";
	}

}
