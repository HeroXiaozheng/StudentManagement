package com.StuManageSystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接类
 * 
 * @author Administrator
 *
 */
public final class DBUtil {

	private static Connection con = null;

	private DBUtil() {

	}

	static {
		try {
			// 注册驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("注册失败");
			e.printStackTrace();
		}
	}

	public static Connection getCon() {
		if (con == null) {
			try {
				// 建立连接
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			} catch (SQLException e) {
				System.out.println("连接失败");
				e.printStackTrace();
			}
		}
		return con;
	}

	public static void colseCon() {
		if (con != null) {
			try {
				// 关闭连接
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
