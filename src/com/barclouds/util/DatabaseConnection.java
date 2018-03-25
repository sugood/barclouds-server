package com.barclouds.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * 进行数据库连接的操作
 * 
 * @author Sugood
 * 
 */
public class DatabaseConnection {
	public static String driver;// 驱动
	public static String url;// url
	public static String user;// 用户名
	public static String password;// 密码

	public DatabaseConnection() {

	}

	static {
		// File file = new File("classes/jdbc.properties");
		// Properties pro = new Properties();
		// try {
		// FileInputStream in = new FileInputStream(file);
		// pro.load(in);// 读取属性配置文件
		// driver = pro.getProperty("driver");
		// url = pro.getProperty("url");
		// user = pro.getProperty("user");
		// password = pro.getProperty("password");
		try {
			// 属性文件获取
			Properties pro = new Properties();
			// 通过加载器加载配置文件
			pro.load(DatabaseConnection.class.getClassLoader()
					.getResourceAsStream("jdbc.properties"));
			if (pro != null) {
				driver = pro.getProperty("driver");
				url = pro.getProperty("url");
				user = pro.getProperty("user");
				password = pro.getProperty("password");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			
			//使用tomcat连接池连接
			Context c = new InitialContext();
			DataSource ds = (DataSource)c.lookup("java:comp/env/jdbc/mysqlds");
			conn = ds.getConnection();
			//普通连接
//			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 禁用自动提交模式
	 * 
	 * @return
	 */
	public static void setAutoCommit(Connection con) {
		if (con != null) {
			try {
				con.setAutoCommit(false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 关闭数据库对象
	 * 
	 * @param con
	 * @param stmt
	 * @param rs
	 */
	public static void closeAll(Connection con, Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = null;
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stmt = null;
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = null;
		}
	}

	/**
	 * 关闭数据库对象
	 * 
	 * @param con
	 * @param stmt
	 * @param rs
	 */
	public static void commit(Connection con) {
		if (con != null) {
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 测试数据库连接
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Connection conn = DatabaseConnection.getConnection();
		System.out.println(conn);
	}
}
