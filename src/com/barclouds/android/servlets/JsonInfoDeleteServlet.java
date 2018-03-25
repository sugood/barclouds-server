package com.barclouds.android.servlets;

import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barclouds.dao.impl.InfoDao;
import com.barclouds.service.InfoService;

import net.sf.json.JSONObject;

public class JsonInfoDeleteServlet extends HttpServlet{
	// 获得数据库操作的DAO
	private InfoDao infoDao;
	
	/**
	 * Constructor of the object.
	 */
	public JsonInfoDeleteServlet() {
		infoDao = new InfoDao();
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

		boolean deleteflag=false;
		
		System.out.println("----JSON-正在删除数据页面-----/r/n");

		try{
			String id = request.getParameter("id");
			String flag = request.getParameter("flag");
			String uid = request.getParameter("uid");
			
			// 调用业务层处理
			InfoService cs = new InfoService();
			if(flag.equals("1")){
	//			System.out.println("删除所有数据，uid="+uid);
				// 删除当前用户所有的数据
	    		if(cs.deleteByUid(uid)){
	    			// 删除成功了
	    			// 再去访问dataListByPage
	    			//这样访问体验不是很好
	    			deleteflag=true;
	//    			response.sendRedirect(request.getContextPath()+"/dataListByPage.do?actionName=dataListByPageAction&pc=1");
	    		}
			}else if(flag.equals("0")){
	    		// 删除当前数据
	    		if(cs.deleteByid(id)){
	    			// 删除成功了
	    			// 再去访问dataListByPage
	    			//这样访问体验不是很好
	    			deleteflag=true;
	//    			response.sendRedirect(request.getContextPath()+"/dataListByPage.do?actionName=dataListByPageAction&pc=1");
	    		}
			}
        }catch(Exception e){
        	e.printStackTrace();
        }
		
		PrintWriter pw = response.getWriter();
		//封装服务器返回的JSON对象
		JSONObject jsonReply = new JSONObject();
		if(deleteflag==true)
			jsonReply.put("success","1");
		else
			jsonReply.put("success","0");
		//打印返回的JSON数据
		System.out.println("SEND:"+jsonReply);
		pw.write(jsonReply.toString());
		pw.flush();
		pw.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
}
