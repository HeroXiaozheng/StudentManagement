package com.StuManageSystem.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.StuManageSystem.bean.Notice;
import com.StuManageSystem.dao.NoticeDAO;

/**
 * ��������
 * 
 * @author Joe
 *
 */
public class AddNoticeDialog extends JDialog {
	private JLabel addtitlelab;// ����
	private JLabel adddatelab;// ����
	private JLabel addtxtlab;// ����
	private JLabel nulltxt;// ���ݺ�Ŀո�

	private JTextField addtitletxt;// �������
	private JTextField adddatetxt;// ��������

	private JTextArea addtxtarea;// ��������
	private JScrollPane txtjsp;

	private AdminNotice adminnotice;

	private JButton savebut;
	private JButton cancelbut;
	private JPanel butjp;// ��ť���

	private JRadioButton malebutton;// ��ѡ������ť
	private JRadioButton femalebutton;// ��ѡŮ����ť
	private ButtonGroup sexbg;

	private JComboBox yearbox;// �������б�
	private JComboBox monthbox;// �������б�
	private JComboBox daybox;// �������б�
	private JComboBox provincebox;// ʡ�������б�
	private JComboBox citybox;// ���������б�

	private JButton savebutton;// ���水ť

	public AddNoticeDialog(AdminNotice adminnotice) {

		this.adminnotice = adminnotice;

		Font font1 = new Font("΢���ź�", Font.BOLD, 20);
		Font font2 = new Font("΢���ź�", Font.PLAIN, 15);

		addtitlelab = new JLabel("���⣺");
		addtitlelab.setFont(font1);
		adddatelab = new JLabel("���ڣ�");
		adddatelab.setFont(font1);
		addtxtlab = new JLabel("���ݣ�");
		addtxtlab.setFont(font1);

		nulltxt = new JLabel("                                         ");
		addtitletxt = new JTextField(18);
		addtitletxt.setText("�������ݱ���");

		adddatetxt = new JTextField(18);
		// �ṩ��ǰ���ڼ�ת��
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String time = format.format(date);
		adddatetxt.setText(time);
		adddatetxt.setEditable(false);// �������ڲ��ɱ༭

		addtxtarea = new JTextArea("����������....", 5, 19);
		addtxtarea.setFont(font2);
		addtxtarea.setLineWrap(true);
		txtjsp = new JScrollPane(addtxtarea);

		butjp = new JPanel();
		savebut = new JButton("����");
		cancelbut = new JButton("ȡ��");
		butjp.add(savebut);
		butjp.add(cancelbut);

		// ����
		savebut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				NoticeDAO noticedao = new NoticeDAO();
				Notice notice = new Notice();
				if (addtitletxt.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "��û���������Ŷ");
				} else {
					notice.setTitle(addtitletxt.getText());
					notice.setNotice_date(adddatetxt.getText());
					notice.setTxt(addtxtarea.getText());
					noticedao.saveNotice(notice);
					// ����������ɺ�ʵʱˢ�¹��������
					adminnotice.setTable();
					JOptionPane.showMessageDialog(null, "��������ɹ�");
					dispose();// �رյ�ǰ����
				}

			}
		});
		// ȡ��
		cancelbut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		// ����������ȡ�����¼�
		addtxtarea.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
			}

			public void focusGained(FocusEvent e) {
				// ��ȡ����ʱѡ��ȫ������
				addtxtarea.selectAll();
			}
		});

		// ����������ȡ�����¼�
		addtitletxt.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
			}

			public void focusGained(FocusEvent e) {
				// ��ȡ����ʱѡ��ȫ������
				addtitletxt.selectAll();
			}
		});

		this.add(addtitlelab);
		this.add(addtitletxt);
		this.add(adddatelab);
		this.add(adddatetxt);
		this.add(addtxtlab);
		this.add(nulltxt);
		this.add(txtjsp);
		this.add(butjp, BorderLayout.SOUTH);

		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setTitle("��������");
		this.setSize(300, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

}
