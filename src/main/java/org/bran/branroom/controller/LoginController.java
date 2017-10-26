package org.bran.branroom.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.bran.branroom.dto.Result;
import org.bran.branroom.entity.User;
import org.bran.branroom.exception.NoUserException;
import org.bran.branroom.exception.WrongPwdException;
import org.bran.branroom.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("user")
public class LoginController {
	
	@Resource
	private LoginService loginService;
	
	
	
	@RequestMapping(value="/signIn",method=RequestMethod.POST,produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String signIn(@RequestParam("userid")String userId, @RequestParam("pwd")String password, 
			@RequestParam("isRemember")boolean isRemember,Model model){
		Result result=new Result();
		try{
			User user=loginService.loginAuth(userId, password);
			result.setStatus(Result.SUCCESS);
			result.setMessage("success");
			model.addAttribute("user", user);
		}catch(NoUserException e1){
			result.setStatus(Result.FAILURE);
			result.setMessage("No such user!");
		}catch(WrongPwdException e2){
			result.setStatus(Result.FAILURE);
			result.setMessage("Incorrect password!");
		}
		
		return result.toJson();
	}
	
	@RequestMapping(value="/signOut")
	public String signUp(SessionStatus sessionStatus){
		sessionStatus.setComplete();
		return "login";
	}
}
