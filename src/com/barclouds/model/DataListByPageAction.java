package com.barclouds.model;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barclouds.service.DataService;
import com.barclouds.util.IModel;
import com.barclouds.dao.impl.InfoIndexDao;
import com.barclouds.entity.Data;
import com.barclouds.entity.InfoIndex;
import com.barclouds.entity.PageBean;

/**
 * 分页查询
 * @author Sugood
 */
public class DataListByPageAction implements IModel {
	
	private String gotoUrl="";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		/**
		 * pageCode	当前页
		 * pageSize 设置每页显示的记录条数
		 * totalPage  总页数（计算出来的）
		 * totalCount （从数据库查询）
		 * beanList （从数据库查询）
		 */
		System.out.println("----正在分页显示数据信息-----/r/n");

		// 处理当前页（用户点击，传过来） 默认查询的是第一页数据
		int pageCode = getPageCode(request);
		int pageSize = 10;
		
		InfoIndex infoIndex = new InfoIndex();
		InfoIndexDao infoIndexDao = new InfoIndexDao();
		
		System.out.println("第："+pageCode+"页");
		// 处理数据
		DataService cs = new DataService();
		//获取session中的用户名
		String uid=(String)request.getSession().getAttribute("userinfo");
		// 分页的查询后台
		PageBean<Data> page = cs.findByPage(uid,pageCode,pageSize);
		//读取标题信息
		
		infoIndex = infoIndexDao.getRecord(uid);
		if(infoIndex == null){
			infoIndex = new InfoIndex(uid,"第一列","第二列","第三列","第四列","第五列","第六列","第七列","第八列","第九列","第十列");
		}
		// 转发
		Map map = new HashMap();
		map.put("title",infoIndex);
		map.put("page", page);
		request.setAttribute("map", map);
		
//		request.setAttribute("page", page);
		gotoUrl="system/dataListByPage.jsp";

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








