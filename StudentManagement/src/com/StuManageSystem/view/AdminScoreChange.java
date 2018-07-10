package com.StuManageSystem.view;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.StuManageSystem.dao.Stu_scoreDAO;

public class AdminScoreChange extends JDialog {

	private JTable coursetable;
	private JScrollPane jsp;
	private String stuid;
	private JButton but_save;

	private Stu_scoreDAO scoredao;

	public AdminScoreChange(String stuid) {

		this.stuid = stuid;

		scoredao = new Stu_scoreDAO();
		String[] columns = { "ѧ��", "����", "�γ̱��", "�γ�����", "����", "ͨ��״̬" };

		Vector columnsname = new Vector();
		columnsname.add("ѧ��");
		columnsname.add("����");
		columnsname.add("�γ̱��");
		columnsname.add("�γ�����");
		columnsname.add("����");
		columnsname.add("ͨ��״̬");

		Vector data = scoredao.seekStuScore(stuid);

		DefaultTableModel t = new DefaultTableModel(columnsname, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub

				if (column == 4) {
					return true;
				} else {
					return false;
				}
			}
		};

		for (int i = 0; i < data.size(); i++) {
			t.addRow((Vector) data.get(i));
			if (Integer.parseInt(t.getValueAt(i, 4).toString()) >= 60) {
				t.setValueAt("ͨ��", i, 5);
			} else {
				t.setValueAt("δͨ��", i, 5);
			}

		}

		coursetable = new JTable();
		coursetable.setModel(t);
		jsp = new JScrollPane(coursetable);
		jsp.setBounds(0, 0, 1100, 400);

		coursetable.addFocusListener(new FocusListener() {
			String newscore;
			String stuid;
			String courseid;
			int selectedRow = coursetable.getSelectedRow();
			int selectedColumn;

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				selectedRow = coursetable.getSelectedRow();
				if (selectedRow != -1 && selectedColumn != -1) {
					scoredao.changeStuScore(newscore, stuid, courseid);// �����ݿ��޸ĳɼ�����
					if (Integer.parseInt(coursetable.getValueAt(selectedRow, 4).toString()) >= 60) {
						coursetable.setValueAt("ͨ��", selectedRow, 5);
					} else {
						coursetable.setValueAt("δͨ��", selectedRow, 5);
					}

					coursetable.setValueAt(newscore, selectedRow, selectedColumn);// ���³ɼ�������
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				selectedRow = coursetable.getSelectedRow(); // ���ѡ��������
				selectedColumn = coursetable.getSelectedColumn();
				if (selectedRow != -1 && selectedColumn != -1) {
					newscore = (String) coursetable.getValueAt(selectedRow, selectedColumn);
					stuid = (String) coursetable.getValueAt(selectedRow, 0);
					courseid = (String) coursetable.getValueAt(selectedRow, 2);
				}

			}
		});

		// but_save=new JButton("����");
		// but_save.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		//
		//
		// }
		// });
		//

		// but_save.setBounds(450, 400, 200, 100);
		//
		// this.add(but_save);
		this.add(jsp);
		this.setLayout(null);
		this.setSize(1100, 600);
		this.setTitle("ѧ���ɼ�¼��");
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.setResizable(false);

	}

}
