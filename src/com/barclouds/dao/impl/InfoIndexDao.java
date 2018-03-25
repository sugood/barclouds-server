/**
 * 
 */
package com.barclouds.dao.impl;

import java.util.List;

import com.barclouds.dao.iface.IInfoIndexDao;
import com.barclouds.entity.InfoIndex;
import com.barclouds.entity.PageBean;
import com.barclouds.util.DaoHandle;


/**
 * @author Sugood
 */
public class InfoIndexDao implements IInfoIndexDao {

//	public boolean addInfoIndex(InfoIndex infoIndex){
//		// 创建标志位
//		boolean flag = false;
//		// 创建sql语句
//		String sql = "Insert into infoIndex(uid,fieldNameName0,fieldName1,fieldName2,fieldName3,fieldName4,fieldName5,"
//				+ "fieldName6,fieldName7,fieldName8,fieldName9) values(?,?,?,?,?,?,?,?,?,?,?)";
//		// 填充参数(主键不需要填写，自增)
//				Object[] parameters = new Object[] { infoIndex.getUid(),infoIndex.getFieldName0(),
//						infoIndex.getFieldName1(), infoIndex.getFieldName2(), infoIndex.getFieldName3(),infoIndex.getFieldName4(),
//						infoIndex.getFieldName5(),infoIndex.getFieldName6(),infoIndex.getFieldName7(),infoIndex.getFieldName8(),infoIndex.getFieldName9()};
//		flag = DaoHandle.executeDML(sql, parameters) > 0 ? true : false;
//		return flag;
//	}
//
//	public boolean updateInfoIndex(InfoIndex infoIndex){
//		// 创建标志位
//		boolean flag = false;
//		// 创建sql语句
//		String sql = "update infoIndex set fieldName1=?,fieldName2=?,fieldName3=?,fieldName4=?,fieldName5=?,fieldName6=?,"
//				+ "fieldName7=?,fieldName8=?,fieldName9=? where uid=? and fieldName0=?";
//		// 注入参数
//		Object[] parameters = new Object[] { infoIndex.getFieldName1(),infoIndex.getFieldName2(),infoIndex.getFieldName3(),
//				infoIndex.getFieldName4(), infoIndex.getFieldName5(), infoIndex.getFieldName6(),infoIndex.getFieldName7(),
//				infoIndex.getFieldName8(),infoIndex.getFieldName9(),infoIndex.getUid(),infoIndex.getFieldName0()};
//		flag = DaoHandle.executeDML(sql, parameters) > 0 ? true : false;
//		return flag;
//	}
//
//	public boolean deleteInfoIndex(String uid,String field0) {
//		// 创建标志位
//		boolean flag = false;
//		// 创建sql语句
//		String sql = "delete from infoIndex where uid=? and field0= ?";
//		// 填充参数
//		Object[] parameters = new Object[] { uid,field0 };
//		// 执行数据库数据删除操作
//		flag = DaoHandle.executeDML(sql, parameters) > 0 ? true : false;
//		return flag;
//	}
//
//	public List<InfoIndex> listAllInfoIndex(){
//		// 创建sql语句
//		String sql = "select * from infoIndex order by uid asc";
//		// 查询所有的记录
//		List<InfoIndex> list = (List<InfoIndex>) DaoHandle.executeQueryForMultiple(sql,
//				null, InfoIndex.class);
//		return list;
//	}
//
//	public InfoIndex getInfoIndex(String uid ,String field0) {
//		// 创建sql语句
//		String sql = "select * from infoIndex where uid= ? and field0 =?";
//		// 填充参数
//		Object[] parameters = new Object[] { uid ,field0};
//		// 查找单个记录
//		InfoIndex infoIndex = DaoHandle.executeQueryForSingle(sql, parameters, InfoIndex.class);
//		return infoIndex;
//	}

	@Override
	public boolean addRecord(InfoIndex t) {
		// TODO Auto-generated method stub
		// 创建标志位
		boolean flag = false;
		// 创建sql语句
		String sql = "Insert into infoIndex(uid,fieldName0,fieldName1,fieldName2,fieldName3,fieldName4,fieldName5,"
				+ "fieldName6,fieldName7,fieldName8,fieldName9) values(?,?,?,?,?,?,?,?,?,?,?)";
		// 填充参数(主键不需要填写，自增)
				Object[] parameters = new Object[] { t.getUid(),t.getFieldName0(),t.getFieldName1(), 
						t.getFieldName2(), t.getFieldName3(),t.getFieldName4(),t.getFieldName5(),
						t.getFieldName6(),t.getFieldName7(),t.getFieldName8(),t.getFieldName9()};
		flag = DaoHandle.executeDML(sql, parameters) > 0 ? true : false;
		return flag;
	}

	@Override
	public boolean updateRecord(InfoIndex t) {
		// TODO Auto-generated method stub
		// 创建标志位
		boolean flag = false;
		// 创建sql语句
		String sql = "update infoIndex set fieldName1=?,fieldName2=?,fieldName3=?,fieldName4=?,fieldName5=?,fieldName6=?,"
				+ "fieldName7=?,fieldName8=?,fieldName9=? where uid=? and fieldName0=?";
		// 注入参数
		Object[] parameters = new Object[] { t.getFieldName1(),t.getFieldName2(),t.getFieldName3(),
				t.getFieldName4(), t.getFieldName5(), t.getFieldName6(),t.getFieldName7(),
				t.getFieldName8(),t.getFieldName9(),t.getUid(),t.getFieldName0()};
		flag = DaoHandle.executeDML(sql, parameters) > 0 ? true : false;
		return flag;
	}

	@Override
	public boolean deleteByid(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRecord(String uid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRecordByField0(String uid, String field0) {
		// TODO Auto-generated method stub
		// 创建标志位
		boolean flag = false;
		// 创建sql语句
		String sql = "delete from infoIndex where uid=? and field0= ?";
		// 填充参数
		Object[] parameters = new Object[] { uid,field0 };
		// 执行数据库数据删除操作
		flag = DaoHandle.executeDML(sql, parameters) > 0 ? true : false;
		return flag;
	}

	@Override
	public List<InfoIndex> listAllRecord() {
		// TODO Auto-generated method stub
		// 创建sql语句
		String sql = "select * from infoIndex order by uid asc";
		// 查询所有的记录
		List<InfoIndex> list = (List<InfoIndex>) DaoHandle.executeQueryForMultiple(sql,
				null, InfoIndex.class);
		return list;
	}

	@Override
	public InfoIndex getRecord(String uid) {
		// TODO Auto-generated method stub
		String sql = "select * from infoIndex where uid= ?";
		// 填充参数
		Object[] parameters = new Object[] { uid };
		// 查找单个记录
		InfoIndex infoIndex = DaoHandle.executeQueryForSingle(sql, parameters, InfoIndex.class);
		return infoIndex;
	}

	@Override
	public InfoIndex getRecordByField0(String uid, String field0) {
		// TODO Auto-generated method stub
		// 创建sql语句
		String sql = "select * from infoIndex where uid= ? and field0 =?";
		// 填充参数
		Object[] parameters = new Object[] { uid ,field0};
		// 查找单个记录
		InfoIndex infoIndex = DaoHandle.executeQueryForSingle(sql, parameters, InfoIndex.class);
		return infoIndex;
	}

	@Override
	public InfoIndex findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean judgeByUid(String uid) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// 创建sql语句
		if(count()==0)
			return false;
		String sql = "select * from infoIndex where uid= ?";
		// 填充参数
		Object[] parameters = new Object[] { uid };
		// 查找单个记录
		InfoIndex infoIndex = DaoHandle.executeQueryForSingle(sql, parameters, InfoIndex.class);
		System.out.println("BarcloudsDebug:judgeByUid:uid="+infoIndex==null);
		if(infoIndex==null)
			return false;
		else 
			return true;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		String countSql = "select count(*) from infoIndex";
		int count = DaoHandle.executeQueryForCount(countSql,null);
		
		return count;
	}

	@Override
	public PageBean<InfoIndex> findByPage(String uid, int pageCode, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addBatch(List<InfoIndex> t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int count(String uid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageBean<InfoIndex> searchByPage(String uid, String field0,
			int pageCode, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
}
