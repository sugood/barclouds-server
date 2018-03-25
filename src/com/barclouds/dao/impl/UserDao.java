/**
 * 
 */
package com.barclouds.dao.impl;

import java.util.List;

import com.barclouds.dao.iface.IUserDao;
import com.barclouds.entity.PageBean;
import com.barclouds.entity.User;
import com.barclouds.util.DaoHandle;


/**
 * @author Sugood
 */
public class UserDao implements IUserDao {

//	public boolean addUser(User user){
//		// 创建标志位
//		boolean flag = false;
//		// 创建sql语句
//		String sql = "Insert into user(uid,password,realName,gender,email,tel,question,answer,validateCode) values(?,?,?,?,?,?,?,?,?)";
//		// 填充参数(主键不需要填写，自增)
//				Object[] parameters = new Object[] { user.getUid(),user.getPassword(),
//						user.getRealName(), user.getGender(), user.getEmail(),
//						user.getTel(),user.getQuestion(),user.getAnswer(),user.getValidateCode()};
//		flag = DaoHandle.executeDML(sql, parameters) > 0 ? true : false;
//		return flag;
//	}
//
//	public boolean updateUser(User user){
//		// 创建标志位
//		boolean flag = false;
//		// 创建sql语句
//		String sql = "update user set password=?,realName=?,gender=?,email=?,tel=?,question=?,answer=?,validateCode=?,loginNum=? where uid=? ";
//		// 注入参数
//		Object[] parameters = new Object[] { user.getPassword(), user.getRealName(),user.getGender(),
//				user.getEmail(), user.getTel(), user.getQuestion(),
//				user.getAnswer(),user.getValidateCode(),user.getLoginNum(),
//				user.getUid()};
//		flag = DaoHandle.executeDML(sql, parameters) > 0 ? true : false;
//		return flag;
//	}
//
//	public boolean deleteUser(String uid) {
//		// 创建标志位
//		boolean flag = false;
//		// 创建sql语句
//		String sql = "delete from user where uid=?";
//		// 填充参数
//		Object[] parameters = new Object[] { uid };
//		// 执行数据库数据删除操作
//		flag = DaoHandle.executeDML(sql, parameters) > 0 ? true : false;
//		return flag;
//	}
//
//	public List<User> listAllUser(){
//		// 创建sql语句
//		String sql = "select * from user order by uid asc";
//		// 查询所有的记录
//		List<User> list = (List<User>) DaoHandle.executeQueryForMultiple(sql,
//				null, User.class);
//		return list;
//	}
//
//	public User getUser(String uid) {
//		// 创建sql语句
//		String sql = "select * from user where uid= ?";
//		// 填充参数
//		Object[] parameters = new Object[] { uid };
//		// 查找单个记录
//		User user = DaoHandle.executeQueryForSingle(sql, parameters, User.class);
//		return user;
//	}

	@Override
	public boolean addRecord(User t) {
		// TODO Auto-generated method stub
		// 创建标志位
		boolean flag = false;
		// 创建sql语句
		String sql = "Insert into user(uid,password,realName,gender,email,tel,question,answer,validateCode) values(?,?,?,?,?,?,?,?,?)";
		// 填充参数(主键不需要填写，自增)
				Object[] parameters = new Object[] { t.getUid(),t.getPassword(),
						t.getRealName(), t.getGender(), t.getEmail(),
						t.getTel(),t.getQuestion(),t.getAnswer(),t.getValidateCode()};
		flag = DaoHandle.executeDML(sql, parameters) > 0 ? true : false;
		return flag;
	}

	@Override
	public boolean updateRecord(User t) {
		// TODO Auto-generated method stub
		// 创建标志位
		boolean flag = false;
		// 创建sql语句
		String sql = "update user set password=?,realName=?,gender=?,email=?,tel=?,question=?,answer=?,validateCode=?,loginNum=? where uid=? ";
		// 注入参数
		Object[] parameters = new Object[] { t.getPassword(), t.getRealName(),t.getGender(),
				t.getEmail(), t.getTel(), t.getQuestion(),
				t.getAnswer(),t.getValidateCode(),t.getLoginNum(),
				t.getUid()};
		flag = DaoHandle.executeDML(sql, parameters) > 0 ? true : false;
		return flag;
	}

	@Override
	public boolean deleteRecord(String uid) {
		// TODO Auto-generated method stub
		// 创建标志位
		boolean flag = false;
		// 创建sql语句
		String sql = "delete from user where uid=?";
		// 填充参数
		Object[] parameters = new Object[] { uid };
		// 执行数据库数据删除操作
		flag = DaoHandle.executeDML(sql, parameters) > 0 ? true : false;
		return flag;
	}

	@Override
	public boolean deleteRecordByField0(String uid, String field0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> listAllRecord() {
		// TODO Auto-generated method stub
		// 创建sql语句
		String sql = "select * from user order by uid asc";
		// 查询所有的记录
		List<User> list = (List<User>) DaoHandle.executeQueryForMultiple(sql,
				null, User.class);
		return list;
	}

	@Override
	public User getRecord(String uid) {
		// TODO Auto-generated method stub
		// 创建sql语句
		String sql = "select * from user where uid= ?";
		// 填充参数
		Object[] parameters = new Object[] { uid };
		// 查找单个记录
		User user = DaoHandle.executeQueryForSingle(sql, parameters, User.class);
		return user;
	}

	@Override
	public User getRecordByField0(String uid, String field0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteByid(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<User> findByPage(String uid,int pageCode, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean judgeByUid(String uid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean addBatch(List<User> t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int count(String uid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageBean<User> searchByPage(String uid, String field0, int pageCode,
			int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
}
