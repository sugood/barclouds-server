/**
 * 
 */
package com.barclouds.service;


import java.util.List;

import com.barclouds.dao.impl.InfoDao;
import com.barclouds.entity.Info;
import com.barclouds.entity.PageBean;

/**
 * @author Administrator
 *
 */
public class InfoService {
	
	public void addDataGroup(InfoDao infoDao,Info info)throws Exception{
		System.out.println("barclouds:"+"InfoService.addDataGroup");
		try{
			infoDao.addRecord(info);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public void addDataBatch(InfoDao infoDao,List<Info> info)throws Exception{
		System.out.println("barclouds:"+"InfoService.addDataBatch");
		try{
			infoDao.addBatch(info);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	public Info getData(InfoDao infoDao,String uid,String field0)throws Exception{
		Info info=null;
	   try{
		   info=infoDao.getRecordByField0(uid, field0);
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }
	   return info;
   }
	
	/**
	 * 分页查询
	 * @param pageCode
	 * @param pageSize
	 * @return
	 */
	public PageBean<Info> findByPage(String uid,int pageCode, int pageSize) {
//		CustomerDao dao = new CustomerDaoImpl();
		InfoDao dao = new InfoDao();
		return dao.findByPage(uid,pageCode,pageSize);
	}
	
	public PageBean<Info> searchByPage(String uid,String field0,int pageCode, int pageSize) {
//		CustomerDao dao = new CustomerDaoImpl();
		InfoDao dao = new InfoDao();
		return dao.searchByPage(uid,field0,pageCode,pageSize);
	}
	
	public boolean deleteByid(String id) {
		InfoDao dao = new InfoDao();
		return dao.deleteByid(id);
	}
	
	public boolean deleteByUid(String uid) {
		InfoDao dao = new InfoDao();
		return dao.deleteRecord(uid);
	}
//   public boolean searchInfo(InfoDao infoDao,String uid,String field0)throws Exception{	   
//	   try{
//		   Info info=getInfo(infoDao,uid);
//		   if(user==null)
//			   return false;
//		   else
//			   return true;
//	   }catch(Exception e){
//		   throw e;
//	   }
//   }
//   public boolean login(UserDao userDao,String uid,String password)throws Exception{
//	   User user=null;
//	   boolean result=false;
//	   Connection connection = null;
//	   try{
//		   user=userDao.getUser(uid);
//		   if(user!=null){
//			   if(user.getPassword().equals(password)){
//				   user.setLoginNum(user.getLoginNum()+1);
//				   userDao.updateUser(user);
//				   result=true;
//			   }
//			   else{ result=false; }
//		   }else{ result=false;}
//	   }catch(Exception e){
//		   e.printStackTrace();	   
//		   throw e;
//	   }
//	   return result;
//   }
}
