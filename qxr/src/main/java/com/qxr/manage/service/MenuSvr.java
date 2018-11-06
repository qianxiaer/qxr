package com.qxr.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qxr.base.dao.BaseDao;
import com.qxr.base.service.BaseSvr;
import com.qxr.manage.dao.MenuDao;
import com.qxr.manage.entity.Menu;

@Service
public class MenuSvr extends BaseSvr<Menu, Integer> {

	@Autowired
	private MenuDao dao;
	
	@Override
	public BaseDao<Menu, Integer> getDao() {
		return dao;
	}
}