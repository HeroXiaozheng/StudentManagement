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
 * 公告显示主面板
 * 1、显示公告标题和公布时间
 * 2、主面板包含按钮： “查看内容” “新增公告” “修改公告” “删除公告”
 * @author Joe
 *
 */

public class AdminNotice extends JPanel {

	private JPanel noticejp;// 公告面板
	private JPanel buttonjp;// 按钮面板

	private JButton addnotice;// 新增公告按钮
	private JButton updatenotice;// 修改公告按钮
	private JButton deletenotice;// 删除公告按钮
	private JButton checkview;// 查看详细内容按钮

	private JTable noticetable;// 公告表
	private JScrollPane jsp;

	public JTable getNoticeTable() {
		return noticetable;
	}

	private NoticeDAO noticedao = new NoticeDAO();

	public AdminNotice() {

		noticejp = new JPanel();
		buttonjp = new JPanel();

		noticetable = new JTable(this.getModel());// 使用数据模型DefaultTableModel构建JTable
		jsp = new JScrollPane(noticetable);
		noticetable.setRowHeight(40);
		jsp.setBounds(0, 0, 1100, 500);

		checkview = new JButton("查看内容");
		addnotice = new JButton("新增公告");
		updatenotice = new JButton("修改公告");
		deletenotice = new JButton("删除公告");

		// 添加按钮组件
		buttonjp.add(checkview);
		buttonjp.add(addnotice);
		buttonjp.add(updatenotice);
		buttonjp.add(deletenotice);
		buttonjp.setBounds(0, 500, 1100, 100);

		// 查看公告内容点击事件
		checkview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (noticetable.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "请选择一行查看！");// 假如没有选中任何一条公告
				} else {
					new NoticeDetail(AdminNotice.this);
				}

			}
		});

		// 新增公告内容点击事件
		addnotice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddNoticeDialog(AdminNotice.this);
			}
		});

		// 修改公告内容点击事件
		updatenotice.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (noticetable.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "请选择一行修改！");
				} else {
					new UpdateNoticeJDialog(AdminNotice.this);
				}
			}
		});

		// 删除公告内容点击事件
		deletenotice.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (noticetable.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "请选择一行删除！");
				} else {
					int choice = JOptionPane.showConfirmDialog(null, "您确定删除该条公告吗？", "提示信息", JOptionPane.YES_NO_OPTION);
					if (choice == 0) {
						Object o = noticetable.getValueAt(noticetable.getSelectedRow(), 0);
						noticedao.deleteNotice(o.toString());
						setTable();// 删除公告后实时更新公告表数据
						JOptionPane.showMessageDialog(null, "公告删除成功!");
					}

				}

			}
		});

		// 添加组件
		this.add(jsp);
		this.add(noticejp);
		this.add(buttonjp);

		// 窗体设置
		this.setLayout(null);// 空布局
		this.setSize(1100, 600);
		this.setVisible(true);

	}

	// 查询返回表格
	public DefaultTableModel getModel() {
		// 返回表格数据
		Vector rowData = noticedao.getNoticeRowData();
		// 返回表格标题
		Vector columnNames = noticedao.getColumnNames();
		// 使用表格数据和表格标题构建表格模型
		DefaultTableModel model = new DefaultTableModel(rowData, columnNames) {
			// 重写DefaulttableModel中一个方法，使表格只能被选中但是不能编辑
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		return model;
	}

	// 刷新表格数据
	public void setTable() {
		noticetable.setModel(getModel());
	}

}
