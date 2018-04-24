package org.bran.branroom.controller;

import javax.annotation.Resource;

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
 * @ClassName: UserController
 * @Description: TODO
 * @author: BranSummer
 * @date: 2017/10/28 15:37:55
 */
@Controller
@RequestMapping("/{userId}")
@SessionAttributes("user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	//获取头像相对路径修改头像并返回结果
	@RequestMapping(value="/chageAvatar",method=RequestMethod.POST,produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String chageAvatar(@RequestParam("avatar")String avatar,Model model){
		User user=(User) model.asMap().get("user");
		user.setAvatar(avatar);
		userService.chageAvatar(user, avatar);
		model.addAttribute("user", user);
		return new Result(Result.SUCCESS,"success").toJson();
	}
	
	//获取个人信息并更改信息
	@RequestMapping(value="/updateInfo",method=RequestMethod.POST,produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String updateInfo(@RequestParam("email")String email,@RequestParam("introduction")String introduction,Model model){
		User user=(User) model.asMap().get("user");
		user.setEmail(email);
		user.setIntroduction(introduction);
		userService.updateyInfo(user, email, introduction);
		model.addAttribute("user", user);
		return new Result(Result.SUCCESS,"success").toJson();
	}
	
	//重置密码
	@RequestMapping(value="/resetPwd",method=RequestMethod.POST,produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String resetPwd(@RequestParam("password")String password,Model model){
		User user=(User) model.asMap().get("user");
		user.setPassword(password);
		userService.resetPassword(user, password);
		model.addAttribute("user", user);
		return new Result(Result.SUCCESS,"success").toJson();
	}
	
}
