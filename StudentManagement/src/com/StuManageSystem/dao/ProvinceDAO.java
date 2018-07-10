package com.StuManageSystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.StuManageSystem.util.DBUtil;

public class ProvinceDAO {
	public Vector getProvince() {
		String sql = "select province from hat_province";
		Vector data = new Vector();
		try {
			Connection con = DBUtil.getCon();
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				data.add(rs.getString("province"));
			}
			rs.close();
			sta.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
}
