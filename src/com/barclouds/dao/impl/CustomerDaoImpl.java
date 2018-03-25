package com.barclouds.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import cn.itcast.utils.MyJdbcUtil;


import com.barclouds.dao.iface.CustomerDao;
import com.barclouds.entity.Customer;
import com.barclouds.entity.Data;
import com.barclouds.entity.PageBean;
import com.barclouds.util.DaoHandle;

public class CustomerDaoImpl implements CustomerDao {

	/**
	 * 添加到数据库中
	 */
	public boolean save(Customer c) {
		// 创建标志位
		boolean flag = false;
		String sql = "insert into t_customer values (?,?,?,?,?,?,?,?)";
		Object [] params = {c.getId(),c.getUsername(),c.getGender(),c.getBirthday(),c.getCellphone(),c.getEmail(),c.getLove(),c.getType()};

		flag = DaoHandle.executeDML(sql, params) > 0 ? true : false;
		
		return flag;
	}

	/**
	 * 查询
	 */
	public List<Customer> findAll() {
		
		// 创建sql语句
		String sql = "select * from t_customer order by uid asc";
		// 查询所有的记录
		List<Customer> list = (List<Customer>) DaoHandle.executeQueryForMultiple(sql,
				null, Customer.class);
		return list;
	}

	/**
	 * 删除客户
	 */
	public boolean delete(String id) {
		
		// 创建标志位
		boolean flag = false;
		// 创建sql语句
		String sql = "delete from t_customer where uid=?";
		// 填充参数
		Object[] parameters = new Object[] { id };
		// 执行数据库数据删除操作
		flag = DaoHandle.executeDML(sql, parameters) > 0 ? true : false;
		return flag;
	}

	/**
	 * 查询该条记录
	 */
	public Customer findById(String id) {
		
		// 创建sql语句
		String sql = "select * from t_customer where uid= ?";
		// 填充参数
		Object[] parameters = new Object[] { id };
		// 查找单个记录
		Customer customer = DaoHandle.executeQueryForSingle(sql, parameters, Customer.class);
		return customer;
		
	}

	/**
	 * 修改记录
	 */
	public boolean update(Customer c) {
		
		// 创建标志位
		boolean flag = false;
		String sql = "update t_customer set username = ?,gender=?,birthday=?,cellphone=?,email=?,love=?,type=? where id = ?";
		Object [] params = {c.getUsername(),c.getGender(),c.getBirthday(),c.getCellphone(),c.getEmail(),c.getLove(),c.getType(),c.getId()};
		flag = DaoHandle.executeDML(sql, params) > 0 ? true : false;
		return flag;
	}
	
	/**
	 * 按条件进行查询
	 * select * from t_customer where username = ? and type = ?; 拼接SQL语句
	 * 有问题，by sugood
	 */
	public List<Customer> findByWhere(String username, String type) {
		
		// 拼接SQL语句
		StringBuffer sb = new StringBuffer("select * from t_customer where 1=1 ");
		
		// 拼接参数（把参数的值存入到list集合中）
		List<Object> list = new ArrayList<Object>();
		
		// 拼接客户姓名
		if(username != null && !username.trim().isEmpty()){
			// 可以拼接SQL语句
			sb.append(" and username = ? ");
			list.add(username);
		}
		// 拼接类型
		if(type != null && !type.trim().isEmpty()){
			sb.append(" and type=? ");
			list.add(type);
		}
		
		// 执行
		List<Customer> lists = (List<Customer>) DaoHandle.executeQueryForMultiple(sb.toString(),
				null, Customer.class);
		return lists;
	}

	/**
	 * 分页查询
	 */
	public PageBean<Customer> findByPage(int pageCode, int pageSize) {
		/**
		 * 目的：集齐5个龙珠
		 */
		// 创建PageBean对象
		PageBean<Customer> page = new PageBean<Customer>();
		page.setPageCode(pageCode);
		page.setPageSize(pageSize);
		
		// totalPage  计算 不用处理
		// totalCount 总记录数
		String countSql = "select count(*) from t_customer";

			// 获取总记录条数
			int count = DaoHandle.executeQueryForCount(countSql,null);
			// 总记录条数设置成功了
			page.setTotalCount(count);
			
			// beanList  数据
			String selSql = "select * from t_customer limit ?,?";
			
			// 填充参数
			Object[] parameters = new Object[] { (pageCode-1)*pageSize,pageSize };
						
			List<Customer> beanList = (List<Customer>) DaoHandle.executeQueryForMultiple(selSql,
					parameters, Customer.class);
			// 把每页显示的数据设置成功了
			page.setBeanList(beanList);
			// 所有的数据全部都封装成功了！！
			return page;
	}

}












