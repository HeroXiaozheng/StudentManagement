package com.StuManageSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.StuManageSystem.util.DBUtil;

public class Stu_scoreDAO {

	// �鿴ѧ���ɼ���Ϣ��ͳһͨ��ѧ��
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

	// �޸�ѧ���ɼ���Ϣ��ͳһͨ��ѧ��
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

	// ɾ��ѧ���ɼ���Ϣ��ͳһͨ��ѧ��
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

	// ���سɼ�ƽ��ֵ
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

	// ����δ����ĳɼ�
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

	// ���ҳɼ�����
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

	// ¼��ɼ��в�ѯ�ɼ�Ϊ�յ�������
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

	// ���һ�ųɼ�Ϊ�յĿγ�
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
	 * ѧ������
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
						v.add("δͨ��");
					} else {
						v.add("ͨ��");
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
	 * ��ʦ����
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
				// �жϳɼ�ͨ��״̬
				if (score < 60) {
					v.add("δͨ��");
				} else {
					v.add("ͨ��");
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
		columnNames.add("ѧ��ѧ��");
		columnNames.add("ѧ������");
		columnNames.add("�γ̱��");
		columnNames.add("�γ�����");
		columnNames.add("����");
		columnNames.add("ͨ��״̬");
		return columnNames;
	}

}
