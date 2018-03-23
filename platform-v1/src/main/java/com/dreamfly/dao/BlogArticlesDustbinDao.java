package com.dreamfly.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dreamfly.entity.BlogArticlesDustbin;

public interface BlogArticlesDustbinDao {

	/**
	 * 增
	 * 
	 * @param t
	 * @return
	 */
	int add(@Param("t") BlogArticlesDustbin t);

	/**
	 * 删
	 * 
	 * @param t
	 * @return
	 */
	int delete(@Param("t") BlogArticlesDustbin t);

	/**
	 * 改
	 * 
	 * @param t
	 * @return
	 */
	int update(@Param("t") BlogArticlesDustbin t);

	/**
	 * 查
	 * 
	 * @param t
	 * @return
	 */
	BlogArticlesDustbin get(@Param("t") BlogArticlesDustbin t);

	/**
	 * 获得列表
	 * 
	 * @param t
	 * @return
	 */
	List<BlogArticlesDustbin> getList(@Param("t") BlogArticlesDustbin t);

}
