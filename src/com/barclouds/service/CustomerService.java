package com.barclouds.service;

import java.util.List;

import com.barclouds.dao.iface.CustomerDao;
import com.barclouds.dao.impl.CustomerDaoImpl;
import com.barclouds.util.UUIDUtil;
import com.barclouds.entity.Customer;
import com.barclouds.entity.PageBean;

/**
 * 客户的业务层数据
 * @author Administrator
 */
public class CustomerService {
	
	/**
	 * 保存客户的信息
	 * @param c
	 * @return
	 */
	public boolean save(Customer c){
		// 编写业务  添加一个唯一的字符串的值
		String id = UUIDUtil.getUUID();
		// 设置id
		c.setId(id);
		// 调用持久代码
		CustomerDao dao = new CustomerDaoImpl();
		return dao.save(c);
	}

	/**
	 * 查询所有客户
	 * @return
	 */
	public List<Customer> findAll() {
		CustomerDao dao = new CustomerDaoImpl();
		return dao.findAll();
	}

	public boolean delete(String id) {
		CustomerDao dao = new CustomerDaoImpl();
		return dao.delete(id);
	}

	/**
	 * 通过id查询该条记录
	 * @param id
	 * @return
	 */
	public Customer findById(String id) {
		CustomerDao dao = new CustomerDaoImpl();
		return dao.findById(id);
	}

	public boolean update(Customer c) {
		CustomerDao dao = new CustomerDaoImpl();
		return dao.update(c);
	}

	/**
	 * 根据查询的条件进行查询数据
	 * @param username
	 * @param type
	 * @return
	 */
	public List<Customer> findByWhere(String username, String type) {
		CustomerDao dao = new CustomerDaoImpl();
		return dao.findByWhere(username,type);
	}

	/**
	 * 分页查询
	 * @param pageCode
	 * @param pageSize
	 * @return
	 */
	public PageBean<Customer> findByPage(int pageCode, int pageSize) {
		CustomerDao dao = new CustomerDaoImpl();
		return dao.findByPage(pageCode,pageSize);
	}

}







