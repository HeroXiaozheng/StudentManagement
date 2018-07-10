package com.StuManageSystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.StuManageSystem.util.DBUtil;

public class DataStatiacsDAO {

	public Integer[] getPersonNumber() { 
		Integer[] personnum=new Integer[6];
		String teasql="select count(*) teanum from tea_info";
		String stusql="select count(*) stunum from stu_info";
		String sql2015="select count(*) grade2015 from stu_info where grade='2015'";
		String sql2016="select count(*) grade2016 from stu_info where grade='2016'";
		String sql2017="select count(*) grade2017 from stu_info where grade='2017'";
		String sql2018="select count(*) grade2018 from stu_info where grade='2018'";
		try {
			Connection con=DBUtil.getCon();
			Statement sta=con.createStatement();
			ResultSet rs=sta.executeQuery(teasql);
			while(rs.next()) {
				personnum[0]=rs.getInt("teanum");
			}
			
			rs=sta.executeQuery(stusql);
			while(rs.next()) {
				personnum[1]=rs.getInt("stunum");
			}
			
			rs=sta.executeQuery(sql2015);
			while(rs.next()) {
				personnum[2]=rs.getInt("grade2015");
			}
			rs=sta.executeQuery(sql2016);
			while(rs.next()) {
				personnum[3]=rs.getInt("grade2016");
			}
			rs=sta.executeQuery(sql2017);
			while(rs.next()) {
				personnum[4]=rs.getInt("grade2017");
			}
			rs=sta.executeQuery(sql2018);
			while(rs.next()) {
				personnum[5]=rs.getInt("grade2018");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return personnum;
	}
	
	
	
	
	
	
}
