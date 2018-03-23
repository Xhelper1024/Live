package com.dreamfly.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreamfly.entity.BlogUsers;
import com.dreamfly.service.impl.BlogUsersService;

@Controller
@RequestMapping(value = "/blogUsers")
public class BlogUsersController {

	@Autowired
	private BlogUsersService blogUsersService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(BlogUsers t) {
		BlogUsers bUsers = blogUsersService.get(t);
		if (bUsers == null) {
			return "用户不存在";
		}
		if (!bUsers.getPassword().equals(t.getPassword())) {
			return "密码不对";
		}
		return "登录成功";
	}

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	@ResponseBody
	public String regist(BlogUsers t) {
		boolean flag = blogUsersService.add(t);
		return flag ? "注册成功" : "注册失败";
	}

}
