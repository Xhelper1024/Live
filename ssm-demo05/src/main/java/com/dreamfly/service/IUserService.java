package com.dreamfly.service;

import com.dreamfly.entity.User;

public interface IUserService {
	/**
	 * �û���¼
	 * 
	 * @param username
	 *            �û���
	 * @return -1��ʾ�û������ڣ�0��ʾ�������1��ʾ��¼�ɹ�
	 */
	int login(User user);
}
