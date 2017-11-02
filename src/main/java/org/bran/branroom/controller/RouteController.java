package org.bran.branroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @ClassName: RouteController
 * @Description: TODO
 * @author: BranSummer
 * @date: 2017/11/02 18:38:19
 */
@Controller
public class RouteController {
	
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
	public String profile(){
		return "profile";
	}
}
