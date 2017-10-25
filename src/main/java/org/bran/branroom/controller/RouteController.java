package org.bran.branroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RouteController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(){
		return "login";
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
