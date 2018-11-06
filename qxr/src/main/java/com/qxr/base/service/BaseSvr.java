package com.qxr.base.service;

import java.util.List;

import com.qxr.base.dao.BaseDao;
import com.qxr.base.util.Page;

public abstract class BaseSvr<T,K> {
	
	public abstract BaseDao<T, K> getDao();
	
	public void insert(T entity) {
		getDao().insert(entity);
	}
	public T findById(K id) {
		return getDao().findById(id);
	}
	public List<T> findAll(Page page){
		return getDao().findAll(page);
	}
	
	public void update(T entity) {
		getDao().update(entity);
	}
}