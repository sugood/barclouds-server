package com.barclouds.model;

import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barclouds.dao.impl.UserDao;
import com.barclouds.entity.User;
import com.barclouds.service.UserService;
import com.barclouds.util.Generator;
import com.barclouds.util.IModel;

public class UserRegisterAction implements IModel {
	// 获得数据库操作的DAO
	private UserDao userDao;
	// 获取日期操作类
	private Calendar calendar = Calendar.getInstance();

	public UserRegisterAction() {
		userDao = new UserDao();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("----用户注册页面-----/r/n");
		response.setContentType("text/html;charset=utf-8");
		//获取前台表单提交的信息
    	String uid=request.getParameter("uid");
    	String password=request.getParameter("password");
    	String confirmPassword=request.getParameter("confirmPassword");
    	String email=request.getParameter("email");
    	String gender=request.getParameter("gender");
    	String question=request.getParameter("question");
    	String answer=request.getParameter("answer");
    	String realName=request.getParameter("realName");
    	String tel=request.getParameter("tel");
    	
    	// 创建进行验证的标志信息
    	boolean checkFlag = true;
    			
		if ("".equals(uid) || uid == null) {
			request.setAttribute("userNameError", "请填写用户名");
			checkFlag = false;
			return "index.jsp";
		} else {
			request.setAttribute("uid", uid);
		}
		
    	if(uid==null || password.trim().equals("") || 
    			 password.trim().equals("") ||confirmPassword==null || 
    			 confirmPassword.trim().equals("") || email==null || email.trim().equals("") ||
    			 question==null || question.equals("") || answer==null || answer.equals("")){
    			 	request.setAttribute("userNameError","请将必填的数据填写完整!");
    			 	checkFlag = false;
    			 	return "index.jsp";
    	}else if(!password.equals(confirmPassword)){
		 	request.setAttribute("userNameError","两次密码不匹配!");
		 	checkFlag = false;
		 	return "index.jsp";
    	}
    	UserService service=new UserService();
    	try{
	    	boolean isExist=service.checkUid(userDao,uid);
	    	if(isExist){
	    		request.setAttribute("userNameError","用户名已经存在！");
	    		checkFlag = false;
	    		
//				response.setCharacterEncoding("gbk");
//				response.setContentType("text/html;charset=gbk");
////				response.setContentType("charset=gb2312");
//				PrintWriter out = response.getWriter();
//				out.print("<script>alert('用户名已经存在！，请重新输入...'); window.location='/BarClouds/system/userRegister.jsp'</script>");
//				out.flush();
//				out.close();
				
	    		return "userRegister.jsp";
	    	}
	    	User user=new User();
	    	user.setUid(uid);
	    	user.setPassword(password);
	    	user.setEmail(email);
	    	user.setGender(gender);
	    	user.setQuestion(question);
	    	user.setAnswer(answer);
	    	user.setTel(tel);
	    	user.setRealName(realName);
	    	String validateCode=Generator.getEmailCode();
	    	user.setValidateCode(validateCode);
	    	String path = request.getContextPath();
	    	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	    	service.addRecord(userDao,user,basePath);
	        PrintWriter out = response.getWriter();
	        out.println("<center>注册成功！</center>");
    	}catch(Exception e){
    		e.printStackTrace();  
    		request.setAttribute("userNameError","注册出错！");
    		checkFlag = false;
    	}
    	return "pages/login.jsp";
	}
	
	
}
