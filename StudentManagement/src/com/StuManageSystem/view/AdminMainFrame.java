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
		//---------------------为管理员界面设置打开后界面以及人数统计-------------
		dataset = getDataSet1();  
        frame1=new ChartPanel(columnchart(),true);
        //----------------------------------------------------------
        data = getDataSet2(); 
        frame2=new ChartPanel (piechart(),true); 
        //-----------------------------------

		// 提供当前日期及转换
		jlab_date = new JLabel(DateUtil.getDate());
		jlab_date.setFont(new Font("Agency FB", Font.BOLD, 18));
		jlab_wel = new JLabel("管理员，欢迎你！");
		but_exit = new JButton("注销");

		// 上部组件
		jp_top = new JPanel();
		jp_top.setLayout(null);
		jp_top.setBorder(BorderFactory.createTitledBorder(""));
		jp_top.setBorder(BorderFactory.createLineBorder(Color.black, 1));

		jp_top.setBounds(0, 0, 1300, 35);
		// 上界面添加组件
		jlab_date.setBounds(5, 5, 100, 25);
		jp_top.add(jlab_date);
		jlab_wel.setBounds(1000, 5, 125, 25);
		jp_top.add(jlab_wel);
		but_exit.setBounds(1150, 5, 100, 25);
		jp_top.add(but_exit);

		// 左侧菜单
		jp_left = new JPanel();
		jp_left.setLayout(null);
		jp_left.setBorder(BorderFactory.createTitledBorder(""));
		jp_left.setBorder(BorderFactory.createLineBorder(Color.black, 1));// 设置边框线
		jp_left.setBounds(0, 35, 200, 600);

		// 设置树的背景
		DefaultTreeCellRenderer cellRender1 = new DefaultTreeCellRenderer();
		cellRender1.setClosedIcon(new ImageIcon("image/学生管理.png"));//设置用于显示无扩展的非叶节点的图标。
        cellRender1.setLeafIcon(new ImageIcon("image/学生学籍信息更改.png")); //用于显示叶节点的图标。
        cellRender1.setTextSelectionColor(Color.RED);
		// 添加学生树
		DefaultMutableTreeNode sturoot = new DefaultMutableTreeNode("学生管理");
		DefaultMutableTreeNode stu1 = new DefaultMutableTreeNode("导入学生信息");
		DefaultMutableTreeNode stu2 = new DefaultMutableTreeNode("查询学生信息");
		// 往学生树添加子树
		sturoot.add(stu1);
		sturoot.add(stu2);
		stu = new JTree(sturoot);
		stu.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		stu.setBounds(10, 20, 180, 100);
		// 折叠子树
		stu.collapseRow(0);
		stu.collapseRow(1);

		stu.setOpaque(false);
		stu.setCellRenderer(cellRender1);

		// 添加教师树
		DefaultTreeCellRenderer cellRender2 = new DefaultTreeCellRenderer();
		cellRender2.setClosedIcon(new ImageIcon("image/老师管理.png"));//设置用于显示无扩展的非叶节点的图标。
        cellRender2.setLeafIcon(new ImageIcon("image/设置参与教师.png")); //用于显示叶节点的图标。
        cellRender2.setTextSelectionColor(Color.RED);
		DefaultMutableTreeNode tearoot = new DefaultMutableTreeNode("教师管理");
		DefaultMutableTreeNode tea1 = new DefaultMutableTreeNode("导入教师信息");
		DefaultMutableTreeNode tea2 = new DefaultMutableTreeNode("查询教师信息");
		// 往教师树添加子树
		tearoot.add(tea1);
		tearoot.add(tea2);

		tea = new JTree(tearoot);
		tea.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		// 折叠子树
		tea.collapseRow(0);
		tea.collapseRow(1);

		tea.setBounds(10, 140, 180, 80);
		tea.setCellRenderer(cellRender2);

		// 添加课程树
		DefaultMutableTreeNode courseroot = new DefaultMutableTreeNode("课程管理");
		DefaultTreeCellRenderer cellRender3 = new DefaultTreeCellRenderer();
		cellRender3.setLeafIcon(new ImageIcon("image/课程管理.png")); //用于显示叶节点的图标。
		cellRender3.setTextSelectionColor(Color.RED);
		course = new JTree(courseroot);
		// 折叠子树
		course.collapseRow(0);

		course.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		course.setBounds(10, 260, 180, 80);
		course.setCellRenderer(cellRender3);
		// 添加公告树
		DefaultTreeCellRenderer cellRender4 = new DefaultTreeCellRenderer();
		cellRender4.setLeafIcon(new ImageIcon("image/公告管理.png")); //用于显示叶节点的图标。
		cellRender4.setTextSelectionColor(Color.RED);//设置当前选中节点的文本颜色
		DefaultMutableTreeNode noticeroot = new DefaultMutableTreeNode("公告管理");
		noticetree = new JTree(noticeroot);
		// 折叠子树
		noticetree.collapseRow(0);
		noticetree.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		noticetree.setBounds(10, 380, 180, 80);
		noticetree.setCellRenderer(cellRender4);

		DefaultTreeCellRenderer cellRender5 = new DefaultTreeCellRenderer();
		//改动-----添加图标
		cellRender5.setClosedIcon(new ImageIcon("image/统计分析.png"));//设置用于显示无扩展的非叶节点的图标。
		cellRender5.setLeafIcon(new ImageIcon("image/统计.png")); //用于显示叶节点的图标。
		cellRender5.setTextSelectionColor(Color.RED);//设置当前选中节点的文本颜色
        //改动--------------------------------------------------------------------------
		// 添加数据统计树
		DefaultMutableTreeNode datastatistics = new DefaultMutableTreeNode("数据统计");
		DefaultMutableTreeNode data1 = new DefaultMutableTreeNode("人数统计");
		DefaultMutableTreeNode data2 = new DefaultMutableTreeNode("学生组成");
		// 往数据统计树添加子树
		datastatistics.add(data1);
		datastatistics.add(data2);
		datatree = new JTree(datastatistics);
		datatree.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		datatree.setBounds(10, 500, 180, 100);
		// 折叠子树
		datatree.collapseRow(0);
		datatree.collapseRow(1);
		
		datatree.setOpaque(false);
		datatree.setCellRenderer(cellRender5);

		jp_left.add(stu);
		jp_left.add(tea);
		jp_left.add(course);
		jp_left.add(noticetree);
		jp_left.add(datatree);

		// 面板实例化
		adminstuseek = new AdminStudentSeek(AdminMainFrame.this);
		adminstuadd = new AdminStudentAdd();
		adminteaseek = new AdminTeacherSeek(AdminMainFrame.this);
		adminnotice = new AdminNotice();
		adminteaadd = new AdminTeacherAdd();
		admincourse = new CourseManagementFrame();

		// 右侧菜单
		cardpanel = new CardLayout();

		jp_show = new JPanel();
		jp_show.setLayout(cardpanel);// 设置为卡片布局

		jp_show.add("空", new JLabel());

		// 添加学生查询卡片
		jp_show.add("stu1", adminstuadd);
		jp_show.add("stu2", adminstuseek);

		jp_show.add("tea1", adminteaadd);
		jp_show.add("tea2", adminteaseek);

		jp_show.add("course1", admincourse);

		jp_show.add("notice", adminnotice);
		jp_show.add("countnumber1", frame1);//加入柱形图卡片命名为countnumber1
		jp_show.add("countnumber2", frame2);//加入饼状图图卡片命名为countnumber2

		jp_show.setBorder(BorderFactory.createTitledBorder(""));
		jp_show.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		jp_show.setBounds(200, 35, 1100, 600);
		cardpanel.show(jp_show, "countnumber1");//一开始显示此卡片
		
		
		// 添加注销点击事件
		but_exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "您确定注销当前账户吗？", "提示信息", JOptionPane.YES_NO_OPTION);
				if (choice == 0) {
					// 关闭当前界面，打开登录界面
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
				// 折叠其他树
				tea.collapseRow(0);
				tea.collapseRow(1);
				datatree.collapseRow(0);
 			    datatree.collapseRow(1);
				if (e.getPath().getLastPathComponent().toString().equals("导入学生信息")) {
					cardpanel.show(jp_show, "stu1");

				} else if (e.getPath().getLastPathComponent().toString().equals("查询学生信息")) {

					adminstuseek.refreshStudentSeek();
					cardpanel.show(jp_show, "stu2");
				}

			}
		});

		// 教师点击事件
		tea.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {

				stu.clearSelection();
				course.clearSelection();
				noticetree.clearSelection();
				datatree.clearSelection();
				// 折叠其他树
				stu.collapseRow(0);
				stu.collapseRow(1);
				datatree.collapseRow(0);
	   			datatree.collapseRow(1);
				if (e.getPath().getLastPathComponent().toString().equals("导入教师信息")) {

					cardpanel.show(jp_show, "tea1");
				} else if (e.getPath().getLastPathComponent().toString().equals("查询教师信息")) {

					cardpanel.show(jp_show, "tea2");
				}

			}
		});

		// 课程点击事件
		course.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				stu.clearSelection();
				tea.clearSelection();
				noticetree.clearSelection();
				datatree.clearSelection();
				// 折叠其他树
				tea.collapseRow(0);
				tea.collapseRow(1);
				stu.collapseRow(0);
				stu.collapseRow(1);
				datatree.collapseRow(0);
				datatree.collapseRow(1);
				if (e.getPath().getLastPathComponent().toString().equals("课程管理")) {

					cardpanel.show(jp_show, "course1");
					admincourse.setJCombox();// 刷新选择老师的下拉列表
				}
			}
		});
        //公告点击事件
		noticetree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				stu.clearSelection();
				tea.clearSelection();
				course.clearSelection();
				datatree.clearSelection();
				// 折叠其他树
				tea.collapseRow(0);
				tea.collapseRow(1);
				stu.collapseRow(0);
				stu.collapseRow(1);
				datatree.collapseRow(0);
				datatree.collapseRow(1);
				if(e.getPath().getLastPathComponent().toString().equals("公告管理")) {
					cardpanel.show(jp_show, "notice");
				}
			}
		});
				
				
		// 数据统计点击事件
		datatree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {

				stu.clearSelection();
				tea.clearSelection();
				course.clearSelection();
				noticetree.clearSelection();
				//折叠其他树
			    stu.collapseRow(0);
   			    stu.collapseRow(1);
   			    tea.collapseRow(0);
   			   tea.collapseRow(1);
				if (e.getPath().getLastPathComponent().toString().equals("人数统计")) {
					dataset = getDataSet1(); 
					frame1=new ChartPanel(columnchart(),true);
					jp_show.add("countnumber1", frame1);
					cardpanel.show(jp_show, "countnumber1");			
				} else if (e.getPath().getLastPathComponent().toString().equals("学生组成")) {
					data = getDataSet2(); 
					frame2=new ChartPanel (piechart(),true); 
					jp_show.add("countnumber2", frame2);
					cardpanel.show(jp_show, "countnumber2");
				}

			}
		});
		// 窗口关闭事件
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
				int choice = JOptionPane.showConfirmDialog(null, "您确定退出本系统吗？", "提示信息", JOptionPane.YES_NO_OPTION);
				if (choice == 0) {
					dispose();
				}
			}

			public void windowClosed(WindowEvent e) {
			}

			public void windowActivated(WindowEvent e) {
			}
		});
		this.setIconImage(new ImageIcon("image/管理员.png").getImage());
		this.add(jp_show);
		this.add(jp_left);
		this.add(jp_top);
		this.setLayout(null);
		this.setTitle("管理员端");
		this.setSize(1300, 700);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);

	}
	//设置柱状图数据
		private static CategoryDataset getDataSet1() {  
	        DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
	        DataStatiacsDAO datastasticsdao=new DataStatiacsDAO();
	    	Integer[] personnum=new Integer[6];
	        personnum=datastasticsdao.getPersonNumber();
	        dataset.addValue(personnum[0], "老师在职人数","老师" );
	        dataset.addValue(personnum[1], "学生在读人数", "学生");  
	        dataset.addValue(personnum[2], "2015学生在读人数", "2015级");  
	        dataset.addValue(personnum[3], "2016学生在读人数", "2016级");  
	        dataset.addValue(personnum[4], "2017学生在读人数", "2017级");  
	        dataset.addValue(personnum[5], "2018学生在读人数", "2018级"); 
	        return dataset;  
	    }  
//		public ChartPanel getChartPanel1(){  
//		 return frame1;  
//		}   
		//设置饼状图数据
		private static DefaultPieDataset getDataSet2() {  
	        DefaultPieDataset dataset = new DefaultPieDataset();  
	        DataStatiacsDAO datastasticsdao=new DataStatiacsDAO();
	    	Integer[] personnum=new Integer[6];
	        personnum=datastasticsdao.getPersonNumber();
	        dataset.setValue("2015级",personnum[2]);  
	        dataset.setValue("2016级",personnum[3]);  
	        dataset.setValue("2017级",personnum[4]);  
	        dataset.setValue("2018级",personnum[5]);    
	        return dataset;  
	  }  
//	    public ChartPanel getChartPanel2(){  
//	        return frame2;  
//	          
//	    }  
	    //柱状设置封装方法
		public JFreeChart columnchart() {
			JFreeChart chart1 = ChartFactory.createBarChart3D(  
		             "人数统计", // 图表标题  
		            "总人数", // 目录轴的显示标签  
		            "数量", // 数值轴的显示标签  
		            dataset, // 数据集  
		            PlotOrientation.VERTICAL, // 图表方向：水平、垂直  
		            true,           // 是否显示图例(对于简单的柱状图必须是false)  
		            false,          // 是否生成工具  
		            false           // 是否生成URL链接  
		         ); 
			CategoryPlot plot=chart1.getCategoryPlot();//获取图表区域对象
			NumberAxis axis = (NumberAxis)chart1.getCategoryPlot().getRangeAxis();//设置纵坐标间隔单位
	       axis.setTickUnit(new NumberTickUnit(1D));//1为一个间隔单位
	       
	       CategoryAxis domainAxis=plot.getDomainAxis(); //水平底部列表  
	       domainAxis.setLabelFont(new Font("黑体",Font.BOLD,20)); //水平底部标题  
	       domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,20));  //垂直标题
	       ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状  
	       rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));  
	       chart1.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));  
	       chart1.getTitle().setFont(new Font("宋体",Font.BOLD,15));//设置标题字体  
	       BarRenderer3D renderer = new BarRenderer3D();
	       renderer.setItemMargin(-0.4);//设置柱状宽度和间距
	     //设置柱状显示数据值
	       renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	       renderer.setItemLabelsVisible(true);
	       //设置柱状顶部显示数据值
	       renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.CENTER_LEFT)); 
	       renderer.setItemLabelAnchorOffset(18); 
	       renderer.setItemLabelFont(new Font("Agency FB",Font.PLAIN,25));
	       plot.setRenderer(renderer);
	       return chart1;
		}
		public JFreeChart piechart() {
			//----------------学生组成统计图------------ 
	        JFreeChart chart2 = ChartFactory.createPieChart3D("学生组成",data,true,false,false);  
	        //设置百分比  
	        PiePlot pieplot = (PiePlot) chart2.getPlot();  
	        DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题  
	        NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象  
	        StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象  
	        pieplot.setLabelGenerator(sp1);//设置饼图显示百分比  
	      
	        //没有数据的时候显示的内容  
	        pieplot.setNoDataMessage("无数据显示");  
	        pieplot.setCircular(false);  
	        pieplot.setLabelGap(0.02D);  
	      
	        pieplot.setIgnoreNullValues(true);//设置不显示空值  
	        pieplot.setIgnoreZeroValues(true);//设置不显示负值  
	        
	        chart2.getTitle().setFont(new Font("宋体",Font.BOLD,30));//设置标题字体  
	        PiePlot piePlot= (PiePlot) chart2.getPlot();//获取图表区域对象  
	        piePlot.setLabelFont(new Font("宋体",Font.BOLD,20));//解决乱码  
	        chart2.getLegend().setItemFont(new Font("黑体",Font.BOLD,20));  
			return chart2;
		}
}
