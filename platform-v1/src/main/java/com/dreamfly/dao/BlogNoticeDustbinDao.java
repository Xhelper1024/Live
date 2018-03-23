package com.dreamfly.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dreamfly.entity.BlogNoticeDustbin;

public interface BlogNoticeDustbinDao {

	/**
	 * 增
	 * 
	 * @param t
	 * @return
	 */
	int add(@Param("t") BlogNoticeDustbin t);

	/**
	 * 删
	 * 
	 * @param t
	 * @return
	 */
	int delete(@Param("t") BlogNoticeDustbin t);

	/**
	 * 改
	 * 
	 * @param t
	 * @return
	 */
	int update(@Param("t") BlogNoticeDustbin t);

	/**
	 * 查
	 * 
	 * @param t
	 * @return
	 */
	BlogNoticeDustbin get(@Param("t") BlogNoticeDustbin t);

	/**
	 * 获得列表
	 * 
	 * @param t
	 * @return
	 */
	List<BlogNoticeDustbin> getList(@Param("t") BlogNoticeDustbin t);

}
