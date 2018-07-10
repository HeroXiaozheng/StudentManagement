package com.StuManageSystem.view;

import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.StuManageSystem.bean.Log_tea;
import com.StuManageSystem.dao.Log_DAO;

/**
 * �޸�����Ի���
 * @author Joe
 *
 */

public class TeaChangePwdFrame extends Dialog {
	private JLabel jl1;
	private JLabel jl2;
	private JLabel jl3;
	private JLabel jl4;
	private JTextField id;
	private JPasswordField initPwd;
	private JPasswordField newpwd;
	private JPasswordField newpwd2;
	private JButton butsure;
	private JButton butcancel;
	private Tea_initialJFrame Tea_initialJFrame;
	private Log_DAO log_teacherdao;

	public TeaChangePwdFrame(Tea_initialJFrame tij, String teacher_id) {
		super(tij, true);// ģ̬����
		this.Tea_initialJFrame = tij;
		// ʵ�����������
		jl1 = new JLabel("����:");
		jl1.setFont(new Font("΢���ź�", Font.BOLD, 16));
		jl2 = new JLabel("ԭ����:");
		jl2.setFont(new Font("΢���ź�", Font.BOLD, 16));
		jl3 = new JLabel("������:");
		jl3.setFont(new Font("΢���ź�", Font.BOLD, 16));
		jl4 = new JLabel("���ٴ�����������:");
		jl4.setFont(new Font("΢���ź�", Font.BOLD, 16));
		id = new JTextField(30);
		id.setText(teacher_id);// ��ȡ��ʦ����
		id.setEditable(false);// �����޸�,Ĭ�ϵ�ǰ���ʵ�ѧ��ѧ��
		initPwd = new JPasswordField(30);
		newpwd = new JPasswordField(30);
		newpwd2 = new JPasswordField(30);
		butsure = new JButton("ȷ��");
		butsure.setFont(new Font("΢���ź�", Font.BOLD, 18));
		butcancel = new JButton("ȡ��");
		butcancel.setFont(new Font("΢���ź�", Font.BOLD, 18));

		// ȷ���޸�����
		butsure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				log_teacherdao = new Log_DAO();
				Log_tea logtea = new Log_tea();
				logtea.setUsercode(id.getText());
				logtea.setPwd(initPwd.getText());
				if (log_teacherdao.checkTea(logtea) == false) {
					// ԭ�����������
					JOptionPane.showMessageDialog(null, "�����������������");
					initPwd.selectAll();
				} else if (newpwd.getText().equals(initPwd.getText())) {
					// ��������ԭ����һ��
					JOptionPane.showMessageDialog(null, "ԭ�����������벻��һ��Ŷ");
					newpwd.selectAll();
				} else if (!(newpwd.getText().equals(newpwd2.getText()))) {
					// �������������벻һ��
					JOptionPane.showMessageDialog(null, "�������������벻һ��");
					newpwd.selectAll();
				} else {
					// �޸����ݿ��и�ѧ�Ŷ�Ӧ������,��ʾ�޸ĳɹ�
					int choice = JOptionPane.showConfirmDialog(null, "ȷ���޸���", "��ʾ��Ϣ", JOptionPane.YES_NO_OPTION);
					if (choice == 0) {
						log_teacherdao.updateTeaPWD(id.getText(), newpwd.getText());
						JOptionPane.showMessageDialog(null, "�����޸ĳɹ�");
						dispose();
					}
				}
			}
		});
		// ȡ���޸�����
		butcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		/*
		 * �ղ���
		 */
		this.add(jl1);
		jl1.setBounds(30, 20, 100, 30);
		this.add(id);
		id.setBounds(30, 50, 240, 30);
		this.add(jl2);
		jl2.setBounds(30, 80, 100, 30);
		this.add(initPwd);
		initPwd.setBounds(30, 110, 240, 30);
		this.add(jl3);
		jl3.setBounds(30, 140, 100, 30);
		this.add(newpwd);
		newpwd.setBounds(30, 170, 240, 30);
		this.add(jl4);
		jl4.setBounds(30, 200, 150, 30);
		this.add(newpwd2);
		newpwd2.setBounds(30, 230, 240, 30);
		this.add(butsure);
		butsure.setBounds(50, 280, 80, 50);
		this.add(butcancel);
		butcancel.setBounds(170, 280, 80, 50);

		// �رմ���
		this.addWindowListener(new WindowListener() {
			/* ���ڱ�����ʱ���� */
			public void windowActivated(WindowEvent we) {
			}

			/* ���ڱ���ֹʱ���� */
			public void windowDeactivated(WindowEvent we) {
			}

			/* ���ڱ��ر�ʱ���� */
			public void windowClosed(WindowEvent we) {
			}

			/* �������ڹر�ʱ���� */
			public void windowClosing(WindowEvent we) {
				dispose();
			}

			/* ������С��ʱ���� */
			public void windowIconified(WindowEvent we) {
			}

			/* ���ڻָ�ʱ���� */
			public void windowDeiconified(WindowEvent we) {
			}

			/* ���ڴ�ʱ���� */
			public void windowOpened(WindowEvent we) {
			}
		});

		this.setLayout(null);
		this.setTitle("�޸�����");
		this.setSize(300, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
