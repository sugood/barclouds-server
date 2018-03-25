/**
 * 
 */
package com.barclouds.service;

import com.barclouds.dao.impl.InfoIndexDao;
import com.barclouds.entity.InfoIndex;

/**
 * @author Administrator
 *
 */
public class InfoIndexService {
	
	public void addDataGroup(String uid,InfoIndexDao infoIndexDao,InfoIndex infoIndex)throws Exception{
		System.out.println("barclouds:"+"InfoIndexService.addDataGroup");
		try{
			if(infoIndexDao.judgeByUid(uid))
				infoIndexDao.updateRecord(infoIndex);
			else
				infoIndexDao.addRecord(infoIndex);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public InfoIndex getData(InfoIndexDao infoIndexDao,String uid)throws Exception{
		InfoIndex infoIndex=null;
	   try{
		   infoIndex=infoIndexDao.getRecord(uid);
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }
	   return infoIndex;
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
