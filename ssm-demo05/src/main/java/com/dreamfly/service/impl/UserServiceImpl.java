package com.dreamfly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamfly.dao.UserMapper;
import com.dreamfly.entity.User;
import com.dreamfly.service.IUserService;

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper dao;

	public int login(User user) {
		String password = dao.queryUser(user.getUsername());
		if (null == password || "".equals(password))
			return -1;
		else if (password.equals(user.getPassword()))
			return 1;
		else
			return 0;
	}

}
