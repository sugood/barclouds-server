/**
 * 
 */
package com.barclouds.service;

import com.barclouds.dao.impl.UserDao;
import com.barclouds.entity.User;
import com.barclouds.util.MailUtil;

/**
 * @author Administrator
 *
 */
public class UserService {
	
	public void addRecord(UserDao userDao,User user,String basePath)throws Exception{
		
		StringBuffer body=new StringBuffer();
		StringBuffer link=new StringBuffer();
		body.append("您在码云扫描网站新注册的用户名是：");
		body.append(user.getUid());
		body.append(",请点击以下链接激活帐号！\n");
		link.append(basePath);
		link.append("activeUser.jsp?uid=");
		link.append(user.getUid());
		link.append("&validateCode=");
		link.append(user.getValidateCode());
		body.append(link.toString());
		try{
			userDao.addRecord(user);
			MailUtil.sendEmail(user.getEmail(),"码云扫描网站用户注册激活码",body.toString());
//			MailUtil.sendEmail("15820258199@163.com","码云扫描网站用户注册激活码","some one like you!");
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public User getUser(UserDao userDao,String uid)throws Exception{
	   User user=null;
	   try{
		   user=userDao.getRecord(uid);
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }
	   return user;
   }
	
   public boolean checkUid(UserDao userDao,String uid)throws Exception{	   
	   try{
		   User user=getUser(userDao,uid);
		   if(user==null)
			   return false;
		   else
			   return true;
	   }catch(Exception e){
		   throw e;
	   }
   }
   public boolean login(UserDao userDao,String uid,String password)throws Exception{
	   User user=null;
	   boolean result=false;
	   try{
		   user=userDao.getRecord(uid);
		   if(user!=null){
			   if(user.getPassword().equals(password)){
				   user.setLoginNum(Integer.toString(Integer.parseInt(user.getLoginNum())+1));
				   userDao.updateRecord(user);
				   result=true;
			   }
			   else{ result=false; }
		   }else{ result=false;}
	   }catch(Exception e){
		   e.printStackTrace();	   
		   throw e;
	   }
	   return result;
   }
}
