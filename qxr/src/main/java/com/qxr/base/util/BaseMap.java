package com.qxr.base.util;

import java.util.HashMap;

public class BaseMap extends HashMap<String, Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getString(Object key) {
		try {
			return (String)get(key);
		} catch (Exception e) {
			return get(key).toString();
		}
	}
	
}
