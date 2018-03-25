/**
 * 
 */
package com.barclouds.dao.impl;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.barclouds.dao.iface.IInfoDao;
import com.barclouds.entity.Info;
import com.barclouds.entity.PageBean;
//import com.barclouds.entity.User;
import com.barclouds.util.DaoHandle;
//import com.barclouds.util.DatabaseConnection;


/**
 * @author Sugood
 */
public class InfoDao implements IInfoDao {

//	public boolean addInfo(Info info){
//		// 创建标志位
//		boolean flag = false;
//		// 创建sql语句
//		String sql = "Insert into info(uid,field0,field1,field2,field3,field4,field5,field6,field7,field8,field9) values(?,?,?,?,?,?,?,?,?,?,?)";
//		// 填充参数(主键不需要填写，自增)
//				Object[] parameters = new Object[] { info.getUid(),info.getField0(),
//						info.getField1(), info.getField2(), info.getField3(),info.getField4(),
//						info.getField5(),info.getField6(),info.getField7(),info.getField8(),info.getField9()};
//		flag = DaoHandle.executeDML(sql, parameters) > 0 ? true : false;
//		return flag;
//	}
//
//	public boolean updateInfo(Info info){
//		// 创建标志位
//		boolean flag = false;
//		// 创建sql语句
//		String sql = "update info set field1=?,field2=?,field3=?,field4=?,field5=?,field6=?,field7=?,field8=?,field9=? where uid=?,field0=? ";
//		// 注入参数
//		Object[] parameters = new Object[] { info.getField1(),info.getField2(),info.getField3(),
//				info.getField4(), info.getField5(), info.getField6(),info.getField7(),
//				info.getField8(),info.getField9(),info.getUid(),info.getField0()};
//		flag = DaoHandle.executeDML(sql, parameters) > 0 ? true : false;
//		return flag;
//	}
//
//	public boolean deleteInfo(String uid,String field0) {
//		// 创建标志位
//		boolean flag = false;
//		// 创建sql语句
//		String sql = "delete from info where uid=? and field0 =?";
//		// 填充参数
//		Object[] parameters = new Object[] { uid ,field0};
//		// 执行数据库数据删除操作
//		flag = DaoHandle.executeDML(sql, parameters) > 0 ? true : false;
//		return flag;
//	}
//
//	public List<Info> listAllInfo(){
//		// 创建sql语句
//		String sql = "select * from info order by uid asc";
//		// 查询所有的记录
//		List<Info> list = (List<Info>) DaoHandle.executeQueryForMultiple(sql,
//				null, Info.class);
//		return list;
//	}
//
//	public Info getInfo(String uid,String field0) {
//		// 创建sql语句
//		String sql = "select * from info where uid= ? and field0 =?";
//		// 填充参数
//		Object[] parameters = new Object[] { uid ,field0};
//		// 查找单个记录
//		Info info = DaoHandle.executeQueryForSingle(sql, parameters, Info.class);
//		return info;
//	}

	@Override
	public boolean addRecord(Info t) {
		// TODO Auto-generated method stub
		// 创建标志位
		boolean flag = false;
		// 创建sql语句
		String sql = "Insert into info(uid,field0,field1,field2,field3,field4,field5,field6,field7,field8,field9) values(?,?,?,?,?,?,?,?,?,?,?)";
		// 填充参数(主键不需要填写，自增)
				Object[] parameters = new Object[] { t.getUid(),t.getField0(),
						t.getField1(), t.getField2(), t.getField3(),t.getField4(),
						t.getField5(),t.getField6(),t.getField7(),t.getField8(),t.getField9()};
		flag = DaoHandle.executeDML(sql, parameters) > 0 ? true : false;
		return flag;
	}

	@Override
	public boolean updateRecord(Info t) {
		// TODO Auto-generated method stub
		// 创建标志位
		boolean flag = false;
		// 创建sql语句
		String sql = "update info set field1=?,field2=?,field3=?,field4=?,field5=?,field6=?,field7=?,field8=?,field9=? where uid=?,field0=? ";
		// 注入参数
		Object[] parameters = new Object[] { t.getField1(),t.getField2(),t.getField3(),
				t.getField4(), t.getField5(), t.getField6(),t.getField7(),
				t.getField8(),t.getField9(),t.getUid(),t.getField0()};
		flag = DaoHandle.executeDML(sql, parameters) > 0 ? true : false;
		return flag;
	}

	@Override
	public boolean deleteRecord(String uid) {
		// TODO Auto-generated method stub
		// 创建标志位
		boolean flag = false;
		// 创建sql语句
		String sql = "delete from info where uid=?";
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
		String sql = "delete from info where uid=? and field0 =?";
		// 填充参数
		Object[] parameters = new Object[] { uid ,field0};
		// 执行数据库数据删除操作
		flag = DaoHandle.executeDML(sql, parameters) > 0 ? true : false;
		return flag;
	}
	
	@Override
	public List<Info> listAllRecord() {
		// TODO Auto-generated method stub
		// 创建sql语句
		String sql = "select * from info order by uid asc";
		// 查询所有的记录
		List<Info> list = (List<Info>) DaoHandle.executeQueryForMultiple(sql,
				null, Info.class);
		return list;
	}

	@Override
	public Info getRecord(String uid) {
		// TODO Auto-generated method stub
		// 创建sql语句
		String sql = "select * from info where uid= ?";
		// 填充参数
		Object[] parameters = new Object[] { uid };
		// 查找单个记录
		Info info = DaoHandle.executeQueryForSingle(sql, parameters, Info.class);
		return info;
	}



	@Override
	public Info getRecordByField0(String uid, String field0) {
		// TODO Auto-generated method stub
		// 创建sql语句
		String sql = "select * from info where uid= ? and field0= ?";
		// 填充参数
		Object[] parameters = new Object[] { uid ,field0};
		// 查找单个记录
		Info info = DaoHandle.executeQueryForSingle(sql, parameters, Info.class);
		return info;
	}

	@Override
	public boolean deleteByid(String id) {
		// TODO Auto-generated method stub
		// 创建标志位
		boolean flag = false;
		// 创建sql语句
		String sql = "delete from info where id=?";
		// 填充参数
		Object[] parameters = new Object[] { id};
		// 执行数据库数据删除操作
		flag = DaoHandle.executeDML(sql, parameters) > 0 ? true : false;
		return flag;
	}

	@Override
	public Info findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<Info> findByPage(String uid,int pageCode, int pageSize) {
		// TODO Auto-generated method stub
		/**
		 * 目的：集齐5个龙珠
		 */
		// 创建PageBean对象
		PageBean<Info> page = new PageBean<Info>();
		page.setPageCode(pageCode);
		page.setPageSize(pageSize);
		
		// totalPage  计算 不用处理
		// totalCount 总记录数
		String countSql = "select count(*) from info where uid = ?";
		// 填充参数
		Object[] parametersCount = new Object[] { uid };
		// 获取总记录条数
		int count = DaoHandle.executeQueryForCount(countSql,parametersCount);
		
		// 总记录条数设置成功了
		page.setTotalCount(count);
		
		// beanList  数据
		String selSql = "select * from info where uid = ? limit ?,?";
		
		// 填充参数
		Object[] parameters = new Object[] { uid,(pageCode-1)*pageSize,pageSize };
					
		List<Info> beanList = (List<Info>) DaoHandle.executeQueryForMultiple(selSql,
				parameters, Info.class);
		// 把每页显示的数据设置成功了
		page.setBeanList(beanList);
		// 所有的数据全部都封装成功了！！
		return page;
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
	public boolean addBatch(List<Info> t) {
		// TODO Auto-generated method stub
		// 创建标志位
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println("数据转换开始"+df.format(new Date()));// new Date()为获取当前系统时间
		boolean flag = false;
		List<Object[]> BatchPara = new ArrayList<Object[]>();
		// 创建sql语句
		String sql = "Insert into info(uid,field0,field1,field2,field3,field4,field5,field6,field7,field8,field9) values(?,?,?,?,?,?,?,?,?,?,?)";
		// 填充参数(主键不需要填写，自增)
		for(int i=0; i<t.size() ; i++){
			Object[] parameters = new Object[] { t.get(i).getUid(),t.get(i).getField0(),t.get(i).getField1(),
					t.get(i).getField2(), t.get(i).getField3(),t.get(i).getField4(),t.get(i).getField5(),
					t.get(i).getField6(),t.get(i).getField7(),t.get(i).getField8(),t.get(i).getField9()};
			BatchPara.add(parameters);	
		}
		System.out.println("数据转换结束"+df.format(new Date()));// new Date()为获取当前系统时间
		flag = DaoHandle.executeBatch(sql, BatchPara) > 0 ? true : false;
		return flag;
	}

	@Override
	public int count(String uid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageBean<Info> searchByPage(String uid, String field0, int pageCode,
			int pageSize) {
		// TODO Auto-generated method stub
				/**
				 * 目的：集齐5个龙珠
				 */
				// 创建PageBean对象
				PageBean<Info> page = new PageBean<Info>();
				page.setPageCode(pageCode);
				page.setPageSize(pageSize);
				
				// totalPage  计算 不用处理
				// totalCount 总记录数
				String countSql = "select count(*) from info where uid = ? and field0 = ?";
				// 填充参数
				Object[] parametersCount = new Object[] { uid , field0 };
				// 获取总记录条数
				int count = DaoHandle.executeQueryForCount(countSql,parametersCount);
				
				// 总记录条数设置成功了
				page.setTotalCount(count);
				
				// beanList  数据
				String selSql = "select * from info where uid = ? and field0 = ? limit ?,?";
				
				// 填充参数
				Object[] parameters = new Object[] { uid,field0,(pageCode-1)*pageSize,pageSize };
							
				List<Info> beanList = (List<Info>) DaoHandle.executeQueryForMultiple(selSql,
						parameters, Info.class);
				// 把每页显示的数据设置成功了
				page.setBeanList(beanList);
				// 所有的数据全部都封装成功了！！
				return page;
	}
}
