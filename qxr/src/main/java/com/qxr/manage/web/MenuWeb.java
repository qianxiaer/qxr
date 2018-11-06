package com.qxr.manage.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qxr.base.util.Page;
import com.qxr.base.util.ReBody;
import com.qxr.base.web.BaseController;
import com.qxr.manage.entity.Menu;
import com.qxr.manage.service.MenuSvr;

@RestController
@RequestMapping("manage/menu")
public class MenuWeb extends BaseController {
	
	@Autowired
	private MenuSvr svr;
	
	@GetMapping("page")
	public ReBody page(Page page,Menu menu){
		ReBody r = this.getReBody();
		page.setParam(menu);
		List<Menu> list = svr.findAll(page);
		r.setData(list);
		return r;
	}
	
}
