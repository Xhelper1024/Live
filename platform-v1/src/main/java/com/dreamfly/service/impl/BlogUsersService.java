package com.dreamfly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamfly.dao.BlogUsersDao;
import com.dreamfly.entity.BlogUsers;
import com.dreamfly.service.IEntityService;

@Service
public class BlogUsersService implements IEntityService<BlogUsers> {

	@Autowired
	private BlogUsersDao blogUsersDao;

	@Override
	public boolean update(BlogUsers t) {
		return blogUsersDao.update(t) == 0 ? false : true;
	}

	@Override
	public boolean delete(BlogUsers t) {
		return blogUsersDao.delete(t) == 0 ? false : true;
	}

	@Override
	public boolean add(BlogUsers t) {
		return blogUsersDao.add(t) == 0 ? false : true;
	}

	@Override
	public BlogUsers get(BlogUsers t) {
		return blogUsersDao.get(t);
	}

	@Override
	public List<BlogUsers> getList(BlogUsers t) {
		return blogUsersDao.getList(t);
	}

}
