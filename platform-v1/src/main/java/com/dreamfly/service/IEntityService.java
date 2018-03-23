package com.dreamfly.service;

import java.util.List;

public interface IEntityService<T> {
	/**
	 * 修改
	 * 
	 * @param t
	 * @return
	 */
	public boolean update(T t);

	/**
	 * 删
	 * 
	 * @param t
	 * @return
	 */
	public boolean delete(T t);

	/**
	 * 增
	 * 
	 * @param t
	 * @return
	 */
	public boolean add(T t);

	/**
	 * 查
	 * 
	 * @param t
	 * @return
	 */
	public T get(T t);

	/**
	 * 获得列表
	 * 
	 * @param t
	 * @return
	 */
	public List<T> getList(T t);
}
