package com.StuManageSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.StuManageSystem.bean.Stu_course;
import com.StuManageSystem.bean.Tea_course;
import com.StuManageSystem.util.DBUtil;

public class CourseDAO {

	// 得到课程
	public Vector getCourse(String s) {
		Vector getrow = new Vector();
		String sql = "select * from tea_course where course_id like '%" + s + "%' or course_name like '%" + s
				+ "%' order by course_id";
		try {
			Connection con = DBUtil.getCon();
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("course_id"));
				v.add(rs.getString("course_name"));
				v.add(rs.getString("course_date"));
				v.add(rs.getString("teacher_id"));
				v.add(rs.getString("teacher_name"));
				v.add(rs.getString("classroom"));
				v.add(rs.getString("stu_major"));
				getrow.add(v);
			}
			rs.close();
			sta.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getrow;
	}

	// 设置课程表列标题
	public Vector getColumnNames() {
		Vector columnNames = new Vector();
		columnNames.add("课程编号");
		columnNames.add("课程名称");
		columnNames.add("上课时间");
		columnNames.add("教师编号");
		columnNames.add("教师名称");
		columnNames.add("教室");
		columnNames.add("专业");
		return columnNames;
	}

	// 检查该课程是否已经存在
	public boolean courseIsExisted(String course_id) {
		boolean flag=false;
		String sql="select * from tea_course where course_id=?";
		try {
			Connection con=DBUtil.getCon();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, course_id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				flag=true;
			}else {
				flag=false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	// 添加课程
	public void addTeaCourse(Tea_course teacourse) {
		String sql = "insert into tea_course(course_id,course_name,course_date,teacher_id,teacher_name,classroom,stu_major) values(?,?,?,?,?,?,?)";

		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, teacourse.getCourse_id());
			ps.setString(2, teacourse.getCourse_name());
			ps.setString(3, teacourse.getCourse_date());
			ps.setString(4, teacourse.getTeacher_id());
			ps.setString(5, teacourse.getTeacher_name());
			ps.setString(6, teacourse.getClassroom());
			ps.setString(7, teacourse.getStu_major());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 添加学生课程
	public void addStuCourse(Stu_course stucourse) {
		String sql = "insert into Stu_course(course_id,course_name,course_date,teacher_id,teacher_name,classroom,stu_id,stu_major) values(?,?,?,?,?,?,?,?)";

		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, stucourse.getCourse_id());
			ps.setString(2, stucourse.getCourse_name());
			ps.setString(3, stucourse.getCourse_date());
			ps.setString(4, stucourse.getTeacher_id());
			ps.setString(5, stucourse.getTeacher_name());
			ps.setString(6, stucourse.getClassroom());
			ps.setString(7, stucourse.getStu_id());
			ps.setString(8, stucourse.getStu_major());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 删除课程
	public void deleteCourse(String course_id, String stu_major, String course_date) {
		String sql = "delete from tea_course where course_id=? and stu_major=? and course_date=?";
		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, course_id);
			ps.setString(2, stu_major);
			ps.setString(3, course_date);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 更新课程
	public void updateCourse(Tea_course teacourse,String initMajor) {
		String sql = "update tea_course set course_date=?,teacher_id=?,teacher_name=?,classroom=?,stu_major=? where course_id=? and stu_major=?";
		
		try {
			Connection con = DBUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, teacourse.getCourse_date());
			ps.setString(2, teacourse.getTeacher_id());
			ps.setString(3, teacourse.getTeacher_name());
			ps.setString(4, teacourse.getClassroom());
			ps.setString(5, teacourse.getStu_major());
			ps.setString(6, teacourse.getCourse_id());
			ps.setString(7, initMajor);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 
	 * 学生课程DAO
	 */

	public Vector getStuCourseData(String stu_id) {
		Vector data = new Vector();
		String sql = "select * from stu_course where stu_id ='" + stu_id + "'";
		try {
			Connection con = DBUtil.getCon();
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("stu_id"));
				v.add(rs.getString("stu_major"));
				v.add(rs.getString("course_id"));
				v.add(rs.getString("course_name"));
				v.add(rs.getString("course_date"));
				v.add(rs.getString("classroom"));
				v.add(rs.getString("teacher_id"));
				v.add(rs.getString("teacher_name"));
				data.add(v);
			}
			rs.close();
			sta.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public Vector getStuColumnNames() {
		Vector columnNames = new Vector();
		columnNames.add("学生学号");
		columnNames.add("专业");
		columnNames.add("课程编号");
		columnNames.add("课程名称");
		columnNames.add("上课时间");
		columnNames.add("上课教室");
		columnNames.add("老师工号");
		columnNames.add("任课老师");
		return columnNames;
	}

	/*
	 * 老师课程DAO
	 */
	public Vector getTeaCourseData(String tea_id) {
		Vector data = new Vector();
		String sql = "select * from tea_course where teacher_id='" + tea_id + "'";
		try {
			Connection con = DBUtil.getCon();
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("teacher_id"));
				v.add(rs.getString("teacher_name"));
				v.add(rs.getString("course_id"));
				v.add(rs.getString("course_name"));
				v.add(rs.getString("stu_major"));
				v.add(rs.getString("course_date"));
				v.add(rs.getString("classroom"));
				data.add(v);
			}
			rs.close();
			sta.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public Vector getTeaColumnNames() {
		Vector columnNames = new Vector();
		columnNames.add("老师工号");
		columnNames.add("老师名字");
		columnNames.add("课程编号");
		columnNames.add("课程名称");
		columnNames.add("专业");
		columnNames.add("上课时间");
		columnNames.add("教室");
		return columnNames;
	}

}
