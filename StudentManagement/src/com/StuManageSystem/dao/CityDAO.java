package com.StuManageSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.StuManageSystem.util.DBUtil;

public class CityDAO {
	public Vector getCity(String province) {
		String sql = "select city from hat_city a,hat_province b where a.father=b.provinceid and b.province=?";
		Vector c = new Vector();
		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, province);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c.add(rs.getString("city"));
			}

			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

}
