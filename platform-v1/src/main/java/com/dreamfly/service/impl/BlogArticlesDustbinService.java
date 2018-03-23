package com.dreamfly.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dreamfly.entity.BlogArticlesDustbin;
import com.dreamfly.service.IEntityService;

@Service
public class BlogArticlesDustbinService implements IEntityService<BlogArticlesDustbin> {
	
	@Override
	public boolean update(BlogArticlesDustbin t) {
		return false;
	}

	@Override
	public boolean delete(BlogArticlesDustbin t) {
		return false;
	}

	@Override
	public boolean add(BlogArticlesDustbin t) {
		return false;
	}

	@Override
	public BlogArticlesDustbin get(BlogArticlesDustbin t) {
		return null;
	}

	@Override
	public List<BlogArticlesDustbin> getList(BlogArticlesDustbin t) {
		return null;
	}

}
