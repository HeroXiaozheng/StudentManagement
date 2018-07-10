package com.StuManageSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.StuManageSystem.bean.Stu_info;
import com.StuManageSystem.util.DBUtil;

public class AdminStudentDAO {

	public AdminStudentDAO() {

	}

	// 学生新增功能
	public void saveStudent(Stu_info student) {
		String sql = "insert into Stu_info values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, student.getStu_id());
			ps.setString(2, student.getStu_name());
			ps.setString(3, student.getSex());
			ps.setString(4, student.getBirth());
			ps.setString(5, student.getProvince());
			ps.setString(6, student.getProvince());
			ps.setString(7, student.getProvince());
			ps.setString(8, student.getProvince());
			ps.setString(9, student.getProvince());
			ps.setString(10, student.getProvince());
			ps.setString(11, student.getProvince());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 学生查找个人信息功能
	public Vector seekStudent(String stu_id) {
		String sql = "select * from Stu_Info where stu_id =" + "'" + stu_id + "'";
		Vector v = new Vector();
		try {
			Connection con = DBUtil.getCon();
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			if (rs.next()) {
				/*
				 * String stu_id, String stu_name, S tring sex, String birth, String province,
				 * String city, String address, String college, String major, String grade,
				 * String stu_class
				 */

				v.add(rs.getString("stu_id"));
				v.add(rs.getString("stu_name"));
				v.add(rs.getString("sex"));
				v.add(rs.getString("birth"));
				v.add(rs.getString("province"));
				v.add(rs.getString("city"));
				v.add(rs.getString("address"));
				v.add(rs.getString("college"));
				v.add(rs.getString("major"));
				v.add(rs.getString("grade"));
				v.add(rs.getString("stu_class"));

			}

			rs.close();
			sta.close();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return v;
	}

	public void updateStudent(Stu_info stu) {

	}

	// 删除学生数据
	public void deleteStudent(String stu_id) {
		String sql = "delete Stu_Info where stu_id =?";

		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, stu_id);
			ps.executeQuery();
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
