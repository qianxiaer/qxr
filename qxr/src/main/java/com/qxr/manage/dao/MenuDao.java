package com.qxr.manage.dao;

import org.apache.ibatis.annotations.Mapper;

import com.qxr.base.dao.BaseDao;
import com.qxr.manage.entity.Menu;

@Mapper
public interface MenuDao extends BaseDao<Menu, Integer> {
	
}