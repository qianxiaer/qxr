package com.qxr.base.util;

public class Page {

	private int page = 1;// 当前页
	private int limit = 100;// 当前显示条数
	private int begin;// 开始
	private Object param;//参数

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
		this.begin = (this.page - 1) * this.limit;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public Object getParam() {
		return param;
	}

	public void setParam(Object param) {
		this.param = param;
	}

}
