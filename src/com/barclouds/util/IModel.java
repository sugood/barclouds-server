package com.barclouds.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 模型接口，所有业务逻辑处理器都应实现该接口
 * 
 * @author Steven
 * 
 */
public interface IModel {
	/**
	 * 模型接口
	 * 
	 * @param request
	 * @return
	 */
	public String execute(HttpServletRequest request,HttpServletResponse resp);
}
