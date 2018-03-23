package com.dreamfly.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dreamfly.entity.BlogArticles;

public interface BlogArticlesDao {

	/**
	 * 增
	 * 
	 * @param t
	 * @return
	 */
	int add(@Param("t") BlogArticles t);

	/**
	 * 删
	 * 
	 * @param t
	 * @return
	 */
	int delete(@Param("t") BlogArticles t);

	/**
	 * 改
	 * 
	 * @param t
	 * @return
	 */
	int update(@Param("t") BlogArticles t);

	/**
	 * 查
	 * 
	 * @param t
	 * @return
	 */
	BlogArticles get(@Param("t") BlogArticles t);

	/**
	 * 获得列表
	 * 
	 * @param t
	 * @return
	 */
	List<BlogArticles> getList(@Param("t") BlogArticles t);

}
