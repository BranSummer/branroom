package org.bran.branroom.controller;

import javax.annotation.Resource;

import org.bran.branroom.dao.UserDao;
import org.bran.branroom.dto.Result;
import org.bran.branroom.entity.User;
import org.bran.branroom.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 
 * @ClassName: AccountController
 * @Description: TODO
 * @author: BranSummer
 * @date: 2017/10/28 15:37:26
 */
@Controller
@SessionAttributes("user")
public class AccountController {
	
	@Resource
	UserService userService;
	
	@Resource
	UserDao userDao;
	
	@RequestMapping(value="/check",method=RequestMethod.POST,produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String checkAccount(@RequestParam("userid")String userId){
		Result result=new Result();
		User user=userDao.queryByUserId(userId);
		if(user==null){
			result.setStatus(Result.SUCCESS);
			result.setMessage("The username can be used!");
		}else{
			result.setStatus(Result.FAILURE);
			result.setMessage("The username has been used!");

		}
		return result.toJson();
	}
	
	@RequestMapping(value="/signUp",method=RequestMethod.POST,produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String signUp(@RequestParam("userid")String userId, @RequestParam("pwd")String password, 
			@RequestParam("email")String email,Model model){
		Result result=new Result();
		User user=new User();
		user.setUserId(userId);
		user.setPassword(password);
		user.setEmail(email);
		user=userService.signUp(user);
		model.addAttribute("user", user);
		result.setStatus(Result.SUCCESS);
		result.setMessage("success");
		return result.toJson();
	}
	
}
