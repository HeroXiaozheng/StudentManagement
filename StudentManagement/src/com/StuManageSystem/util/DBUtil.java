package com.StuManageSystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ���ݿ�������
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
			// ע������
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("ע��ʧ��");
			e.printStackTrace();
		}
	}

	public static Connection getCon() {
		if (con == null) {
			try {
				// ��������
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			} catch (SQLException e) {
				System.out.println("����ʧ��");
				e.printStackTrace();
			}
		}
		return con;
	}

	public static void colseCon() {
		if (con != null) {
			try {
				// �ر�����
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
