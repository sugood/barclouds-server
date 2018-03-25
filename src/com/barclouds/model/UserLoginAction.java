package com.barclouds.model;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.barclouds.dao.impl.UserDao;
import com.barclouds.entity.User;
import com.barclouds.service.UserService;
import com.barclouds.util.IModel;

/**
 * 实现统一规定的模型
 * 
 * @author Sugood
 * 
 */
public class UserLoginAction implements IModel {
	// 获得数据库操作的DAO
	private UserDao userDao;
	// 获取日期操作类
	private Calendar calendar = Calendar.getInstance();
	private String gotoUrl="";
	
	public UserLoginAction() {
		userDao = new UserDao();
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
        try{
        	System.out.println("----用户登陆页面-----/r/n");
    		// 获取前台表单提交后的用户名
    		String uid = request.getParameter("uid");
    		// 生日
    		String password = request.getParameter("password");
    		// 获取按钮值
    		String submit = request.getParameter("submit");
    		
    		if(uid==null||password==null){
    			gotoUrl = "pages/login.jsp";
    			return gotoUrl;
    		}
			System.out.println("----正在登陆-----/r/n");
			System.out.println("用户名："+uid+",密码："+password+",模式："+submit);
			
    		// 创建进行验证的标志信息
//    		boolean checkFlag = true;
    		//判断点击了什么按钮
    		if(submit.equals("注册")){
    			gotoUrl = "pages/userRegister.jsp";
    		}else if (submit.equals("登录")){

    	      	UserService userService=new UserService();
    	      	if(userService.login(userDao,uid,password)){
    	      		request.getSession().setMaxInactiveInterval(30*60);		// 设置session失效时间（timeout），单位为秒
    				request.getSession().setAttribute("userinfo", uid);		// 用户名和密码正确，保存登录信息(获得session与jsp网页稍有不同)
    	      		request.setAttribute("uidError", "您已登录成功！");
    	      		gotoUrl = "system/welcome.jsp";
    	      	}else{
//    	      		request.setAttribute("uid", uid);
    	      		request.setAttribute("uidError", "用户名或密码错误！");
    	      		gotoUrl = "pages/login.jsp";
    	      	}
    		}

        }catch(Exception e){
        	e.printStackTrace();
    		request.setAttribute("uidError", "登录出错！"); 
    		gotoUrl ="pages/login.jsp";
        }
        return gotoUrl;
	}
}
