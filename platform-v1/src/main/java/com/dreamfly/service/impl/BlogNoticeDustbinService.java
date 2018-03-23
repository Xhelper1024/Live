package com.dreamfly.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dreamfly.entity.BlogNoticeDustbin;
import com.dreamfly.service.IEntityService;

@Service
public class BlogNoticeDustbinService implements IEntityService<BlogNoticeDustbin> {

	@Override
	public boolean update(BlogNoticeDustbin t) {
		return false;
	}

	@Override
	public boolean delete(BlogNoticeDustbin t) {
		return false;
	}

	@Override
	public boolean add(BlogNoticeDustbin t) {
		return false;
	}

	@Override
	public BlogNoticeDustbin get(BlogNoticeDustbin t) {
		return null;
	}

	@Override
	public List<BlogNoticeDustbin> getList(BlogNoticeDustbin t) {
		return null;
	}

}
