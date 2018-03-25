package com.barclouds.dao.iface;

import java.util.List;

import com.barclouds.entity.Customer;
import com.barclouds.entity.PageBean;

public interface CustomerDao {
	
	public boolean save(Customer c);

	public List<Customer> findAll();

	public boolean delete(String id);

	public Customer findById(String id);

	public boolean update(Customer c);

	public List<Customer> findByWhere(String username, String type);

	public PageBean<Customer> findByPage(int pageCode, int pageSize);

}
