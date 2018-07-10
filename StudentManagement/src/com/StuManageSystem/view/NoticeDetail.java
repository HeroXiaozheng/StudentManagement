package com.StuManageSystem.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;

import com.StuManageSystem.bean.Notice;
import com.StuManageSystem.dao.NoticeDAO;

/**
 * ��ʾ�����������
 * 
 * @author Joe
 *
 */

public class NoticeDetail extends JDialog {

	private JLabel titlelab;
	private JLabel datelab;
	private JLabel txtlab;

	private Notice notice = new Notice();
	private NoticeDAO noticedao = new NoticeDAO();

	private AdminNotice noticeframe;
	private String s;

	public NoticeDetail(AdminNotice nf) {
		
		this.setModal(true);
		this.noticeframe = nf;

		JTable noticetable = noticeframe.getNoticeTable();
		Font font1 = new Font("΢���ź�", Font.BOLD, 30);
		Font font2 = new Font("΢���ź�", Font.PLAIN, 15);
		Font font3 = new Font("΢���ź�", Font.PLAIN, 20);
		// ����
		titlelab = new JLabel(
				"<html>" + noticetable.getValueAt(noticetable.getSelectedRow(), 0).toString() + "</html>");
		titlelab.setBounds(50, 20, 600, 100);
		titlelab.setFont(font1);
		// ����ʱ��
		datelab = new JLabel("����ʱ�䣺" + noticetable.getValueAt(noticetable.getSelectedRow(), 1).toString());
		datelab.setBounds(50, 120, 1100, 50);
		datelab.setFont(font2);
		datelab.setForeground(Color.RED);
		// ���幫������
		txtlab = new JLabel();
		txtlab.setBounds(50, 170, 650, 200);
		txtlab.setText(
				"<html>" + noticedao.getDetailNotice(noticetable.getValueAt(noticetable.getSelectedRow(), 0).toString())
						+ "</html>");
		txtlab.setFont(font3);
		this.add(titlelab);
		this.add(datelab);
		this.add(txtlab);
		this.setLayout(null);// �ղ���
		this.setTitle(noticetable.getValueAt(noticetable.getSelectedRow(), 0).toString());
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}
}
