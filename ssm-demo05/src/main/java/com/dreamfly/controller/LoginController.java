package com.dreamfly.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dreamfly.entity.User;
import com.dreamfly.service.impl.UserServiceImpl;

@Controller
public class LoginController {

	@Autowired
	@Qualifier("userServiceImpl")
	private UserServiceImpl userServiceImpl;
	private PrintWriter out;
	
	@RequestMapping("/login")
	public void login(User user, Model model, HttpServletResponse resp){
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text");
		// 
		try {
			out = resp.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int result = userServiceImpl.login(user);
		out.print(result);
		out.flush();
	}
	
}
