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
import com.barclouds.entity.User;
import com.barclouds.service.UserService;
import com.barclouds.util.Generator;

import net.sf.json.JSONObject;

public class AndroidRegisterServlet extends HttpServlet{
	// 获得数据库操作的DAO
	private UserDao userDao;
	/**
	 * Constructor of the object.
	 */
	public AndroidRegisterServlet() {
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
	
		// 获取前台表单提交后的用户名
		response.setContentType("text/html;charset=utf-8");
		//获取前台表单提交的信息
    	String uid=request.getParameter("uid");
    	String password=request.getParameter("password");
    	String confirmPassword=request.getParameter("confirmPassword");
    	String email=request.getParameter("email");
//    	int gender=Integer.parseInt(request.getParameter("gender"));
    	String question=request.getParameter("question");
    	String answer=request.getParameter("answer");
//    	String realName=request.getParameter("realName");
//    	String tel=request.getParameter("tel");
    	boolean loginFlag=false; 
    	
    	// 创建进行验证的标志信息
    	boolean checkFlag = true;
    			
//		if ("".equals(uid) || uid == null) {
//			checkFlag = false;
//		}
		
    	if("".equals(uid)||uid==null || password.trim().equals("") || 
    			 password.trim().equals("") ||confirmPassword==null || 
    			 confirmPassword.trim().equals("") || email==null || email.trim().equals("") ||
    			 question==null || question.equals("") || answer==null || answer.equals("")){
    			 	checkFlag = false;
    	}else if(!password.equals(confirmPassword)){
		 	checkFlag = false;
    	}else{
	    	UserService service=new UserService();
	    	try{
		    	boolean isExist=service.checkUid(userDao,uid);
		    	if(isExist){
		    		checkFlag = false;
		    	}else{
			    	User user=new User();
			    	user.setUid(uid);
			    	user.setPassword(password);
			    	user.setEmail(email);
			    	user.setGender("1");
			    	user.setQuestion(question);
			    	user.setAnswer(answer);
			    	user.setTel("*");
			    	user.setRealName("*");
			    	String validateCode=Generator.getEmailCode();
			    	user.setValidateCode(validateCode);
			    	String path = request.getContextPath();
			    	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			    	service.addRecord(userDao,user,basePath);
//			        PrintWriter out = response.getWriter();
//			        out.println("<center>注册成功！</center>");
			        checkFlag = true;
			    }
	    	}catch(Exception e){
	    		e.printStackTrace();  
	    		checkFlag = false;
	    	}
    	}
		
		PrintWriter pw = response.getWriter();
		//封装服务器返回的JSON对象
		JSONObject jsonReply = new JSONObject();
		
		if(checkFlag==true)
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
