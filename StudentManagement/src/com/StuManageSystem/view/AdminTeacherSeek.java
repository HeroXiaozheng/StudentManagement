package com.StuManageSystem.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

import com.StuManageSystem.dao.Tea_infoDAO;

public class AdminTeacherSeek extends JPanel {

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

	private Tea_infoDAO teainfoDao;
	private AdminMainFrame amf;
	private String teaid;

	public AdminTeacherSeek(AdminMainFrame amf) {

		this.amf = amf;

		// �������
		table = new JTable(9, 2);
		table.setValueAt("����:", 0, 0);
		table.setValueAt("", 0, 1);// �����趨��ʼֵ����ֹ����ָ�����
		table.setValueAt("����:", 1, 0);
		table.setValueAt("�Ա�:", 2, 0);
		table.setValueAt("��������:", 3, 0);
		table.setValueAt("ʡ:", 4, 0);
		table.setValueAt("��:", 5, 0);
		table.setValueAt("��ַ:", 6, 0);
		table.setValueAt("Ժ:", 7, 0);
		table.setValueAt("רҵ:", 8, 0);
//		table.setRowHeight(50);

		
		table.setFont(new Font("΢���ź�", Font.BOLD, 15));
		table.setEnabled(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getTableHeader().setVisible(false);// ���ñ�ͷ����ʾ
		DefaultTableCellRenderer renderer1 = new DefaultTableCellRenderer();
		renderer1.setPreferredSize(new Dimension(0, 0)); // ���ñ�ͷ����ѡ�Ԥѡ�߶�Ϊ0
		table.getTableHeader().setDefaultRenderer(renderer1);
		// ���������
		jp_info = new JPanel(new BorderLayout());
		jp_info.setBounds(100, 0, 800, 350);
		jp_info.add(new JScrollPane(table));
		jp_info.setBounds(150, 100, 800, 300);

		jp_seek = new JPanel(new FlowLayout());
		text_seek = new JTextField(20);
		text_seek.setText("���빤�Ų���");
		but_seek = new JButton("����");
		jp_seek.add(text_seek);
		jp_seek.add(but_seek);
		jp_seek.setBounds(350, 50, 400, 100);

		// ��ť
		but_change = new JButton("�޸�");
		but_change.setFont(new Font("΢���ź�", Font.BOLD, 15));
		but_change.setBounds(400, 450, 100, 40);

		but_cancel = new JButton("ע��");
		but_cancel.setFont(new Font("΢���ź�", Font.BOLD, 15));
		but_cancel.setBounds(600, 450, 100, 40);
		// ���ҹ��ŵ���¼�
		but_seek.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String tea_id = text_seek.getText();
				// System.out.println(tea_id);
				teainfoDao = new Tea_infoDAO();

				Vector data = teainfoDao.seekTea(tea_id);

				if (data.isEmpty()) {
					JOptionPane.showMessageDialog(null, "�޴˽�ʦ�����鹤���Ƿ���ȷ");
				} else {

					for (int i = 0; i < data.size(); i++) {
						table.setValueAt(data.get(i), i, 1);
					}

				}
			}
		});

		// �޸Ľ�ʦ����¼�
		but_change.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getValueAt(0, 1).toString().equals("")) {
					JOptionPane.showMessageDialog(null, "���Ų���Ϊ��");
				}else {
					new AdminTeacherJdialog(amf, table.getValueAt(0, 1).toString(), table);
				}
				

			}
		});

		// ע����ʦ
		but_cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getValueAt(0, 1).toString().equals("")) {
					JOptionPane.showMessageDialog(null, "���Ų���Ϊ��");
				} else {
					int choice = JOptionPane.showConfirmDialog(null, "��ȷ��ɾ���ý�ʦ��", "��ʾ��Ϣ", JOptionPane.YES_NO_OPTION);
					if (choice == 0) {
						teainfoDao.deleteTea(text_seek.getText().toString());
						JOptionPane.showMessageDialog(null, "�ɹ�ע���ý�ʦ");
						for (int i = 0; i < 9; i++) {
							table.setValueAt("", i, 1);
						}
						text_seek.setText("���빤�Ų���");
					}
				}
			}
		});

		// �������������¼�
		text_seek.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					// ������ڰ��»س������ڵ�����Ұ�ť
					but_seek.doClick();
				}
			}

			public void keyPressed(KeyEvent e) {
			}
		});

		this.add(but_change);
		this.add(but_cancel);
		this.add(jp_info);
		this.add(jp_seek);
		this.setLayout(null);
	}

}
