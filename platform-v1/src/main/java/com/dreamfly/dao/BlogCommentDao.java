package com.dreamfly.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dreamfly.entity.BlogComment;

public interface BlogCommentDao {

	/**
	 * 增
	 * 
	 * @param t
	 * @return
	 */
	int add(@Param("t") BlogComment t);

	/**
	 * 删
	 * 
	 * @param t
	 * @return
	 */
	int delete(@Param("t") BlogComment t);

	/**
	 * 改
	 * 
	 * @param t
	 * @return
	 */
	int update(@Param("t") BlogComment t);

	/**
	 * 查
	 * 
	 * @param t
	 * @return
	 */
	BlogComment get(@Param("t") BlogComment t);

	/**
	 * 获得列表
	 * 
	 * @param t
	 * @return
	 */
	List<BlogComment> getList(@Param("t") BlogComment t);

}
