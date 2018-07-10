package com.StuManageSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.StuManageSystem.util.DBUtil;

public class Stu_scoreDAO {

	// 查看学生成绩信息，统一通过学号
	public Vector seekStuScore(String stuid) {
		String sql = "select * from Stu_score where stu_id=? and score is not null";
		Vector data = new Vector();
		Vector v = new Vector();
		;
		try {

			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, stuid);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				v = new Vector();
				v.add(rs.getString("stu_id"));
				v.add(rs.getString("stu_name"));
				v.add(rs.getString("course_id"));
				v.add(rs.getString("course_name"));
				v.add(rs.getString("score"));
				data.add(v);

			}

			rs.close();
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;

	}

	// 修改学生成绩信息，统一通过学号
	public void changeStuScore(String score, String stuid, String courseid) {
		String sql = "update Stu_score set score=? where stu_id=? and course_id=?";

		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, score);
			ps.setString(2, stuid);
			ps.setString(3, courseid);

			ps.executeUpdate();

			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 删除学生成绩信息，统一通过学号
	public void deleteStuScore(String stuid) {
		String sql = "delete stu_score where stu_id=?";
		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, stuid);

			ps.executeUpdate();

			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 返回成绩平均值
	public String getAve(String stuid) {

		String sql = "select avg(score) from stu_score where stu_id=?";
		String average = null;
		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, stuid);
			ResultSet set = ps.executeQuery();
			if (set.next()) {
				average = set.getString("avg(score)");
				// System.out.println("dao:" + average);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return average;

	}

	// 查找未及格的成绩
	public Vector FindScoreFail(String stuid) {
		String sql = "select * from stu_score where stu_id=? and score<60";
		Vector data = new Vector();
		Vector v = new Vector();
		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, stuid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				v = new Vector();
				v.add(rs.getString("stu_id"));

				v.add(rs.getString("stu_name"));
				v.add(rs.getString("course_id"));
				v.add(rs.getString("course_name"));
				v.add(rs.getString("score"));
				data.add(v);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;

	}

	// 查找成绩区间
	public Vector FindMinAndMax(int min, int max, String stuid) {

		String sql = "select * from stu_score where stu_id=? and score>=? and score <=?";
		Vector data = new Vector();
		Vector v = new Vector();
		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, stuid);
			ps.setInt(2, min);
			;
			ps.setInt(3, max);
			;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				v = new Vector();
				v.add(rs.getString("stu_id"));
				v.add(rs.getString("stu_name"));
				v.add(rs.getString("course_id"));
				v.add(rs.getString("course_name"));
				v.add(rs.getString("score"));
				data.add(v);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

	// 录入成绩中查询成绩为空的数据条
	public Vector FindScoreIsNull(String stuid) {
		String sql = "select * from stu_score where stu_id=? and score is null";
		Vector data = new Vector();
		Vector v = new Vector();
		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, stuid);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				v = new Vector();
				v.add(rs.getString("stu_id"));
				v.add(rs.getString("stu_name"));
				v.add(rs.getString("course_id"));
				v.add(rs.getString("course_name"));
				v.add(rs.getString("score"));
				data.add(v);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

	// 添加一门成绩为空的课程
	public void SetCourse(Vector data) {
		String sql = "insert into stu_score values(?,?,?,?,?)";
		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, data.get(0).toString());
			ps.setString(2, data.get(1).toString());
			ps.setString(3, data.get(2).toString());
			ps.setString(4, data.get(3).toString());
			ps.setString(5, data.get(4).toString());
			ps.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 学生操作
	 */

	public Vector getStuScoreData(String stu_id) {
		Vector data = new Vector();
		String sql = "select * from stu_score where stu_id ='" + stu_id + "' and score is not null";
		try {
			Connection con = DBUtil.getCon();
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("stu_id"));
				v.add(rs.getString("stu_name"));
				v.add(rs.getString("course_id"));
				v.add(rs.getString("course_name"));
				v.add(rs.getString("score"));

				if (rs.getString("score").equals("")) {
					v.add("");
				} else {
					Double score = Double.parseDouble(rs.getString("score"));
					if (score < 60) {
						v.add("未通过");
					} else {
						v.add("通过");
					}
				}

				data.add(v);
			}
			rs.close();
			sta.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 老师操作
	 * 
	 * @return
	 */

	public Vector getTeaScoreData(String tea_id) {
		Vector data = new Vector();
		String sql = "select * from stu_score where course_id in (select course_id from tea_course where teacher_id='"
				+ tea_id + "') order by stu_id,course_id";
		try {
			Connection con = DBUtil.getCon();
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("stu_id"));
				v.add(rs.getString("stu_name"));
				v.add(rs.getString("course_id"));
				v.add(rs.getString("course_name"));
				v.add(rs.getString("score"));
				Double score = Double.parseDouble(rs.getString("score"));
				// 判断成绩通过状态
				if (score < 60) {
					v.add("未通过");
				} else {
					v.add("通过");
				}
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
		columnNames.add("学生学号");
		columnNames.add("学生姓名");
		columnNames.add("课程编号");
		columnNames.add("课程名称");
		columnNames.add("分数");
		columnNames.add("通过状态");
		return columnNames;
	}

}
