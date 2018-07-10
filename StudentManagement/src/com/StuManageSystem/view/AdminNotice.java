package com.StuManageSystem.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.StuManageSystem.dao.NoticeDAO;

/**
 * ������ʾ�����
 * 1����ʾ�������͹���ʱ��
 * 2������������ť�� ���鿴���ݡ� ���������桱 ���޸Ĺ��桱 ��ɾ�����桱
 * @author Joe
 *
 */

public class AdminNotice extends JPanel {

	private JPanel noticejp;// �������
	private JPanel buttonjp;// ��ť���

	private JButton addnotice;// �������水ť
	private JButton updatenotice;// �޸Ĺ��水ť
	private JButton deletenotice;// ɾ�����水ť
	private JButton checkview;// �鿴��ϸ���ݰ�ť

	private JTable noticetable;// �����
	private JScrollPane jsp;

	public JTable getNoticeTable() {
		return noticetable;
	}

	private NoticeDAO noticedao = new NoticeDAO();

	public AdminNotice() {

		noticejp = new JPanel();
		buttonjp = new JPanel();

		noticetable = new JTable(this.getModel());// ʹ������ģ��DefaultTableModel����JTable
		jsp = new JScrollPane(noticetable);
		noticetable.setRowHeight(40);
		jsp.setBounds(0, 0, 1100, 500);

		checkview = new JButton("�鿴����");
		addnotice = new JButton("��������");
		updatenotice = new JButton("�޸Ĺ���");
		deletenotice = new JButton("ɾ������");

		// ��Ӱ�ť���
		buttonjp.add(checkview);
		buttonjp.add(addnotice);
		buttonjp.add(updatenotice);
		buttonjp.add(deletenotice);
		buttonjp.setBounds(0, 500, 1100, 100);

		// �鿴�������ݵ���¼�
		checkview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (noticetable.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "��ѡ��һ�в鿴��");// ����û��ѡ���κ�һ������
				} else {
					new NoticeDetail(AdminNotice.this);
				}

			}
		});

		// �����������ݵ���¼�
		addnotice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddNoticeDialog(AdminNotice.this);
			}
		});

		// �޸Ĺ������ݵ���¼�
		updatenotice.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (noticetable.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "��ѡ��һ���޸ģ�");
				} else {
					new UpdateNoticeJDialog(AdminNotice.this);
				}
			}
		});

		// ɾ���������ݵ���¼�
		deletenotice.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (noticetable.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "��ѡ��һ��ɾ����");
				} else {
					int choice = JOptionPane.showConfirmDialog(null, "��ȷ��ɾ������������", "��ʾ��Ϣ", JOptionPane.YES_NO_OPTION);
					if (choice == 0) {
						Object o = noticetable.getValueAt(noticetable.getSelectedRow(), 0);
						noticedao.deleteNotice(o.toString());
						setTable();// ɾ�������ʵʱ���¹��������
						JOptionPane.showMessageDialog(null, "����ɾ���ɹ�!");
					}

				}

			}
		});

		// ������
		this.add(jsp);
		this.add(noticejp);
		this.add(buttonjp);

		// ��������
		this.setLayout(null);// �ղ���
		this.setSize(1100, 600);
		this.setVisible(true);

	}

	// ��ѯ���ر��
	public DefaultTableModel getModel() {
		// ���ر������
		Vector rowData = noticedao.getNoticeRowData();
		// ���ر�����
		Vector columnNames = noticedao.getColumnNames();
		// ʹ�ñ�����ݺͱ����⹹�����ģ��
		DefaultTableModel model = new DefaultTableModel(rowData, columnNames) {
			// ��дDefaulttableModel��һ��������ʹ���ֻ�ܱ�ѡ�е��ǲ��ܱ༭
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		return model;
	}

	// ˢ�±������
	public void setTable() {
		noticetable.setModel(getModel());
	}

}
