package com.barclouds.model;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barclouds.service.CustomerService;
import com.barclouds.util.IModel;
import com.barclouds.entity.Customer;
import com.barclouds.entity.PageBean;

/**
 * 分页查询
 * @author Sugood
 */
public class ListByPageAction implements IModel {
	
	private String gotoUrl="";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("----数据分页显示页面-----/r/n");
		/**
		 * pageCode	当前页
		 * pageSize 设置每页显示的记录条数
		 * totalPage  总页数（计算出来的）
		 * totalCount （从数据库查询）
		 * beanList （从数据库查询）
		 */
		// 处理当前页（用户点击，传过来） 默认查询的是第一页数据
		int pageCode = getPageCode(request);
		int pageSize = 10;
		
		// 处理数据
		CustomerService cs = new CustomerService();
		// 分页的查询后台
		PageBean<Customer> page = cs.findByPage(pageCode,pageSize);
		// 转发
		Map map = new HashMap();
		map.put("title", "什么");
		map.put("page", page);
		request.setAttribute("map", map);
//		request.setAttribute("page", page);
		gotoUrl="system/listByPage.jsp";

		return gotoUrl;
	}
	
	/**
	 * 获取当前页的信息（返回第一页，如果不是默认情况下，返回从客户端获取的当前页）
	 * @param request
	 * @return
	 */
	public int getPageCode(HttpServletRequest request){
		// 先获取从客户端传过来的参数
		String pc = request.getParameter("pc");
		// 进行判断
		if(pc == null || pc.trim().isEmpty()){
			// 返回第一页
			return 1;
		}
		return Integer.parseInt(pc);
	}

}








