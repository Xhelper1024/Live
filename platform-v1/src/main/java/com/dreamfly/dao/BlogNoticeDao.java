package com.dreamfly.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dreamfly.entity.BlogNotice;

public interface BlogNoticeDao {

	/**
	 * 增
	 * 
	 * @param t
	 * @return
	 */
	int add(@Param("t") BlogNotice t);

	/**
	 * 删
	 * 
	 * @param t
	 * @return
	 */
	int delete(@Param("t") BlogNotice t);

	/**
	 * 改
	 * 
	 * @param t
	 * @return
	 */
	int update(@Param("t") BlogNotice t);

	/**
	 * 查
	 * 
	 * @param t
	 * @return
	 */
	BlogNotice get(@Param("t") BlogNotice t);

	/**
	 * 获得列表
	 * 
	 * @param t
	 * @return
	 */
	List<BlogNotice> getList(@Param("t") BlogNotice t);

}
