package com.dreamfly.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dreamfly.entity.BlogArticles;
import com.dreamfly.service.IEntityService;

@Service
public class BlogArticlesService implements IEntityService<BlogArticles>{

	@Override
	public boolean update(BlogArticles t) {
		return false;
	}

	@Override
	public boolean delete(BlogArticles t) {
		return false;
	}

	@Override
	public boolean add(BlogArticles t) {
		return false;
	}

	@Override
	public BlogArticles get(BlogArticles t) {
		return null;
	}

	@Override
	public List<BlogArticles> getList(BlogArticles t) {
		// TODO Auto-generated method stub
		return null;
	}

}
