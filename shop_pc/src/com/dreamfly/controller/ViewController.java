package com.dreamfly.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	/**
	 * 控制页面跳转到注册页面
	 */
	@RequestMapping("/v2/user/regist_page")
	public String helloworld(Model model) {
		System.out.println(new Date());
		return "regist_page";
	}
	
	@RequestMapping("/admin")
	public String admin(){
		return "admin";
	}
	
	@RequestMapping("user_center")
	public String user_center(){
		return "user_center";
	}

}
