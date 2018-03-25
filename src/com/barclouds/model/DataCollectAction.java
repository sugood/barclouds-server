package com.barclouds.model;

import java.awt.List;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barclouds.dao.impl.DataDao;
import com.barclouds.dao.impl.InfoDao;
import com.barclouds.dao.impl.InfoIndexDao;
import com.barclouds.dao.impl.UserDao;
import com.barclouds.entity.Data;
import com.barclouds.entity.Info;
import com.barclouds.entity.InfoIndex;
import com.barclouds.entity.User;
import com.barclouds.service.DataService;
import com.barclouds.service.UserService;
import com.barclouds.util.IModel;

public class DataCollectAction implements IModel {
	// 获得数据库操作的DAO
	private DataDao dataDao;
	private InfoDao infoDao;
	private InfoIndex infoIndex;
	private InfoIndexDao infoIndexDao;
	private Map map;
	private Data data;
	// 获取日期操作类
	private Calendar calendar = Calendar.getInstance();
	private String gotoUrl="";
	
	public DataCollectAction() {
		dataDao = new DataDao();
		infoIndex = new InfoIndex();
		infoIndexDao = new InfoIndexDao();
		map = new HashMap();
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
        try{
        	System.out.println("----数据采集页面-----");
    		// 获取前台表单提交后的条码数据
    		String field0 = request.getParameter("field0");
    		// 生日
    		String password = request.getParameter("password");
    		// 获取按钮值
    		String submit = request.getParameter("submit");
    		// 获取状态值
    		String state = request.getParameter("state");
			//获取session中的用户名
			String uid=(String)request.getSession().getAttribute("userinfo");
			
			infoIndex = infoIndexDao.getRecord(uid);
			if(infoIndex == null){
				infoIndex = new InfoIndex(uid,"第一列","第二列","第三列","第四列","第五列","第六列","第七列","第八列","第九列","第十列");
			}
			//写入标题信息
			map.put("title",infoIndex);
			data=new Data("","","","","","","","","","", "");
			map.put("page", data);
			
    		if(state.equals("0")){
    			System.out.println("state=0");
    			// 转发
    			request.setAttribute("map", map);
    			gotoUrl = "system/dataCollect.jsp";
    		}else if(state.equals("1")) {
    			System.out.println("state=1");
	    		// 创建进行验证的标志信息
	//    		boolean checkFlag = true;
	    		//判断点击了什么按钮
	    		if(submit.equals("返回")){
	    			gotoUrl = "system/welcome.jsp";
	    		}else if (submit.equals("确认")){
	    			DataService dataService=new DataService();
	    			Info info=dataService.searchInfo(uid, field0);
	    			
	    			if(info!=null){
		    			data.setUid(uid);
		    			data.setField0(field0);
		    			data.setField1(info.getField1());
		    			data.setField2(info.getField2());
		    			data.setField3(info.getField3());
		    			data.setField4(info.getField4());
		    			data.setField5(info.getField5());
		    			data.setField6(info.getField6());
		    			data.setField7(info.getField7());
		    			data.setField8(info.getField8());
		    			data.setField9(info.getField9());
	    			}else{
		    			data.setUid(uid);
		    			data.setField0(field0);
		    			data.setField1("");
		    			data.setField2("");
		    			data.setField3("");
		    			data.setField4("");
		    			data.setField5("");
		    			data.setField6("");
		    			data.setField7("");
		    			data.setField8("");
		    			data.setField9("");
	    			}
	    			dataService.addDataGroup(dataDao, data);
	    	      	
	    			
	
	    			// 转发
	    			map.put("page", data);
	    			request.setAttribute("map", map);
	    	      	gotoUrl = "system/dataCollect.jsp";
	//    	      	if(userService.login(userDao,uid,password)){
	//    	      		request.setAttribute("uidError", "您已登录成功！");
	//    	      		gotoUrl = "datac.jsp";
	//    	      	}else{
	////    	      		request.setAttribute("uid", uid);
	//    	      		request.setAttribute("uidError", "用户名或密码错误！");
	//    	      		gotoUrl = "login.jsp";
	//    	      	}
	    		}	
    		}else{
    			gotoUrl="system/dataCollect.jsp";
    		}

        }catch(Exception e){
        	e.printStackTrace();
    		request.setAttribute("uidError", "录入数据出错！"); 
    		gotoUrl ="pages/login.jsp";
        }
        return gotoUrl;
	}
}