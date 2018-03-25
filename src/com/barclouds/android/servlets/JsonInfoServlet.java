package com.barclouds.android.servlets;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.barclouds.dao.impl.InfoIndexDao;
import com.barclouds.dao.impl.UserDao;
import com.barclouds.entity.Info;
import com.barclouds.entity.InfoIndex;
import com.barclouds.entity.PageBean;
import com.barclouds.service.InfoService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonInfoServlet extends HttpServlet{
	// 获得数据库操作的DAO
	private UserDao userDao;
	/**
	 * Constructor of the object.
	 */
	public JsonInfoServlet() {
		userDao = new UserDao();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * pageCode	当前页
		 * pageSize 设置每页显示的记录条数
		 * totalPage  总页数（计算出来的）
		 * totalCount （从数据库查询）
		 * beanList （从数据库查询）
		 */
		System.out.println("----JSON-正在分页显示数据信息-----/r/n");
		try{
			// 获取前台表单提交后的用户名
			response.setContentType("text/html;charset=utf-8");
			//获取前台表单提交的信息
	    	String uid=request.getParameter("uid");
	    	String selectFlag=request.getParameter("selectFlag");
	    	String field0 =request.getParameter("field0");
	    	
	//		String uid = "sugood";
			// 处理当前页（用户点击，传过来） 默认查询的是第一页数据
			int pageCode = getPageCode(request);
			int pageSize = 25;
			
	//		InfoIndex infoIndex = new InfoIndex();
	//		InfoIndexDao infoIndexDao = new InfoIndexDao();
			
			System.out.println("第："+pageCode+"页");
			// 处理数据
			InfoService cs = new InfoService();
	
			PageBean<Info> page = new PageBean<Info>();
			if (selectFlag.equals("page")){
				// 分页的查询后台
				page = cs.findByPage(uid, pageCode, pageSize);
			}else if(selectFlag.equals("search")){
				// 搜索关键字
				page = cs.searchByPage(uid, field0 , pageCode, pageSize);	
			}
			//读取标题信息
			
	//		infoIndex = infoIndexDao.getRecord(uid);
	//		System.out.println("BarcloudsDebug:InfoListPageServices.execute="+infoIndex.getFieldName0());
			// 转发
	//		Map map = new HashMap();
	//		map.put("title",infoIndex);
	//		map.put("page", page);
			
			PrintWriter pw = response.getWriter();
			//封装服务器返回的JSON对象
			JSONObject jsonReply = new JSONObject();
			jsonReply = JSONObject.fromObject(page);
	//		JSONArray array = new JSONArray();
	//		array = JSONArray.fromObject(page.getBeanList());
			//打印返回的JSON数据
			System.out.println("SEND:"+jsonReply);
			pw.println(jsonReply);
			pw.flush();
			pw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	
	/**
	 * 获取当前页的信息（返回第一页，如果不是默认情况下，返回从客户端获取的当前页）
	 * @param request
	 * @return
	 */
	public int getPageCode(HttpServletRequest request){
		// 先获取从客户端传过来的参数
		String pc = request.getParameter("pageNo");
		// 进行判断
		if(pc == null || pc.trim().isEmpty()){
			// 返回第一页
			return 1;
		}
		return Integer.parseInt(pc);
	}
}
