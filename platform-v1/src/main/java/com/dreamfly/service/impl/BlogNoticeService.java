package com.dreamfly.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dreamfly.entity.BlogNotice;
import com.dreamfly.service.IEntityService;

@Service
public class BlogNoticeService implements IEntityService<BlogNotice> {

	@Override
	public boolean update(BlogNotice t) {
		return false;
	}

	@Override
	public boolean delete(BlogNotice t) {
		return false;
	}

	@Override
	public boolean add(BlogNotice t) {
		return false;
	}

	@Override
	public BlogNotice get(BlogNotice t) {
		return null;
	}

	@Override
	public List<BlogNotice> getList(BlogNotice t) {
		return null;
	}

}
