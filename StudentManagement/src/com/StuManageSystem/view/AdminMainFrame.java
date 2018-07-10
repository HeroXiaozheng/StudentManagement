package com.StuManageSystem.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.TextAnchor;

import com.StuManageSystem.dao.DataStatiacsDAO;
import com.StuManageSystem.util.DateUtil;

public class AdminMainFrame extends JFrame {

	private JPanel jp_top;
	private JPanel jp_left;
	private JPanel jp_show;

	private AdminStudentSeek adminstuseek;
	private AdminTeacherSeek adminteaseek;
	private AdminStudentAdd adminstuadd;
	private AdminNotice adminnotice;
	private AdminTeacherAdd adminteaadd;
	private CourseManagementFrame admincourse;

	private JLabel jlab_date;
	private JLabel jlab_wel;
	private JButton but_exit;


	private JTree stu;
	private JTree tea;
	private JTree course;
	private JTree noticetree;
	private JTree datatree;

	private CardLayout cardpanel;
	private ChartPanel frame1;
	private ChartPanel frame2;
	private CategoryDataset dataset;
	private DefaultPieDataset data;

	public AdminMainFrame() {
		//---------------------Ϊ����Ա�������ô򿪺�����Լ�����ͳ��-------------
		dataset = getDataSet1();  
        frame1=new ChartPanel(columnchart(),true);
        //----------------------------------------------------------
        data = getDataSet2(); 
        frame2=new ChartPanel (piechart(),true); 
        //-----------------------------------

		// �ṩ��ǰ���ڼ�ת��
		jlab_date = new JLabel(DateUtil.getDate());
		jlab_date.setFont(new Font("Agency FB", Font.BOLD, 18));
		jlab_wel = new JLabel("����Ա����ӭ�㣡");
		but_exit = new JButton("ע��");

		// �ϲ����
		jp_top = new JPanel();
		jp_top.setLayout(null);
		jp_top.setBorder(BorderFactory.createTitledBorder(""));
		jp_top.setBorder(BorderFactory.createLineBorder(Color.black, 1));

		jp_top.setBounds(0, 0, 1300, 35);
		// �Ͻ���������
		jlab_date.setBounds(5, 5, 100, 25);
		jp_top.add(jlab_date);
		jlab_wel.setBounds(1000, 5, 125, 25);
		jp_top.add(jlab_wel);
		but_exit.setBounds(1150, 5, 100, 25);
		jp_top.add(but_exit);

		// ���˵�
		jp_left = new JPanel();
		jp_left.setLayout(null);
		jp_left.setBorder(BorderFactory.createTitledBorder(""));
		jp_left.setBorder(BorderFactory.createLineBorder(Color.black, 1));// ���ñ߿���
		jp_left.setBounds(0, 35, 200, 600);

		// �������ı���
		DefaultTreeCellRenderer cellRender1 = new DefaultTreeCellRenderer();
		cellRender1.setClosedIcon(new ImageIcon("image/ѧ������.png"));//����������ʾ����չ�ķ�Ҷ�ڵ��ͼ�ꡣ
        cellRender1.setLeafIcon(new ImageIcon("image/ѧ��ѧ����Ϣ����.png")); //������ʾҶ�ڵ��ͼ�ꡣ
        cellRender1.setTextSelectionColor(Color.RED);
		// ���ѧ����
		DefaultMutableTreeNode sturoot = new DefaultMutableTreeNode("ѧ������");
		DefaultMutableTreeNode stu1 = new DefaultMutableTreeNode("����ѧ����Ϣ");
		DefaultMutableTreeNode stu2 = new DefaultMutableTreeNode("��ѯѧ����Ϣ");
		// ��ѧ�����������
		sturoot.add(stu1);
		sturoot.add(stu2);
		stu = new JTree(sturoot);
		stu.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		stu.setBounds(10, 20, 180, 100);
		// �۵�����
		stu.collapseRow(0);
		stu.collapseRow(1);

		stu.setOpaque(false);
		stu.setCellRenderer(cellRender1);

		// ��ӽ�ʦ��
		DefaultTreeCellRenderer cellRender2 = new DefaultTreeCellRenderer();
		cellRender2.setClosedIcon(new ImageIcon("image/��ʦ����.png"));//����������ʾ����չ�ķ�Ҷ�ڵ��ͼ�ꡣ
        cellRender2.setLeafIcon(new ImageIcon("image/���ò����ʦ.png")); //������ʾҶ�ڵ��ͼ�ꡣ
        cellRender2.setTextSelectionColor(Color.RED);
		DefaultMutableTreeNode tearoot = new DefaultMutableTreeNode("��ʦ����");
		DefaultMutableTreeNode tea1 = new DefaultMutableTreeNode("�����ʦ��Ϣ");
		DefaultMutableTreeNode tea2 = new DefaultMutableTreeNode("��ѯ��ʦ��Ϣ");
		// ����ʦ���������
		tearoot.add(tea1);
		tearoot.add(tea2);

		tea = new JTree(tearoot);
		tea.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		// �۵�����
		tea.collapseRow(0);
		tea.collapseRow(1);

		tea.setBounds(10, 140, 180, 80);
		tea.setCellRenderer(cellRender2);

		// ��ӿγ���
		DefaultMutableTreeNode courseroot = new DefaultMutableTreeNode("�γ̹���");
		DefaultTreeCellRenderer cellRender3 = new DefaultTreeCellRenderer();
		cellRender3.setLeafIcon(new ImageIcon("image/�γ̹���.png")); //������ʾҶ�ڵ��ͼ�ꡣ
		cellRender3.setTextSelectionColor(Color.RED);
		course = new JTree(courseroot);
		// �۵�����
		course.collapseRow(0);

		course.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		course.setBounds(10, 260, 180, 80);
		course.setCellRenderer(cellRender3);
		// ��ӹ�����
		DefaultTreeCellRenderer cellRender4 = new DefaultTreeCellRenderer();
		cellRender4.setLeafIcon(new ImageIcon("image/�������.png")); //������ʾҶ�ڵ��ͼ�ꡣ
		cellRender4.setTextSelectionColor(Color.RED);//���õ�ǰѡ�нڵ���ı���ɫ
		DefaultMutableTreeNode noticeroot = new DefaultMutableTreeNode("�������");
		noticetree = new JTree(noticeroot);
		// �۵�����
		noticetree.collapseRow(0);
		noticetree.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		noticetree.setBounds(10, 380, 180, 80);
		noticetree.setCellRenderer(cellRender4);

		DefaultTreeCellRenderer cellRender5 = new DefaultTreeCellRenderer();
		//�Ķ�-----���ͼ��
		cellRender5.setClosedIcon(new ImageIcon("image/ͳ�Ʒ���.png"));//����������ʾ����չ�ķ�Ҷ�ڵ��ͼ�ꡣ
		cellRender5.setLeafIcon(new ImageIcon("image/ͳ��.png")); //������ʾҶ�ڵ��ͼ�ꡣ
		cellRender5.setTextSelectionColor(Color.RED);//���õ�ǰѡ�нڵ���ı���ɫ
        //�Ķ�--------------------------------------------------------------------------
		// �������ͳ����
		DefaultMutableTreeNode datastatistics = new DefaultMutableTreeNode("����ͳ��");
		DefaultMutableTreeNode data1 = new DefaultMutableTreeNode("����ͳ��");
		DefaultMutableTreeNode data2 = new DefaultMutableTreeNode("ѧ�����");
		// ������ͳ�����������
		datastatistics.add(data1);
		datastatistics.add(data2);
		datatree = new JTree(datastatistics);
		datatree.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		datatree.setBounds(10, 500, 180, 100);
		// �۵�����
		datatree.collapseRow(0);
		datatree.collapseRow(1);
		
		datatree.setOpaque(false);
		datatree.setCellRenderer(cellRender5);

		jp_left.add(stu);
		jp_left.add(tea);
		jp_left.add(course);
		jp_left.add(noticetree);
		jp_left.add(datatree);

		// ���ʵ����
		adminstuseek = new AdminStudentSeek(AdminMainFrame.this);
		adminstuadd = new AdminStudentAdd();
		adminteaseek = new AdminTeacherSeek(AdminMainFrame.this);
		adminnotice = new AdminNotice();
		adminteaadd = new AdminTeacherAdd();
		admincourse = new CourseManagementFrame();

		// �Ҳ�˵�
		cardpanel = new CardLayout();

		jp_show = new JPanel();
		jp_show.setLayout(cardpanel);// ����Ϊ��Ƭ����

		jp_show.add("��", new JLabel());

		// ���ѧ����ѯ��Ƭ
		jp_show.add("stu1", adminstuadd);
		jp_show.add("stu2", adminstuseek);

		jp_show.add("tea1", adminteaadd);
		jp_show.add("tea2", adminteaseek);

		jp_show.add("course1", admincourse);

		jp_show.add("notice", adminnotice);
		jp_show.add("countnumber1", frame1);//��������ͼ��Ƭ����Ϊcountnumber1
		jp_show.add("countnumber2", frame2);//�����״ͼͼ��Ƭ����Ϊcountnumber2

		jp_show.setBorder(BorderFactory.createTitledBorder(""));
		jp_show.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		jp_show.setBounds(200, 35, 1100, 600);
		cardpanel.show(jp_show, "countnumber1");//һ��ʼ��ʾ�˿�Ƭ
		
		
		// ���ע������¼�
		but_exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "��ȷ��ע����ǰ�˻���", "��ʾ��Ϣ", JOptionPane.YES_NO_OPTION);
				if (choice == 0) {
					// �رյ�ǰ���棬�򿪵�¼����
					dispose();
					new LoginFrame();
				}
			}
		});

	

		stu.addTreeSelectionListener(new TreeSelectionListener() {

			public void valueChanged(TreeSelectionEvent e) {
				tea.clearSelection();
				course.clearSelection();
				noticetree.clearSelection();
				datatree.clearSelection();
				// �۵�������
				tea.collapseRow(0);
				tea.collapseRow(1);
				datatree.collapseRow(0);
 			    datatree.collapseRow(1);
				if (e.getPath().getLastPathComponent().toString().equals("����ѧ����Ϣ")) {
					cardpanel.show(jp_show, "stu1");

				} else if (e.getPath().getLastPathComponent().toString().equals("��ѯѧ����Ϣ")) {

					adminstuseek.refreshStudentSeek();
					cardpanel.show(jp_show, "stu2");
				}

			}
		});

		// ��ʦ����¼�
		tea.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {

				stu.clearSelection();
				course.clearSelection();
				noticetree.clearSelection();
				datatree.clearSelection();
				// �۵�������
				stu.collapseRow(0);
				stu.collapseRow(1);
				datatree.collapseRow(0);
	   			datatree.collapseRow(1);
				if (e.getPath().getLastPathComponent().toString().equals("�����ʦ��Ϣ")) {

					cardpanel.show(jp_show, "tea1");
				} else if (e.getPath().getLastPathComponent().toString().equals("��ѯ��ʦ��Ϣ")) {

					cardpanel.show(jp_show, "tea2");
				}

			}
		});

		// �γ̵���¼�
		course.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				stu.clearSelection();
				tea.clearSelection();
				noticetree.clearSelection();
				datatree.clearSelection();
				// �۵�������
				tea.collapseRow(0);
				tea.collapseRow(1);
				stu.collapseRow(0);
				stu.collapseRow(1);
				datatree.collapseRow(0);
				datatree.collapseRow(1);
				if (e.getPath().getLastPathComponent().toString().equals("�γ̹���")) {

					cardpanel.show(jp_show, "course1");
					admincourse.setJCombox();// ˢ��ѡ����ʦ�������б�
				}
			}
		});
        //�������¼�
		noticetree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				stu.clearSelection();
				tea.clearSelection();
				course.clearSelection();
				datatree.clearSelection();
				// �۵�������
				tea.collapseRow(0);
				tea.collapseRow(1);
				stu.collapseRow(0);
				stu.collapseRow(1);
				datatree.collapseRow(0);
				datatree.collapseRow(1);
				if(e.getPath().getLastPathComponent().toString().equals("�������")) {
					cardpanel.show(jp_show, "notice");
				}
			}
		});
				
				
		// ����ͳ�Ƶ���¼�
		datatree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {

				stu.clearSelection();
				tea.clearSelection();
				course.clearSelection();
				noticetree.clearSelection();
				//�۵�������
			    stu.collapseRow(0);
   			    stu.collapseRow(1);
   			    tea.collapseRow(0);
   			   tea.collapseRow(1);
				if (e.getPath().getLastPathComponent().toString().equals("����ͳ��")) {
					dataset = getDataSet1(); 
					frame1=new ChartPanel(columnchart(),true);
					jp_show.add("countnumber1", frame1);
					cardpanel.show(jp_show, "countnumber1");			
				} else if (e.getPath().getLastPathComponent().toString().equals("ѧ�����")) {
					data = getDataSet2(); 
					frame2=new ChartPanel (piechart(),true); 
					jp_show.add("countnumber2", frame2);
					cardpanel.show(jp_show, "countnumber2");
				}

			}
		});
		// ���ڹر��¼�
		this.addWindowListener(new WindowListener() {
			public void windowOpened(WindowEvent e) {
			}

			public void windowIconified(WindowEvent e) {
			}

			public void windowDeiconified(WindowEvent e) {
			}

			public void windowDeactivated(WindowEvent e) {
			}

			public void windowClosing(WindowEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "��ȷ���˳���ϵͳ��", "��ʾ��Ϣ", JOptionPane.YES_NO_OPTION);
				if (choice == 0) {
					dispose();
				}
			}

			public void windowClosed(WindowEvent e) {
			}

			public void windowActivated(WindowEvent e) {
			}
		});
		this.setIconImage(new ImageIcon("image/����Ա.png").getImage());
		this.add(jp_show);
		this.add(jp_left);
		this.add(jp_top);
		this.setLayout(null);
		this.setTitle("����Ա��");
		this.setSize(1300, 700);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);

	}
	//������״ͼ����
		private static CategoryDataset getDataSet1() {  
	        DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
	        DataStatiacsDAO datastasticsdao=new DataStatiacsDAO();
	    	Integer[] personnum=new Integer[6];
	        personnum=datastasticsdao.getPersonNumber();
	        dataset.addValue(personnum[0], "��ʦ��ְ����","��ʦ" );
	        dataset.addValue(personnum[1], "ѧ���ڶ�����", "ѧ��");  
	        dataset.addValue(personnum[2], "2015ѧ���ڶ�����", "2015��");  
	        dataset.addValue(personnum[3], "2016ѧ���ڶ�����", "2016��");  
	        dataset.addValue(personnum[4], "2017ѧ���ڶ�����", "2017��");  
	        dataset.addValue(personnum[5], "2018ѧ���ڶ�����", "2018��"); 
	        return dataset;  
	    }  
//		public ChartPanel getChartPanel1(){  
//		 return frame1;  
//		}   
		//���ñ�״ͼ����
		private static DefaultPieDataset getDataSet2() {  
	        DefaultPieDataset dataset = new DefaultPieDataset();  
	        DataStatiacsDAO datastasticsdao=new DataStatiacsDAO();
	    	Integer[] personnum=new Integer[6];
	        personnum=datastasticsdao.getPersonNumber();
	        dataset.setValue("2015��",personnum[2]);  
	        dataset.setValue("2016��",personnum[3]);  
	        dataset.setValue("2017��",personnum[4]);  
	        dataset.setValue("2018��",personnum[5]);    
	        return dataset;  
	  }  
//	    public ChartPanel getChartPanel2(){  
//	        return frame2;  
//	          
//	    }  
	    //��״���÷�װ����
		public JFreeChart columnchart() {
			JFreeChart chart1 = ChartFactory.createBarChart3D(  
		             "����ͳ��", // ͼ�����  
		            "������", // Ŀ¼�����ʾ��ǩ  
		            "����", // ��ֵ�����ʾ��ǩ  
		            dataset, // ���ݼ�  
		            PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ  
		            true,           // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)  
		            false,          // �Ƿ����ɹ���  
		            false           // �Ƿ�����URL����  
		         ); 
			CategoryPlot plot=chart1.getCategoryPlot();//��ȡͼ���������
			NumberAxis axis = (NumberAxis)chart1.getCategoryPlot().getRangeAxis();//��������������λ
	       axis.setTickUnit(new NumberTickUnit(1D));//1Ϊһ�������λ
	       
	       CategoryAxis domainAxis=plot.getDomainAxis(); //ˮƽ�ײ��б�  
	       domainAxis.setLabelFont(new Font("����",Font.BOLD,20)); //ˮƽ�ײ�����  
	       domainAxis.setTickLabelFont(new Font("����",Font.BOLD,20));  //��ֱ����
	       ValueAxis rangeAxis=plot.getRangeAxis();//��ȡ��״  
	       rangeAxis.setLabelFont(new Font("����",Font.BOLD,15));  
	       chart1.getLegend().setItemFont(new Font("����", Font.BOLD, 15));  
	       chart1.getTitle().setFont(new Font("����",Font.BOLD,15));//���ñ�������  
	       BarRenderer3D renderer = new BarRenderer3D();
	       renderer.setItemMargin(-0.4);//������״��Ⱥͼ��
	     //������״��ʾ����ֵ
	       renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	       renderer.setItemLabelsVisible(true);
	       //������״������ʾ����ֵ
	       renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.CENTER_LEFT)); 
	       renderer.setItemLabelAnchorOffset(18); 
	       renderer.setItemLabelFont(new Font("Agency FB",Font.PLAIN,25));
	       plot.setRenderer(renderer);
	       return chart1;
		}
		public JFreeChart piechart() {
			//----------------ѧ�����ͳ��ͼ------------ 
	        JFreeChart chart2 = ChartFactory.createPieChart3D("ѧ�����",data,true,false,false);  
	        //���ðٷֱ�  
	        PiePlot pieplot = (PiePlot) chart2.getPlot();  
	        DecimalFormat df = new DecimalFormat("0.00%");//���һ��DecimalFormat������Ҫ������С������  
	        NumberFormat nf = NumberFormat.getNumberInstance();//���һ��NumberFormat����  
	        StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//���StandardPieSectionLabelGenerator����  
	        pieplot.setLabelGenerator(sp1);//���ñ�ͼ��ʾ�ٷֱ�  
	      
	        //û�����ݵ�ʱ����ʾ������  
	        pieplot.setNoDataMessage("��������ʾ");  
	        pieplot.setCircular(false);  
	        pieplot.setLabelGap(0.02D);  
	      
	        pieplot.setIgnoreNullValues(true);//���ò���ʾ��ֵ  
	        pieplot.setIgnoreZeroValues(true);//���ò���ʾ��ֵ  
	        
	        chart2.getTitle().setFont(new Font("����",Font.BOLD,30));//���ñ�������  
	        PiePlot piePlot= (PiePlot) chart2.getPlot();//��ȡͼ���������  
	        piePlot.setLabelFont(new Font("����",Font.BOLD,20));//�������  
	        chart2.getLegend().setItemFont(new Font("����",Font.BOLD,20));  
			return chart2;
		}
}
