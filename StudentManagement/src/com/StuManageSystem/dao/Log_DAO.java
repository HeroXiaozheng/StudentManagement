package com.StuManageSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.StuManageSystem.bean.Log_root;
import com.StuManageSystem.bean.Log_stu;
import com.StuManageSystem.bean.Log_tea;
import com.StuManageSystem.util.DBUtil;

public class Log_DAO {

	/*
	 * 学生登录
	 * 
	 */
	public boolean checkStu(Log_stu logstu) {
		boolean flag = false;
		String sql = "select * from log_stu where usercode=? and pwd=?";
		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, logstu.getUsercode());
			ps.setString(2, logstu.getPwd());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				flag = true;
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public void updateStuPWD(String stu_id, String newpwd) {
		String sql = "update Log_stu set pwd=? where usercode=?";
		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newpwd);
			ps.setString(2, stu_id);
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 老师登录
	 * 
	 */
	public boolean checkTea(Log_tea logtea) {
		boolean flag = false;
		String sql = "select * from log_tea where usercode=? and pwd=?";
		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, logtea.getUsercode());
			ps.setString(2, logtea.getPwd());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				flag = true;
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public void updateTeaPWD(String tea_id, String newpwd) {
		String sql = "update Log_tea set pwd=? where usercode=?";
		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newpwd);
			ps.setString(2, tea_id);
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 管理员登录
	 * 
	 */
	public boolean checkRoot(Log_root logroot) {
		boolean flag = false;
		String sql = "select * from log_root where usercode=? and pwd=?";
		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, logroot.getUsercode());
			ps.setString(2, logroot.getPwd());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
