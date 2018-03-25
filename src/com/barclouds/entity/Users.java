package com.barclouds.entity;

import java.util.Date;

/**
 * 实体类
 * 
 * @author Sugood
 * 
 */
public class Users {
	// 用户Id
	private int userId;
	// 用户名
	private String userName;
	// 用户年龄
	private int age;
	// 用户生日
	private Date birthday;
	// 用户是否是会员 true:是 false:不是
	private boolean isVip;

	public Users() {
	}

	// 有参构造
	public Users(String userName, int age, Date birthday, boolean isVip) {
		this.userName = userName;
		this.age = age;
		this.birthday = birthday;
		this.isVip = isVip;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public boolean getIsVip() {
		return isVip;
	}

	public void setIsVip(boolean isVip) {
		this.isVip = isVip;
	}

	@Override
	public String toString() {
		return "用户信息： [年龄是" + this.getAge() + ", 生日是" + this.getBirthday()
				+ ", 用户编号是" + this.getUserId() + ", 用户名是" + userName
				+ isVip(this.getIsVip()) + "]";
	}

	public String isVip(boolean isVip) {
		return ", " + (isVip == true ? "是" : "不是") + "会员";
	}

}
