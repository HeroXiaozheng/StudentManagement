package com.StuManageSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.StuManageSystem.bean.Notice;
import com.StuManageSystem.util.DBUtil;

public class NoticeDAO {

	/*
	 * 新增公告
	 */
	public void saveNotice(Notice notice) {
		String sql = "insert into notice(title,notice_date,txt) values(?,?,?)";

		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, notice.getTitle());
			ps.setString(2, notice.getNotice_date());
			ps.setString(3, notice.getTxt());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 修改公告
	 * 
	 */
	public void updateNotice(Notice notice) {
		String sql = "update notice set notice_date=?,txt=? where title=?";
		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, notice.getNotice_date());
			ps.setString(2, notice.getTxt());
			ps.setString(3, notice.getTitle());
			ps.executeQuery();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/*
	 * 删除公告
	 * 
	 */
	public void deleteNotice(String title) {
		String sql = "delete from notice where title=?";
		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.executeQuery();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Vector getNoticeRowData() {
		Vector data = new Vector();
		String sql = "select title,notice_date from notice";
		try {
			Connection con = DBUtil.getCon();
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("title"));
				v.add(rs.getString("notice_date"));
				data.add(v);
			}
			rs.close();
			sta.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;

	}

	public Vector getColumnNames() {
		Vector columnNames = new Vector();
		columnNames.add("标题");
		columnNames.add("公布时间");
		return columnNames;
	}

	public String getDetailNotice(String title) {
		String sql = "select txt from notice where title=?";
		String s = "";
		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = rs.getString("txt");
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;

	}

}
