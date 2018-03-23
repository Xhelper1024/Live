package com.dreamfly.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.sf.json.JSONObject;

@Controller
public class ServiceController {

	private PrintWriter out;

	/**
	 * 注册
	 * 
	 * @param user
	 * @param resp
	 */
	@RequestMapping("/v2/user/registion")
	public void register(String user, HttpServletResponse resp) {
		System.out.println(user);
		try {
			out = resp.getWriter();
			out.print("success");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 模拟数据
	 * 
	 * @param resp
	 */
	@RequestMapping(value = "/api/v2/projects", method = RequestMethod.GET)
	public void getProjects(HttpServletResponse resp, HttpServletRequest req) {
		resp.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setContentType("application/json");
		Map<String, Object> map = new HashMap<>();
		List<Object> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Map<String, Object> content = new HashMap<>();
			content.put("pro_id", i);
			content.put("pro_price", new Random().nextInt(10000));
			content.put("pro_name", "掌上计算机");
			content.put("pro_url", "/upload/userhead" + (i + 1) + ".jpg");
			list.add(content);
		}
		map.put("projects", list);
		try {
			out = resp.getWriter();
			out.print(JSONObject.fromObject(map));
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
