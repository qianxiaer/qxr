package com.qxr.base.dao;

import java.util.List;

import com.qxr.base.util.Page;

public interface BaseDao<T,K> {
	
	public void insert(T entity);
	
	public T findById(K id);

	public List<T> findAll(Page page);
	
	public void update(T entity);
	
}