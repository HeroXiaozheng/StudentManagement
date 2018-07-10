package com.StuManageSystem.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.StuManageSystem.dao.AdminStudentDAO;
import com.StuManageSystem.dao.Stu_infoDAO;

/**
 * ѧ�����ҽ��棬���ڲ���ѧ����ϸ��Ϣ
 * @author Joe
 *
 */

public class AdminStudentSeek extends JPanel {

	private JLabel lab_seek;
	private JTextField text_seek;
	private JButton but_seek;
	private JPanel jp_seek;

	// ������Ϣ���
	private JPanel jp_info;
	private JButton but_change;
	private JButton but_cancel;
	private JButton but_grade;
	private JPanel jp_but;
	private JScrollPane jsp_info;
	private JTable table;
	private JButton but_gradechange;
	private JButton but_gradelogin;

	private String stu_id;
	private Stu_infoDAO stuinfoDao;

	private AdminMainFrame adminMainFrame;

	public AdminStudentSeek(AdminMainFrame amf) {
		this.adminMainFrame = amf;

		stuinfoDao = new Stu_infoDAO();

		// �������
		table = new JTable(11, 2);
		table.setValueAt("ѧ��:", 0, 0);
		table.setValueAt("����:", 1, 0);
		table.setValueAt("�Ա�:", 2, 0);
		table.setValueAt("��������:", 3, 0);
		table.setValueAt("ʡ:", 4, 0);
		table.setValueAt("��:", 5, 0);
		table.setValueAt("��ַ:", 6, 0);
		table.setValueAt("Ժ:", 7, 0);
		table.setValueAt("רҵ:", 8, 0);
		table.setValueAt("�꼶:", 9, 0);
		table.setValueAt("�༶:", 10, 0);
		table.setEnabled(false);// ���ɱ༭
		
		table.setFont(new Font("΢���ź�", Font.BOLD, 15));
		
		//�����п�
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getTableHeader().setVisible(false);// ���ñ�ͷ����ʾ
		DefaultTableCellRenderer renderer1 = new DefaultTableCellRenderer();
		renderer1.setPreferredSize(new Dimension(0, 0)); // ���ñ�ͷ����ѡ�Ԥѡ�߶�Ϊ0
		table.getTableHeader().setDefaultRenderer(renderer1);
		table.setRowHeight(60);
		// DefaultTableModel tableModel = new DefaultTableModel();

		// ���������
//		jsp_info = new JScrollPane(table);
		jp_info = new JPanel(new BorderLayout());
//		jp_info.setBounds(100, 0, 800, 350);
		jp_info.add(new JScrollPane(table));
		jp_info.setBounds(150, 100, 800, 300);

		jp_seek = new JPanel(new FlowLayout());
		
		text_seek = new JTextField(20);
		
		but_seek = new JButton("����");
		
		jp_seek.add(text_seek);
		jp_seek.add(but_seek);
		jp_seek.setBounds(350, 50, 400, 100);
		
		// ��ť
		but_change = new JButton("�޸�");
		but_change.setFont(new Font("΢���ź�", Font.BOLD, 15));
		but_change.setBounds(200, 450, 100, 40);

		but_cancel = new JButton("ע��");
		but_cancel.setFont(new Font("΢���ź�", Font.BOLD, 15));
		but_cancel.setBounds(350, 450, 100, 40);

		but_grade = new JButton("�鿴�ɼ�");
		but_grade.setFont(new Font("΢���ź�", Font.BOLD, 15));
		but_grade.setBounds(500, 450, 100, 40);

		but_gradechange = new JButton("�޸ĳɼ�");
		but_gradechange.setFont(new Font("΢���ź�", Font.BOLD, 15));
		but_gradechange.setBounds(650, 450, 100, 40);

		but_gradelogin = new JButton("¼��ɼ�");
		but_gradelogin.setFont(new Font("΢���ź�", Font.BOLD, 15));
		but_gradelogin.setBounds(800, 450, 100, 40);

		// ����ѧ�ŵ���¼�
		but_seek.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String stu_id = text_seek.getText();

				AdminStudentDAO stuDao = new AdminStudentDAO();
				Vector data = stuDao.seekStudent(stu_id);

				if (data.isEmpty()) {
					JOptionPane.showMessageDialog(null, "�޴�ѧ��������ѧ���Ƿ�������ȷ");
				} else {

					for (int i = 0; i < 11; i++) {
						table.setValueAt(data.get(i), i, 1);
					}

				}

			}
		});

		// ѧ�����������¼�
		text_seek.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent ke) {
				// ������ڰ��»س������ڵ�����Ұ�ť
				if (ke.getKeyCode() == 10) {
					but_seek.doClick();
				}
			}

			public void keyPressed(KeyEvent arg0) {
			}
		});

		// ѧ��������ȡ�����¼�
		text_seek.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent arg0) {
			}

			public void focusGained(FocusEvent arg0) {
				// ��ȡ����ʱѡ��ȫ������
				text_seek.selectAll();
			}
		});

		// �޸İ�ť����¼�
		but_change.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// �ж�
				if (table.getValueAt(0, 1).toString().equals("")) {
					JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ��");
				}

				else {
					// ��������
					new AdminStudentSeekSaveDialog(adminMainFrame, table.getValueAt(0, 1).toString(), table);

				}

			}
		});

		// ѧ��ע������¼���ɾ��ѧ����Ҫɾ��������ص�������Ϣ���������ֱ����Ϣ
		but_cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getValueAt(0, 1).toString().equals("")) {
					JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ��");
				}

				else {
					int choice = JOptionPane.showConfirmDialog(null, "��ȷ��ע����ѧ��ѧ����", "��ʾ��Ϣ", JOptionPane.YES_NO_OPTION);
					if (choice == 0) {
						stuinfoDao.deleteStu(table.getValueAt(0, 1).toString());
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
						refreshStudentSeek();
					}
				}
			}

		});

		// �鿴�ɼ�����¼�
		but_grade.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getValueAt(0, 1).toString().equals("")) {
					JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ��");
				}

				else {
					// ��������
					new AdminScoreSeek(table.getValueAt(0, 1).toString());

				}

			}
		});

		// �޸ĳɼ�����¼�
		but_gradechange.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (table.getValueAt(0, 1).toString().equals("")) {
					JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ��");
				}

				else {
					// ��������
					new AdminScoreChange(table.getValueAt(0, 1).toString());

				}
			}
		});

		// ¼��ɼ�����¼�����֪��ѧ�ţ��γ��������Զ����γ�������
		but_gradelogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getValueAt(0, 1).toString().equals("")) {
					JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ��");
				}

				else {
					new ScoreloginDialog(amf, table.getValueAt(0, 1).toString());
				}
			}
		});

		this.add(but_gradelogin);
		this.add(but_gradechange);
		this.add(but_change);
		this.add(but_cancel);
		this.add(but_grade);
		this.add(jp_info);
		this.add(jp_seek);
		this.setLayout(null);

	}

	// ����������ʾ��������Ϣ
	public void refreshStudentSeek() {
		text_seek.setText("����ѧ�Ų���");
		for (int i = 0; i < 11; i++) {
			table.setValueAt("", i, 1);
		}
	}

	public DefaultTableModel setTable(String stuid) {
		Vector data = stuinfoDao.seekStu(stuid);
		DefaultTableModel model = new DefaultTableModel();
		model.addRow(data);
		return model;
	}
   
	
	
	
}
