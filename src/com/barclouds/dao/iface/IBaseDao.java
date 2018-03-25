package com.barclouds.dao.iface;

import java.util.List;

//import com.barclouds.dao.impl.T;
import com.barclouds.entity.PageBean;



/**
 * 通过泛型机制为所有的实现类提供以下方法
 * 
 * @author Sugood
 * 
 */
public interface IBaseDao<T> {
	/**
	 * 新增一条数据
	 * 
	 * @param t
	 * @return
	 */
	public boolean addRecord(T t);
	/**
	 * 修改数据
	 * 
	 * @param t
	 * @return
	 */
	public boolean updateRecord(T t);
	/**
	 * 根据编号(id)进行删除一条数据
	 * 
	 * @param uid
	 * @return
	 */
	public boolean deleteByid(String id);
	/**
	 * 根据编号(uid)进行删除一条数据
	 * 
	 * @param uid
	 * @return
	 */
	public boolean deleteRecord(String uid);
	
	/**
	 * 根据编号(uid)与(field0)进行删除一条数据
	 * 
	 * @param uid
	 * @return
	 */
	public boolean deleteRecordByField0(String uid,String field0);
	/**
	 * 返回所有的信息
	 * @return
	 */
	public List<T> listAllRecord();
	/**
	 * 根据编号(uid)取用户名
	 * 
	 * @param uid
	 * @return
	 */
	public T getRecord(String uid);
	/**
	 * 根据编号(uid)与(field0)取用户名
	 * 
	 * @param uid
	 * @return
	 */
	public T getRecordByField0(String uid,String field0);
	/**
	 * 根据编号(id)读取一行数据
	 * 
	 * @param id
	 * @return
	 */
	public T findById(String id);
	/**
	 * 根据用户号(uid)判断是否有数据
	 * 
	 * @param uid
	 * @return boolean
	 */
	public boolean judgeByUid(String uid);
//	public List<Customer> findByWhere(String username, String type);
	/**
	 * 根据分页数(pageCode)分页大小(pageSize)读取分页数据
	 * 
	 * @param pageCode，pageSize
	 * @return
	 */
	public PageBean<T> findByPage(String uid,int pageCode, int pageSize);
	
	/**
	 * 根据分页数(pageCode)分页大小(pageSize)读取查询数据
	 * 
	 * @param pageCode，pageSize
	 * @return
	 */
	public PageBean<T> searchByPage(String uid,String field0,int pageCode, int pageSize);
	/**
	 * 计算总记录
	 * 
	 * @param 
	 * @return
	 */
	public int count ();
	/**
	 * 计算总记录
	 * 
	 * @param 
	 * @return
	 */
	public int count (String uid);
	/**
	 * 批量插入数据
	 * 
	 * @param 
	 * @return
	 */
	public boolean addBatch(List<T> t);
}
