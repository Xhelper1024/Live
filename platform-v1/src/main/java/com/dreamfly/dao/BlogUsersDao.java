package com.dreamfly.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dreamfly.entity.BlogUsers;

public interface BlogUsersDao {

	/**
	 * 增
	 * 
	 * @param t
	 * @return
	 */
	int add(@Param("t") BlogUsers t);

	/**
	 * 删
	 * 
	 * @param t
	 * @return
	 */
	int delete(@Param("t") BlogUsers t);

	/**
	 * 改
	 * 
	 * @param t
	 * @return
	 */
	int update(@Param("t") BlogUsers t);

	/**
	 * 查
	 * 
	 * @param t
	 * @return
	 */
	BlogUsers get(@Param("t") BlogUsers t);

	/**
	 * 获得列表
	 * 
	 * @param t
	 * @return
	 */
	List<BlogUsers> getList(@Param("t") BlogUsers t);

}
