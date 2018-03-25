package com.barclouds.util;

import java.util.UUID;

//import org.junit.Test;

/**
 * 生成唯一的字符串
 * @author Administrator
 */
public class UUIDUtil {
	
//	@Test
	public void run(){
		// b80e200859fa44c39b1d784f9742a0b0
		System.out.println(UUID.randomUUID().toString().replace("-", ""));
	}
	
	/**
	 * 返回唯一的字符串
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
}
