package com.dreamfly.service;

import com.dreamfly.entity.User;

public interface IUserService {
	/**
	 * 用户登录
	 * 
	 * @param username
	 *            用户名
	 * @return -1表示用户不存在，0表示密码错误，1表示登录成功
	 */
	int login(User user);
}
