/**
 * 
 */
package com.barclouds.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.barclouds.dao.iface.IDataDao;
import com.barclouds.entity.Data;
import com.barclouds.entity.PageBean;
import com.barclouds.util.DaoHandle;


/**
 * @author Sugoods
 */
public class DataDao implements IDataDao {
	@Override
	public boolean addRecord(Data t) {
		// TODO Auto-generated method stub
		// 创建标志位
			boolean flag = false;
			// 创建sql语句
			String sql = "Insert into data(uid,field0,field1,field2,field3,field4,field5,field6,field7,field8,field9) values(?,?,?,?,?,?,?,?,?,?,?)";
			// 填充参数(主键不需要填写，自增)
					Object[] parameters = new Object[] { t.getUid(),t.getField0(),
							t.getField1(), t.getField2(), t.getField3(),t.getField4(),
							t.getField5(),t.getField6(),t.getField7(),t.getField8(),t.getField9()};
			flag = DaoHandle.executeDML(sql, parameters) > 0 ? true : false;
			return flag;
	}

	@Override
	public boolean addBatch(List<Data> t) {
		// TODO Auto-generated method stub
		// 创建标志位
			boolean flag = false;
			List<Object[]> BatchPara = new ArrayList<Object[]>();
			// 创建sql语句
			String sql = "Insert into data(uid,field0,field1,field2,field3,field4,field5,field6,field7,field8,field9) values(?,?,?,?,?,?,?,?,?,?,?)";
			// 填充参数(主键不需要填写，自增)
			for(int i=0; i<t.size() ; i++){
				Object[] parameters = new Object[] { t.get(i).getUid(),t.get(i).getField0(),t.get(i).getField1(),
						t.get(i).getField2(), t.get(i).getField3(),t.get(i).getField4(),t.get(i).getField5(),
						t.get(i).getField6(),t.get(i).getField7(),t.get(i).getField8(),t.get(i).getField9()};
				BatchPara.add(parameters);	
			}
			flag = DaoHandle.executeBatch(sql, BatchPara) > 0 ? true : false;
			return flag;
	}
	@Override
	public boolean updateRecord(Data t) {
		// TODO Auto-generated method stub
		// 创建标志位
		boolean flag = false;
		// 创建sql语句
		String sql = "update data set field1=?,field2=?,field3=?,field4=?,field5=?,field6=?,field7=?,field8=?,field9=? where uid=? and field0=?";
		// 注入参数
		Object[] parameters = new Object[] { t.getField1(),t.getField2(),t.getField3(),
				t.getField4(), t.getField5(), t.getField6(),t.getField7(),
				t.getField8(),t.getField9(),t.getUid(),t.getField0()};
		flag = DaoHandle.executeDML(sql, parameters) > 0 ? true : false;
		return flag;
	}

	@Override
	public boolean deleteByid(String id) {
		// TODO Auto-generated method stub
		// 创建标志位
		boolean flag = false;
		// 创建sql语句
		String sql = "delete from data where id=?";
		// 填充参数
		Object[] parameters = new Object[] { id};
		// 执行数据库数据删除操作
		flag = DaoHandle.executeDML(sql, parameters) > 0 ? true : false;
		return flag;
	}

	//删除该用户的所有数据
	@Override
	public boolean deleteRecord(String uid) {
		// TODO Auto-generated method stub
		// 创建标志位
		boolean flag = false;
		// 创建sql语句
		String sql = "delete from data where uid=? ";
		// 填充参数
		Object[] parameters = new Object[] { uid };
		// 执行数据库数据删除操作
		flag = DaoHandle.executeDML(sql, parameters) > 0 ? true : false;
		return flag;
	}

	@Override
	public boolean deleteRecordByField0(String uid, String field0) {
		// TODO Auto-generated method stub
		// 创建标志位
		boolean flag = false;
		// 创建sql语句
		String sql = "delete from data where uid=? and field0= ?";
		// 填充参数
		Object[] parameters = new Object[] { uid ,field0};
		// 执行数据库数据删除操作
		flag = DaoHandle.executeDML(sql, parameters) > 0 ? true : false;
		return flag;
	}

	@Override
	public List<Data> listAllRecord() {
		// TODO Auto-generated method stub
		// 创建sql语句
		String sql = "select * from data order by uid asc";
		// 查询所有的记录
		List<Data> list = (List<Data>) DaoHandle.executeQueryForMultiple(sql,
				null, Data.class);
		return list;
	}

	@Override
	public Data getRecord(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Data getRecordByField0(String uid, String field0) {
		// TODO Auto-generated method stub
		// 创建sql语句
		String sql = "select * from data where uid= ? and field0= ?";
		// 填充参数
		Object[] parameters = new Object[] { uid ,field0};
		// 查找单个记录
		Data data = DaoHandle.executeQueryForSingle(sql, parameters, Data.class);
		return data;
	}

	@Override
	public Data findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean judgeByUid(String uid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PageBean<Data> findByPage(String uid, int pageCode, int pageSize) {
		// TODO Auto-generated method stub
		/**
		 * 目的：集齐5个龙珠
		 */
		// 创建PageBean对象
		PageBean<Data> page = new PageBean<Data>();
		page.setPageCode(pageCode);
		page.setPageSize(pageSize);
		
		// totalPage  计算 不用处理
		// totalCount 总记录数
		String countSql = "select count(*) from data where uid = ?";
		// 填充参数
		Object[] parametersCount = new Object[] { uid };
		// 获取总记录条数
		int count = DaoHandle.executeQueryForCount(countSql,parametersCount);
		
		// 总记录条数设置成功了
		page.setTotalCount(count);
		
		// beanList  数据
		String selSql = "select * from data where uid = ? limit ?,?";
		
		// 填充参数
		Object[] parameters = new Object[] { uid,(pageCode-1)*pageSize,pageSize };
					
		List<Data> beanList = (List<Data>) DaoHandle.executeQueryForMultiple(selSql,
				parameters, Data.class);
		// 把每页显示的数据设置成功了
		page.setBeanList(beanList);
		// 所有的数据全部都封装成功了！！
		return page;
	}

	@Override
	public int count(String uid) {
		// TODO Auto-generated method stub
		// totalCount 总记录数
		String countSql = "select count(*) from data where uid = ?";
		// 填充参数
		Object[] parametersCount = new Object[] { uid };
		return DaoHandle.executeQueryForCount(countSql,parametersCount);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageBean<Data> searchByPage(String uid, String field0, int pageCode,
			int pageSize) {
		// TODO Auto-generated method stub
		/**
		 * 目的：集齐5个龙珠
		 */
		// 创建PageBean对象
		PageBean<Data> page = new PageBean<Data>();
		page.setPageCode(pageCode);
		page.setPageSize(pageSize);
		
		// totalPage  计算 不用处理
		// totalCount 总记录数
		String countSql = "select count(*) from data where uid = ? and field0 = ?";
		// 填充参数
		Object[] parametersCount = new Object[] { uid , field0 };
		// 获取总记录条数
		int count = DaoHandle.executeQueryForCount(countSql,parametersCount);
		
		// 总记录条数设置成功了
		page.setTotalCount(count);
		
		// beanList  数据
		String selSql = "select * from data where uid = ? and field0 = ? limit ?,?";
		
		// 填充参数
		Object[] parameters = new Object[] { uid,field0,(pageCode-1)*pageSize,pageSize };
					
		List<Data> beanList = (List<Data>) DaoHandle.executeQueryForMultiple(selSql,
				parameters, Data.class);
		// 把每页显示的数据设置成功了
		page.setBeanList(beanList);
		// 所有的数据全部都封装成功了！！
		return page;
	}
}
