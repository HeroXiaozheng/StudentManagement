package com.StuManageSystem.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.StuManageSystem.dao.StringDAO;
import com.StuManageSystem.dao.Stu_scoreDAO;

/**
 * �鿴����ѧ���ɼ���ͬʱ�ṩ�鿴δͨ����Ŀ�����������Ͽ�Ŀ��ƽ���֣�ֻ���޸ģ������޸�
 * @author Joe
 *
 */

public class AdminScoreSeek extends JDialog {

	private JTable coursetable; // �ɼ����
	private JScrollPane jsp; // �ɼ�����
	private Stu_scoreDAO scoredao; // �ɼ�����
	private String stuid; // ѧ��ѧ��id

	private JButton but_fail; // δͨ���γ̰�ť
	private JButton but_all; // �鿴���пγ̰�ť
	private JLabel lab_average; // ƽ���֣�ֻ��JLabelƴ����ʾ

	// ���������Ͽ�Ŀ
	private JLabel lab_grade;
	private JTextField text_lowgrade;
	private JTextField text_highgrade;
	private JButton but_highgrade;
	private StringDAO stringdao;

	// ����ģ��
	private DefaultTableModel t;

	public AdminScoreSeek(String stuid) {

		this.stuid = stuid;
		scoredao = new Stu_scoreDAO();
		stringdao = new StringDAO();
		String[] columns = { "ѧ��", "����", "�γ̱��", "�γ�����", "����", "ͨ��״̬" };

		Vector columnsname = new Vector();
		columnsname.add("ѧ��");
		columnsname.add("����");
		columnsname.add("�γ̱��");
		columnsname.add("�γ�����");
		columnsname.add("����");
		columnsname.add("ͨ��״̬");

		Vector data = scoredao.seekStuScore(stuid);

		t = new DefaultTableModel(columnsname, 0);// ʹ������ģ�͹���JTable

		for (int i = 0; i < data.size(); i++) {
			t.addRow((Vector) data.get(i));
			if (Integer.parseInt(t.getValueAt(i, 4).toString()) > 60) {
				t.setValueAt("ͨ��", i, 5);
			} else {
				t.setValueAt("��ͨ��", i, 5);
			}

		}

		// ���ʵ�����������������
		coursetable = new JTable();
		coursetable.setModel(t);
		coursetable.setRowHeight(26);
		coursetable.setEnabled(false);
		jsp = new JScrollPane(coursetable);
		jsp.setBounds(0, 0, 1100, 400);

		// ƽ����,��string�������ݿ�ķ���ֵ��֮��ƴ���ڱ�ǩ�У����һֱ����
		String average = scoredao.getAve(stuid);
		// System.out.println(average);
		lab_average = new JLabel("ƽ����:" + average);
		lab_average.setFont(new Font("΢���ź�", 0, 22));// ��������
		lab_average.setBounds(70, 450, 100, 50);

		// δͨ������ʵ����,�ӵ�����·�
		but_fail = new JButton("�鿴δͨ���γ�");
		but_fail.setBounds(210, 450, 150, 50);
		// �鿴���гɼ���ť
		but_all = new JButton("�鿴���гɼ�");
		but_all.setBounds(210, 450, 150, 50);
		but_all.setVisible(false);

		// ���������Ͽ�Ŀ
		lab_grade = new JLabel("��������ɸѡ��");
		lab_grade.setBounds(480, 450, 100, 50);

		text_lowgrade = new JTextField(10);
		JLabel div = new JLabel("~");

		div.setBounds(638, 450, 10, 50);
		text_lowgrade.setBounds(580, 450, 50, 50);
		text_highgrade = new JTextField(10);
		text_highgrade.setBounds(660, 450, 50, 50);
		but_highgrade = new JButton("����");
		but_highgrade.setBounds(750, 450, 100, 50);

		// ���δ����ť�������ˢ��δ����Ŀγ�����
		but_fail.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				t.setRowCount(0);
				Vector data = scoredao.FindScoreFail(stuid);
				for (int i = 0; i < data.size(); i++) {
					t.addRow((Vector) data.get(i));
					if (Integer.parseInt(t.getValueAt(i, 4).toString()) > 60) {
						t.setValueAt("ͨ��", i, 5);
					} else {
						t.setValueAt("δͨ��", i, 5);
					}
				}
				but_all.setVisible(true);
				but_fail.setVisible(false);
			}
		});

		// �鿴���гɼ������¼�
		but_all.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				t.setRowCount(0);
				Vector data = scoredao.seekStuScore(stuid);
				for (int i = 0; i < data.size(); i++) {
					t.addRow((Vector) data.get(i));
					if (Integer.parseInt(t.getValueAt(i, 4).toString()) > 60) {
						t.setValueAt("ͨ��", i, 5);
					} else {
						t.setValueAt("δͨ��", i, 5);
					}
				}
				but_all.setVisible(false);
				but_fail.setVisible(true);
			}
		});

		// ������Ұ�ť���ȵ���������ֶΣ������Ƿ��ϳɼ��ģ��ſ�ʼ���в��ң����Ҹ��±��
		but_highgrade.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				t.setRowCount(0);

				int highgrade = 100;
				int lowgrade = 0;
				Vector betweendata = new Vector();
				// �����֤,���������ж�
				if (stringdao.isInteger(text_lowgrade.getText()) && stringdao.isInteger(text_highgrade.getText())
						&& !text_lowgrade.getText().equals("") && !text_highgrade.getText().equals("")) {
					// �ж��Ƿ���0~100������
					lowgrade = Integer.parseInt(text_lowgrade.getText());
					highgrade = Integer.parseInt(text_highgrade.getText());

					// �����ж������Ƿ����Ҫ��
					if ((lowgrade >= 0 && lowgrade <= 100)
							&& (highgrade >= 0 && highgrade <= 100 && highgrade >= lowgrade)) {
						betweendata = scoredao.FindMinAndMax(lowgrade, highgrade, stuid);
					} else {
						JOptionPane.showMessageDialog(null, "�ɼ������ʽ�������������Ƿ�������ȷ");
					}

				} else {
					JOptionPane.showMessageDialog(null, "�ɼ������ʽ���󣬱���������");
				}

				// ���ñ������
				for (int i = 0; i < betweendata.size(); i++) {
					t.addRow((Vector) betweendata.get(i));
					if (Integer.parseInt(t.getValueAt(i, 4).toString()) > 60) {
						t.setValueAt("ͨ��", i, 5);
					} else {
						t.setValueAt("δͨ��", i, 5);
					}
				}

			}
		});

		// �ɼ�ɸѡ���������¼�
		text_highgrade.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent ke) {
				// ���»س������ҳɼ�
				if (ke.getKeyCode() == 10) {
					but_highgrade.doClick();
				}
			}

			public void keyPressed(KeyEvent arg0) {
			}
		});

		this.add(lab_grade);
		this.add(text_lowgrade);
		this.add(div);
		this.add(text_highgrade);
		this.add(but_highgrade);
		this.add(lab_average);
		this.add(but_fail);
		this.add(but_all);
		this.add(jsp);
		this.setLayout(null);
		this.setSize(1100, 600);
		this.setTitle("����Ա�γ̹���");
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.setResizable(false);

	}

}
