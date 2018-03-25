package com.barclouds.android.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barclouds.dao.impl.UserDao;
import com.barclouds.service.UserService;

import net.sf.json.JSONObject;

public class BarcloudsLoginServlet extends HttpServlet{
	// 获得数据库操作的DAO
	private UserDao userDao;
	/**
	 * Constructor of the object.
	 */
	public BarcloudsLoginServlet() {
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
	
		StringBuffer sb = new StringBuffer("");
		String mStrResult = "";
		String uid,password;
		boolean loginFlag=false;
		// 获取前台表单提交后的用户名
		 uid = request.getParameter("user_Name");
		// 生日
		 password = request.getParameter("user_Password");
		try {
//			BufferedReader br = new BufferedReader(new InputStreamReader(
//					request.getInputStream(), "utf-8"));
//			String temp;
//			while ((temp = br.readLine()) != null) {
//				sb.append(temp);
//			}
//			br.close();
//			mStrResult = sb.toString();
//			//打印android端上传的JSON数据
//			System.out.println("RECIVER:"+mStrResult);
//			
//			// 将返回结果生成JSON对象
//			JSONObject jsonObject = JSONObject.fromObject(mStrResult);
//			uid = jsonObject.getString("user_Name");
//			password = jsonObject.getString("user_Password");
			
			UserService userService=new UserService();
	      	if(userService.login(userDao,uid,password)){
//	      		request.setAttribute("uidError", "您已登录成功！");
	      		loginFlag = true;
	      	}else{
//	      		request.setAttribute("uid", uid);
//	      		request.setAttribute("uidError", "用户名或密码错误！");
	      		loginFlag = false;
	      	}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PrintWriter pw = response.getWriter();
		//封装服务器返回的JSON对象
		JSONObject jsonReply = new JSONObject();
		if(loginFlag==true)
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
