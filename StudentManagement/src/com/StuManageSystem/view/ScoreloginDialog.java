package com.StuManageSystem.view;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.StuManageSystem.dao.Stu_scoreDAO;

public class ScoreloginDialog extends JDialog {

	private JTable table;
	private JComboBox box_courseid;
	private JScrollPane jsp;
	private Stu_scoreDAO scoredao;
	private String stuid;

	public ScoreloginDialog(AdminMainFrame amf, String stuid) {
		super(amf, true);

		this.stuid = stuid;
		// System.out.println("stuid:"+stuid);
		String[] columns = { "ѧ��", "����", "�γ̱��", "�γ�����", "����", "ͨ��״̬" };
		scoredao = new Stu_scoreDAO();

		// �����Ƿ���Ա༭
		DefaultTableModel t = new DefaultTableModel(columns, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if (column == 4) {
					return true;
				} else {
					return false;
				}
			}
		};

		Vector data = new Vector();
		data = scoredao.FindScoreIsNull(stuid);
		// System.out.println(data);
		for (int i = 0; i < data.size(); i++) {
			t.addRow((Vector) data.get(i));
			// if (Integer.parseInt(t.getValueAt(i, 4).toString()) > 60) {
			// t.setValueAt("ͨ��", i, 5);
			// } else {
			// t.setValueAt("��ͨ��", i, 5);
			// }

		}
		table = new JTable(t);
		jsp = new JScrollPane(table);

		// ����������¼�
		// ������񣬳ɼ�����
		table.addFocusListener(new FocusListener() {
			String newscore;
			String stuid;
			String courseid;
			int selectedRow;
			int selectedCount;

			@Override
			public void focusLost(FocusEvent e) {

				scoredao.changeStuScore(newscore, stuid, courseid);

				if (selectedRow != -1 && selectedCount != -1) {
					if (Integer.parseInt(table.getValueAt(selectedRow, 4).toString()) >= 60) {
						table.setValueAt("ͨ��", selectedRow, 5);
					} else {
						table.setValueAt("��ͨ��", selectedRow, 5);
					}

					table.setValueAt(newscore, selectedRow, selectedCount);

				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				selectedRow = table.getSelectedRow(); // ���ѡ��������
				selectedCount = table.getSelectedColumn();

				// System.out.println(selectedRow);
				// System.out.println(selectedCount);
				if (selectedRow != -1 && selectedCount != -1) {
					newscore = (String) table.getValueAt(selectedRow, selectedCount);
					stuid = (String) table.getValueAt(selectedRow, 0);
					courseid = (String) table.getValueAt(selectedRow, 2);

				}

			}
		});

		this.add(jsp);
		this.setTitle("�ɼ�¼��");
		this.setSize(1100, 200);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

}
