package com.barclouds.util;

import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 这个类主要用来修改req.getParameterMap()中上锁的数据，直接通过req.getParameterMap().put(key,value)
 * 会报异常 java.lang.IllegalStateException: No modifications are allowed to a
 * locked ParameterMap， 所以通过这种方式间接修改数据
 * 
 * @author Steven
 * 
 */
// 为了让编译器不报警告
@SuppressWarnings("unchecked")
public class ParameterRequestFilterWrapper extends HttpServletRequestWrapper {
	// 接收传过来的新的参数
	private Map params;

	/**
	 * 必须的构造
	 * 
	 * @param request
	 */
	public ParameterRequestFilterWrapper(HttpServletRequest request) {
		super(request);
	}

	/**
	 * 用来进行间接修改传入的map中key所对应的value的构造
	 * 
	 * @param request
	 * @param newParames
	 */
	public ParameterRequestFilterWrapper(HttpServletRequest request,
			Map newParames) {
		this(request);
		this.params = newParames;
	}

	/**
	 * 复写获取key的方法
	 */
	@Override
	public Enumeration getParameterNames() {
		Vector names = new Vector(params.keySet());
		return names.elements();
	}

	/**
	 * 复写获取多值values的方法
	 */
	@Override
	public String[] getParameterValues(String name) {
		Object v = params.get(name);
		if (v == null) {
			return null;
		} else if (v instanceof String[]) {
			return (String[]) v;
		} else if (v instanceof String) {
			return new String[] { (String) v };
		} else {
			return new String[] { v.toString() };
		}
	}

	/**
	 * 复写获取值value的方法
	 */
	@Override
	public String getParameter(String name) {
		Object v = params.get(name);
		if (v == null) {
			return null;
		} else if (v instanceof String[]) {
			String[] strArr = (String[]) v;
			if (strArr.length > 0) {
				return strArr[0];
			} else {
				return null;
			}
		} else if (v instanceof String) {
			return (String) v;
		} else {
			return v.toString();
		}
	}

}
