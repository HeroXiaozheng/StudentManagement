package com.StuManageSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.StuManageSystem.bean.Tea_info;
import com.StuManageSystem.util.DBUtil;

public class Tea_infoDAO {

	// ������ʦ��Ϣ
	public void saveTea_info(Tea_info teainfo) {
		// ����tea_info���sql���
		String sql = "insert into tea_info(teacher_id,teacher_name,sex,birth,province,city,address,college,major)values (?,?,?,?,?,?,?,?,?)";
		// ����log_tea���sql���
		String sql2 = "insert into log_tea values(?,?)";
		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, teainfo.getTeacher_id());
			ps.setString(2, teainfo.getTeacher_name());
			ps.setString(3, teainfo.getSex());
			ps.setString(4, teainfo.getBirth());
			ps.setString(5, teainfo.getProvince());
			ps.setString(6, teainfo.getCity());
			ps.setString(7, teainfo.getAddress());
			ps.setString(8, teainfo.getCollege());
			ps.setString(9, teainfo.getMajor());
			ps.executeUpdate();

			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setString(1, teainfo.getTeacher_id());
			ps2.setString(2, "0000");// Ĭ�ϳ�ʼ����0000
			ps2.executeUpdate();

			ps.close();
			ps2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ���ҽ�ʦ
	public Vector seekTea(String teaid) {
		String sql = "select * from tea_info where teacher_id=?";
		Vector data = new Vector();
		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, teaid);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				data.add(rs.getString("teacher_id"));
				data.add(rs.getString("teacher_name"));
				data.add(rs.getString("sex"));
				data.add(rs.getString("birth"));
				data.add(rs.getString("province"));
				data.add(rs.getString("city"));
				data.add(rs.getString("address"));
				data.add(rs.getString("college"));
				data.add(rs.getString("major"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

	// ɾ����ʦ
	public void deleteTea(String tea_id) {
		String sql = "delete from tea_info where teacher_id=?";
		String sql2 = "delete from log_tea where usercode=?";
		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, tea_id);
			ps.executeQuery();

			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setString(1, tea_id);
			ps2.executeUpdate();

			ps.close();
			ps2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ���½�ʦ������Ϣ
	public void updateTeacher(Tea_info tea, String teaid) {
		/*
		 * 
		 * String teacher_id, String teacher_name, String sex, String birth, String
		 * province, String city, String college, String major, String address
		 * 
		 * 
		 */
		String sql = "update tea_info set teacher_name=?,sex=?,birth=?,province=?,city=?,college=?,major=?,address=? where teacher_id=?";

		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, tea.getTeacher_name());
			ps.setString(2, tea.getSex());
			ps.setString(3, tea.getBirth());
			ps.setString(4, tea.getProvince());
			ps.setString(5, tea.getCity());
			ps.setString(6, tea.getCollege());
			ps.setString(7, tea.getMajor());
			ps.setString(8, tea.getAddress());
			ps.setString(9, teaid);
			ps.executeUpdate();

			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ��ѯ��ʦID������id�õ���ʦ��ѧ�ţ�����ƴ��
	public Vector getTeaId() {
		String sql = "select teacher_id,teacher_name from tea_info";
		Vector v = new Vector();
		try {
			Connection con = DBUtil.getCon();
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				v.add(rs.getString("teacher_id") + rs.getString("teacher_name"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return v;
	}

	/**
	 * ��ʦ����
	 */
	// �ɹ��Ż�ȡ����
	public String getTeaInfoName(String usercode) {
		String str = new String();
		String sql = "select teacher_name from tea_info where teacher_id ='" + usercode + "'";
		try {
			Connection con = DBUtil.getCon();
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				str = rs.getString("teacher_name");
			}
			rs.close();
			sta.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

}
