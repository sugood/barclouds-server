package com.barclouds.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.barclouds.entity.Data;


/**
 * DAO数据操作的辅助类
 * 
 * @author Sugood
 * 
 */
public class DaoHandle {
	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	/**
	 * 执行所有的DML操作
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 */
	public static int executeDML(String sql, Object[] parameters) {
		int count = -1;
		// 获取连接
		con = DatabaseConnection.getConnection();

		if (con != null) {

			try {
				// 获取处理器对象
				pstmt = con.prepareStatement(sql);
				// 注入参数
				for (int i = 0; i < parameters.length; i++) {
					// 根据参数的类型判断调用注入方法
					// 参数类型不安全
					pstmt.setObject(i + 1, parameters[i]);
				}
				// 执行SQL语句
				pstmt.executeBatch();
				count = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DatabaseConnection.closeAll(con, pstmt, null);
			}
		}
		return count;
	}

	/**
	 * 执行批量插入操作
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 */
	public static int executeBatch(String sql, List<Object[]> parameters) {
		int count = -1;
		// 获取连接
		con = DatabaseConnection.getConnection();
		//禁用自动提交模式
		DatabaseConnection.setAutoCommit(con);
		
		if (con != null) {

			try {
				// 获取处理器对象
				pstmt = con.prepareStatement(sql);
				// 注入参数
				for (int j=0; j<parameters.size() ;j++){
					for (int i = 0; i < parameters.get(j).length; i++) {
						// 根据参数的类型判断调用注入方法
						// 参数类型不安全
						pstmt.setObject(i + 1, parameters.get(j)[i]);
					}
					pstmt.addBatch();
				}
				// 执行SQL语句
				pstmt.executeBatch();
				DatabaseConnection.commit(con);
//				count = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				return count;
			} finally {
				DatabaseConnection.closeAll(con, pstmt, null);
				count=2;
			}
		}
		return count;
	}
	/**
	 * 查询获取单个对象
	 * 
	 * @param <T>
	 * @param sql
	 * @param paramters
	 * @param objClass
	 * @return
	 */
	public static <T> T executeQueryForSingle(String sql, Object[] parameters,
			Class<T> objClass) {
		T t = null;
		// 获取连接
		con = DatabaseConnection.getConnection();

		if (con != null) {
			try {
				// 获取处理器
				pstmt = con.prepareStatement(sql);
				// 注入参数
				if (parameters != null) {
					for (int i = 0; i < parameters.length; i++) {
						pstmt.setObject(i + 1, parameters[i]);
					}
				}
				// 执行查询
				rs = pstmt.executeQuery();
				// 获取结果集的元数据
				ResultSetMetaData metaData = rs.getMetaData();
				// 获取所有列名
				String[] colNames = getColNames(metaData);
				// 获取所有列的数据类型
				// int[] colTypes = getColTypes(metaData);
				// 使用反射获取当前类的方法
				Method[] methods = objClass.getDeclaredMethods();
				// 获取结果集的数据
				while (rs.next()) {
					// 获取类的实例
					t = objClass.newInstance();
					// 循环判断每列的数据类型
					for (int i = 0; i < colNames.length; i++) {
						// 获取每列的结果
						Object value = null;
						// 进行所有参数类型的赋值，不能保证类型安全
						value = rs.getObject(i + 1);
						// 遍历每个方法
						for (Method m : methods) {
							if (value != null) {
								// 如果是和该列同名的set方法，则调用该方法
								if (m.getName().equalsIgnoreCase(
										"set" + colNames[i])) {
									// 进行对set方法的调用，向其中置值
									System.out.println("BarcloudDebug"+"name="+m.getName());
//									if(m.getName().equalsIgnoreCase("setId")){
										//如果是varchar类型的主键，不需要转化，int类型的主键需要转化
										if(value instanceof String)
											m.invoke(t, value);
										else
											m.invoke(t, Integer.valueOf(String.valueOf(value)));
//									}else
//										m.invoke(t, value);
								}
							}
						}

					}
				}

			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DatabaseConnection.closeAll(con, pstmt, rs);
			}
		}
		// 返回对象
		return t;
	}

	/**
	 * 通过元数据获取列名数组
	 * 
	 * @param metaData
	 * @return
	 */
	private static String[] getColNames(ResultSetMetaData metaData) {
		String[] colNames = null;

		try {
			// 获取结果集的列数
			int colCount = metaData.getColumnCount();
			// 创建数组
			colNames = new String[metaData.getColumnCount()];
			// 遍历每列
			for (int i = 1; i <= colCount; i++) {
				// 获取列名
				colNames[i - 1] = metaData.getColumnLabel(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return colNames;
	}

	/**
	 * 根据元数据获取所有列的数据类型
	 * 
	 * @param metaData
	 * @return
	 */
//	private static int[] getColTypes(ResultSetMetaData metaData) {
//		int[] colNames = null;
//
//		try {
//			// 获取列数
//			int colCount = metaData.getColumnCount();
//			// 创建数组
//			colNames = new int[colCount];
//			for (int i = 1; i <= colCount; i++) {
//				// colNames[i-1] = metaData.getColumnTypeName(i);
//				colNames[i - 1] = metaData.getColumnType(i);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return colNames;
//	}

	/**
	 * 查询多行对象
	 * 
	 * @param <T>
	 * @param sql
	 * @param paramters
	 * @param objClass
	 * @return
	 */
	public static <T> List<T> executeQueryForMultiple(String sql,
			Object[] parameters, Class<T> objClass) {
		List<T> list = new ArrayList<T>();

		// 获取连接
		con = DatabaseConnection.getConnection();

		if (con != null) {
			try {
				// 获取处理器
				pstmt = con.prepareStatement(sql);
				if (parameters != null) {
					// 注入参数
					for (int i = 0; i < parameters.length; i++) {
						pstmt.setObject(i + 1, parameters[i]);
					}
				}
				// 执行查询
				rs = pstmt.executeQuery();
				// 获取结果集的元数据
				ResultSetMetaData metaData = rs.getMetaData();
				// 获取所有列名
				String[] colNames = getColNames(metaData);
				// 获取所有列的数据类型
				// int[] colTypes = getColTypes(metaData);
				// 使用反射获取当前类的方法
				Method[] methods = objClass.getDeclaredMethods();
				// 获取结果集的数据
				while (rs.next()) {
					T t = null;
					// 获取类的实例
					t = objClass.newInstance();
					// 循环判断每列的数据类型
					for (int i = 0; i < colNames.length; i++) {
						// 获取每列的结果
						Object value = null;
						// 进行所有参数类型的赋值，不能保证类型安全,如果是int类型可能出问题
						value = rs.getObject(i + 1);
						// 遍历每个方法
						for (Method m : methods) {
							if (value != null) {
								// 如果是和该列同名的set方法，则调用该方法
								if (m.getName().equalsIgnoreCase(
										"set" + colNames[i])) {
									// 进行对set方法的调用，向其中置值
									//System.out.println("BarcloudDebug"+"name="+m.getName());
//									if(m.getName().equalsIgnoreCase("setId")){
										//如果是varchar类型的主键，不需要转化，int类型的主键需要转化
										if(value instanceof String)
											m.invoke(t, value);
										else
											m.invoke(t, Integer.valueOf(String.valueOf(value)));
//									}else
//										m.invoke(t, value);
								}
							}
						}

					}
					// 向集合中添加数据
					list.add(t);
				}

			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} finally {
				DatabaseConnection.closeAll(con, pstmt, rs);
			}
		}
		// 返回集合
		return list;
	}

	/**
	 * 返回数据表中数据的条数
	 * 
	 * @param sql
	 * @param paramters
	 * @return
	 */
	public static int executeQueryForCount(String sql, Object[] parameters) {
		int count = 0;
		// 获取连接
		con = DatabaseConnection.getConnection();
		try {
			// 获取处理器
			pstmt = con.prepareStatement(sql);
			if (parameters != null) {
				// 注入参数
				for (int i = 0; i < parameters.length; i++) {
					pstmt.setObject(i + 1, parameters[i]);
				}
			}
			// 执行查询
			rs = pstmt.executeQuery();
			// 遍历查找的结果集
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.closeAll(con, pstmt, rs);
		}
		return count;
	}
}
