package com.StuManageSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.StuManageSystem.bean.Stu_info;
import com.StuManageSystem.util.DBUtil;

public class Stu_infoDAO {

	/**
	 * 管理员操作
	 * 
	 * @param stuinfo
	 */

	// 保存新增学生信息
	public void saveStu_info(Stu_info stuinfo) {
		// 学生个人信息
		String sql = "insert into stu_info(stu_id,stu_name,sex,birth,province,city,address,college,major,grade,stu_class)values (?,?,?,?,?,?,?,?,?,?,?)";
		// 添加学生账号密码
		String sql2 = "insert into log_stu values(?,'0000')";
		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, stuinfo.getStu_id());
			ps.setString(2, stuinfo.getStu_name());
			ps.setString(3, stuinfo.getSex());
			ps.setString(4, stuinfo.getBirth());
			ps.setString(5, stuinfo.getProvince());
			ps.setString(6, stuinfo.getCity());
			ps.setString(7, stuinfo.getAddress());
			ps.setString(8, stuinfo.getCollege());
			ps.setString(9, stuinfo.getMajor());
			ps.setString(10, stuinfo.getGrade());
			ps.setString(11, stuinfo.getStu_class());
			ps.executeUpdate();

			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setString(1, stuinfo.getStu_id());
			ps2.executeUpdate();

			ps2.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 修改学生信息
	public void updateStu(Stu_info stuinfo) {
		// stu_id,stu_name,sex,birth,province,city,address,college,major,grade,stu_class

		String sql = "update stu_info set stu_name=?,sex=?,birth=?,province=?," + "city=?,address=?,college=?,"
				+ "major=?,stu_class=?,grade=? where stu_id=?";

		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, stuinfo.getStu_name());
			ps.setString(2, stuinfo.getSex());
			ps.setString(3, stuinfo.getBirth());
			ps.setString(4, stuinfo.getProvince());
			ps.setString(5, stuinfo.getCity());
			ps.setString(6, stuinfo.getAddress());
			ps.setString(7, stuinfo.getCollege());
			ps.setString(8, stuinfo.getMajor());
			ps.setString(9, stuinfo.getStu_class());
			ps.setString(10, stuinfo.getGrade());
			ps.setString(11, stuinfo.getStu_id());
			ps.executeUpdate();

			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 删除学生信息
	public void deleteStu(String stuid) {
		String sql = "delete from stu_info where stu_id=?";
		String sql2 = "delete from log_stu where usercode=?";

		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, stuid);
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setString(1, stuid);

			ps.executeUpdate();
			ps2.executeUpdate();

			System.out.println("after:" + stuid);

			ps.close();
			ps2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 根据学生id 得到学生所有信息
	public Vector seekStu(String stuid) {
		String sql = "select * from stu_info where stu_id=?";
		Vector data = new Vector();
		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, stuid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				data.add(rs.getString("stu_id"));
				data.add(rs.getString("stu_name"));
				data.add(rs.getString("sex"));
				data.add(rs.getString("birth"));
				data.add(rs.getString("province"));
				data.add(rs.getString("city"));
				data.add(rs.getString("address"));
				data.add(rs.getString("college"));
				data.add(rs.getString("major"));
				data.add(rs.getString("grade"));
				data.add(rs.getString("stu_class"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	// select stu_id,stu_name from stu_info where major='teacourse.getStu_major'
	public Vector Find_ID_Name(String major) {
		String sql = "select stu_id,stu_name from stu_info where major=?";
		Vector data = new Vector();
		Vector v = new Vector();
		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, major);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				v.add(rs.getString("stu_id"));
				v.add(rs.getString("stu_name"));
				data.add(v);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 学生界面操作
	 * 
	 * @param stu_id
	 * @return
	 */
	public String[] getStuInfoData(String stu_id) {
		String[] s = { "", "", "", "", "", "", "", "", "", "", "" };
		String sql = "select * from stu_info where stu_id ='" + stu_id + "'";
		try {
			Connection con = DBUtil.getCon();
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				s[0] = rs.getString("stu_id");
				s[1] = rs.getString("stu_name");
				s[2] = rs.getString("sex");
				s[3] = rs.getString("birth");
				s[4] = rs.getString("province");
				s[5] = rs.getString("city");
				s[6] = rs.getString("address");
				s[7] = rs.getString("college");
				s[8] = rs.getString("major");
				s[9] = rs.getString("grade");
				s[10] = rs.getString("stu_class");
			}
			rs.close();
			sta.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	// 由学号获取名字
	public String getstuInfoName(String usercode) {
		String str = new String();
		String sql = "select stu_name from stu_info where stu_id ='" + usercode + "'";
		try {
			Connection con = DBUtil.getCon();
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				str = rs.getString("stu_name");
			}
			rs.close();
			sta.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

}
