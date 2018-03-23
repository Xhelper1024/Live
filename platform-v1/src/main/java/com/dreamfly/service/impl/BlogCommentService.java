package com.dreamfly.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dreamfly.entity.BlogComment;
import com.dreamfly.service.IEntityService;

@Service
public class BlogCommentService implements IEntityService<BlogComment> {

	@Override
	public boolean update(BlogComment t) {
		return false;
	}

	@Override
	public boolean delete(BlogComment t) {
		return false;
	}

	@Override
	public boolean add(BlogComment t) {
		return false;
	}

	@Override
	public BlogComment get(BlogComment t) {
		return null;
	}

	@Override
	public List<BlogComment> getList(BlogComment t) {
		return null;
	}

}
