package org.bran.branroom.controller;

import javax.annotation.Resource;

import org.bran.branroom.dto.Result;
import org.bran.branroom.entity.Blog;
import org.bran.branroom.entity.User;
import org.bran.branroom.service.BlogService;
import org.bran.branroom.service.UserService;
import org.bran.branroom.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

	@Autowired
	private BlogService blogService;

	@Autowired
	private PasswordUtil passwordUtil;

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
		user = passwordUtil.encryptPassword(user);
		userService.resetPassword(user, password);
		model.addAttribute("user", user);
		return new Result(Result.SUCCESS,"success").toJson();
	}

	@RequestMapping(value = "/heatMap",method = RequestMethod.GET,produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String getHeatMap(@RequestParam("userId") String userId ){
		return blogService.getHeatChart(userId).toJson();
	}
}
