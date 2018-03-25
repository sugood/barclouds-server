/**
 * 
 */
package com.barclouds.service;


import com.barclouds.dao.impl.DataDao;
import com.barclouds.dao.impl.InfoDao;
import com.barclouds.entity.Data;
import com.barclouds.entity.Info;
import com.barclouds.entity.PageBean;

/**
 * @author Administrator
 *
 */
public class DataService {
	
	public void addDataGroup(DataDao dataDao,Data data)throws Exception{
		System.out.println("barclouds:"+"DataService.addDataGroup");
		try{
			dataDao.addRecord(data);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public Data getData(DataDao dataDao,String uid,String field0)throws Exception{
	   Data data=null;
	   try{
		   data=dataDao.getRecordByField0(uid, field0);
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }
	   return data;
   }
	
   public Info searchInfo(String uid,String field0)throws Exception{	   
	   try{
//		   InfoDao infoDao = new InfoDao();
		   return new InfoDao().getRecordByField0(uid, field0);
	   }catch(Exception e){
		   throw e;
	   }
   }
   
	public PageBean<Data> findByPage(String uid,int pageCode, int pageSize) {
//		CustomerDao dao = new CustomerDaoImpl();
		DataDao dao = new DataDao();
		return dao.findByPage(uid,pageCode,pageSize);
	}
	
	public PageBean<Data> searchByPage(String uid,String field0,int pageCode, int pageSize) {
//		CustomerDao dao = new CustomerDaoImpl();
		DataDao dao = new DataDao();
		return dao.searchByPage(uid,field0,pageCode,pageSize);
	}
	
	public boolean deleteByid(String id) {
		DataDao dao = new DataDao();
		return dao.deleteByid(id);
	}
	
	public boolean deleteByUid(String uid) {
		DataDao dao = new DataDao();
		return dao.deleteRecord(uid);
	}
	
	public int getCount(String uid){
		DataDao dao = new DataDao();
		return dao.count(uid);
	}
	// totalPage 也是PageBean的一个属性
	// 通过计算，获取总页面
	public int getTotalPage(int pageSize,String uid) {
		// 获取总页数，如果100条，一页显示10条，页数10，如果109条，是11页
		int totalCount = getCount(uid);
		int totalPage =  totalCount/ pageSize;
		if(totalCount % pageSize == 0){
			return totalPage;
		}else{
			return totalPage + 1;
		}
	}
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
