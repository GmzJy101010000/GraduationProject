package com.zgm.graduation.client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import com.zgm.graduation.dao.WxdDao;
import com.zgm.graduation.entity.WXD;
import com.zgm.graduation.services.WxdSearch;
import com.zgm.graduation.utils.Chat;

public class WxdMain extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	WXD w = null;
    int all=0;
	public static void main(String a[]) {
		
	}

	JPanel mb1;
	JPanel mb2;
	JLabel bq1;
	JTextField wbk;
	JButton an1, an2,an5, an6;
	JTable biaoge;
	JScrollPane gdt;

	Vector<?> ziduan, jilu;
	PreparedStatement ps = null;
	Connection ct = null;
	ResultSet rs = null;

	JMenuBar cd;
	JMenu cd1, cd2, cd3, cd4, cd5, cd6, cd7;
	JMenuItem x1, x2, x3, x4,x41,x44, x5, x6, x7,x8,x9,x10,x11,x12;

	public WxdMain() throws SQLException {
		mb1 = new JPanel();

		mb2 = new JPanel();

		an6 = new JButton("�˳�");
		an6.addActionListener(this);
		an6.setActionCommand("tc");
		an5 = new JButton("ˢ��");
		an5.addActionListener(this);
		an5.setActionCommand("sx");
		mb2.add(an5);
		mb2.add(an6);

		cd = new JMenuBar();
		cd1 = new JMenu("���");
		cd2 = new JMenu("ɾ��");
		cd3 = new JMenu("�޸�");
		cd4 = new JMenu("��ѯ");
		cd5 = new JMenu("����ͳ�Ƽ�ͼ�����");
		cd6 = new JMenu("ͼ�����");
		cd7 = new JMenu("���ݵ���/����");

		x1 = new JMenuItem("����ID��ѯ");
		x2 = new JMenuItem("����ʱ��Ƶ��ǿ����ϲ�ѯ");
		x3 = new JMenuItem("������ߵ�����");
		x4 = new JMenuItem("ɾ���������ߵ�����");
		x44=new JMenuItem("����ɾ�����ߵ�����");
		x41=new JMenuItem("ɾ���������ߵ�����");
		

		x5 = new JMenuItem("�޸����ߵ�����");
		x6 = new JMenuItem("������Ƶ��ͳ��");
		x7 = new JMenuItem("������ͳ��");
		x8 = new JMenuItem("���ź�����ͳ��");
		x9 = new JMenuItem("�������ͳ��");
		x10 = new JMenuItem("��ʱ��ͳ��");
		x11 = new JMenuItem("�������ݵ�Excel");
		x12 = new JMenuItem("��Excel��������");
		cd4.add(x1);
		cd4.add(x2);
		cd1.add(x3);
		cd2.add(x4);
		cd2.add(x44);
		cd2.add(x41);

		cd3.add(x5);
		cd5.add(x6);
		cd5.add(x7);
		cd5.add(x8);
		cd5.add(x9);
		cd5.add(x10);
		
		cd7.add(x11);
		cd7.add(x12);
		

		cd.add(cd1);
		cd.add(cd2);
		cd.add(cd3);
		cd.add(cd4);
		cd.add(cd5);
		//cd.add(cd6);
		cd.add(cd7);
		
		x2.addActionListener(this);
		x2.setActionCommand("zhcx");
		
		x3.addActionListener(this);
		x3.setActionCommand("tj");
		x4.addActionListener(this);
		x4.setActionCommand("sc");
		
		x44.addActionListener(this);
		x44.setActionCommand("plsc");
		
		x41.addActionListener(this);
		x41.setActionCommand("allsc");
		
		x1.addActionListener(this);
		x1.setActionCommand("ssid");

		x5.addActionListener(this);
		x5.setActionCommand("xg");

		x6.addActionListener(this);
		x6.setActionCommand("fzzxpl");

		x7.addActionListener(this);
		x7.setActionCommand("fzdk");
		
		x8.addActionListener(this);
		x8.setActionCommand("fzxh");
		
		x9.addActionListener(this);
		x9.setActionCommand("fzzzb");
		
		x10.addActionListener(this);
		x10.setActionCommand("fztime");
		
		x11.addActionListener(this);
		x11.setActionCommand("toExcel");
		
		x12.addActionListener(this);
		x12.setActionCommand("fromExcel");

		WxdSearch s1 = new WxdSearch();
		biaoge = new JTable(s1);
		gdt = new JScrollPane(biaoge);
		
		DefaultTableCellRenderer   r   =   new   DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);  // �ñ�����ݾ���
		biaoge.setDefaultRenderer(Object.class, r);

		this.setJMenuBar(cd);
		this.add(gdt);
		// this.add(mb1,"North");
		this.add(mb1, "North");
		this.add(mb2, "South");

		this.setTitle("���ߵ������ݹ���ϵͳ");
		this.setSize(880, 550);
		this.setLocation(201, 81);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			ct = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=test", "sa", "123456");
			ct=WxdDao.getconn();
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("ssid")) {
			wbk = new JTextField(10);
			an1 = new JButton("��ѯ");
			an2 = new JButton("ȡ��");
			final JFrame j = new JFrame("����ID��ѯ");
			bq1 = new JLabel("ID");
			JPanel mb4 = new JPanel();
			JPanel mb5 = new JPanel();
			mb4.add(bq1);
			mb4.add(wbk);
			mb5.add(an1);mb5.add(an2);
			j.setSize(300, 100);
			j.setLocation(300, 300);
			j.setVisible(true);
			j.setResizable(false);
			j.add(mb4);
			j.add(mb5, "South");

			an1.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					boolean is = false;
					String sql = "select id from wxd";
					int xuhao = Integer.valueOf(wbk.getText());
					try{
						
						
						
						PreparedStatement pp1 = ct.prepareStatement(sql);
		                 
						rs = pp1.executeQuery();
						while (rs.next()) {
							if (xuhao == rs.getInt(1)) {

								is = true;
							}
						}
		                 }
		                 
					catch(Exception e1){}
					
					
				if(!is){
						JOptionPane.showMessageDialog(null, "     ��ID��Ӧ�����ݲ�����");
						WxdSearch ss2 = new WxdSearch();
						biaoge.setModel(ss2);
					}
					
					if(is){
						sql = "select * from wxd where id='" + xuhao + "'";
						WxdSearch s2 = new WxdSearch(sql);
						biaoge.setModel(s2);
						j.dispose();
					}
				}
			});
			an2.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					j.dispose();
				}
			});

		} else if (e.getActionCommand().equals("tj")) {

			show1("���");

		} else if (e.getActionCommand().equals("sc")) {
			show1("ɾ��");

		} 
		else if (e.getActionCommand().equals("plsc")) {
			MULdeleteshow();

		} 
		else if (e.getActionCommand().equals("allsc")) {
			deleteAll();

		} 
		else if (e.getActionCommand().equals("xg")) {
			show1("�޸�");

		} else if (e.getActionCommand().equals("fzzxpl")) {

			show0("����Ƶ��");

		} else if (e.getActionCommand().equals("fzdk")) {

			show0("����");
		} 
		else if (e.getActionCommand().equals("zhcx")) {

			zuheshow();
		} 
		
		else if (e.getActionCommand().equals("fzxh")) {

			show0("�ź�����");
		}
		
		else if (e.getActionCommand().equals("fzzzb")) {

			show0("�����");
		}
		else if (e.getActionCommand().equals("fztime")) {

			show0("����ʱ��");
		}
		else if (e.getActionCommand().equals("toExcel")) {

			sqltoexcel();
		}
		else if (e.getActionCommand().equals("fromExcel")) {

			excelTOsql();
		}
		 else if (e.getActionCommand().equals("tc")) {
			this.dispose();
			

		} else if (e.getActionCommand().equals("sx")) {
			WxdSearch s2 = new WxdSearch();
			biaoge.setModel(s2);

		}
	}
	
	private void deleteAll() {
		String  sql="delete from wxd";
		WxdSearch s=new WxdSearch(sql);
		biaoge.setModel(s);
		
	}

	public void MULdeleteshow(){
		final JFrame j=new  JFrame();
		final JTextField wbk1=new JTextField(10);
		final JTextField wbk2=new JTextField(10);
		JLabel bq1=new JLabel("ID��Χ");
		JLabel bq2=new JLabel("--");
		JButton an1=new JButton("����");
		JButton an2=new JButton("ȡ��");
		
		JPanel mb1=new JPanel();
		JPanel mb2=new JPanel();
		
		mb1.add(bq1);mb1.add(wbk1);mb1.add(bq2);mb1.add(wbk2);
		mb2.add(an1);mb2.add(an2);
		
		j.add(mb1);
		j.add(mb2,"South");
		j.setTitle("����ɾ��");
		j.setVisible(true);
		j.setResizable(false);
		j.setSize(300,120);
		j.setLocation(300,300);
		
		an2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				j.dispose();
				
			}
		});
		
       an1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(wbk1.getText().equals("")&&wbk2.getText().equals("")){
					JOptionPane.showMessageDialog(null, "   ÿһ�������Ϊ�գ�");
				}
				else{
					
					int a=Integer.valueOf(wbk1.getText());
					int b=Integer.valueOf(wbk2.getText());
					showdelete(a,b);
				}
				
			}
		});
		
		
		
		
	}
	public void  showdelete(final int a,final int b){
		final JFrame j1=new JFrame();
		j1.setTitle("���ҽ��");
		JButton an1=new JButton("ɾ��ȫ��");
		JButton an2=new JButton("ȡ��");
		final JTable bg=new JTable();
        JScrollPane gdt1=new JScrollPane(bg);
		JPanel mb=new JPanel();
		j1.add(gdt1);
		j1.add(mb, "South");
		mb.add(an1);mb.add(an2);
		j1.setSize(880, 500);
		j1.setLocation(301, 181);
		j1.setVisible(true);
		j1.setResizable(false);
		
		String sql="select * from  wxd where id"  + "  BETWEEN " + a + " AND " + b;
		System.out.println(sql);
		WxdSearch s1=new WxdSearch(sql);
		bg.setModel(s1);
		
		DefaultTableCellRenderer   r   =   new   DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);  // �ñ�����ݾ���
		bg.setDefaultRenderer(Object.class, r);
		
		an2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				j1.dispose();
				
			}
		});
		
         an1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql="delete  from  wxd where id"  + "  BETWEEN " + a + " AND " + b;
				WxdSearch s=new WxdSearch(sql);
				bg.setModel(s);
				JOptionPane.showMessageDialog(j1, "��ɾ��ȫ��");
			}
		});
		
	}
     public  void zuheshow(){
    	 final JFrame j = new JFrame();
    	 final JTextField t1 = new JTextField(15);
    	 final JTextField t2 = new JTextField(15);
    	 final JTextField t3 = new JTextField(15);
 		
 		JLabel xh = new JLabel("  ʱ��");
		JLabel zxpl = new JLabel("  Ƶ��");
		JLabel dk = new JLabel("  ����");
 		
		JPanel mb1 = new JPanel();
		JPanel mb2 = new JPanel();
		JPanel mb3 = new JPanel();
		JPanel mb4 = new JPanel();
		
		JButton jb = new JButton("��ѯ");
 		JButton jb1 = new JButton("ȡ��");
 		
		mb1.add(xh);mb1.add(t1);mb2.add(zxpl);mb2.add(t2);mb3.add(dk);mb3.add(t3);
		mb4.add(jb);mb4.add(jb1);
		j.setLayout(new GridLayout(4, 1));
 		j.add(mb1);j.add(mb2);j.add(mb3);j.add(mb4);
 		j.setTitle("��������ѯ");
 		j.setSize(260, 300);
 		j.setLocation(300, 200);
 		j.setVisible(true);
 		j.setResizable(false);
 		
 		jb1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				j.dispose();
			}
		});
 		jb.addActionListener(new ActionListener() {//��������ѯ

			public void actionPerformed(ActionEvent e) {
				String time = t1.getText();
				double pl=Double.valueOf(t2.getText());
				double nl=Double.valueOf(t3.getText());
				
				String sql = "SELECT * from wxd WHERE Midfrequency = " +pl+ " and Scope= "+nl+" and time= '"+time+"'";
				WxdSearch s2 = new WxdSearch(sql);
				biaoge.setModel(s2);
				j.dispose(); 
				
			}
		});
 		
    	 
     }
	public void show1(final String type) {
		final JTextField t1 = new JTextField(15);
		final JTextField t2 = new JTextField(15);
		final JTextField t3 = new JTextField(15);
		final JTextField t4 = new JTextField(15);
		final JTextField t5 = new JTextField(15);
		final JTextField t6 = new JTextField(15);
		final JFrame j = new JFrame();
		j.setTitle(type + "���ߵ�����");
		j.setSize(260, 300);
		j.setLocation(300, 200);
		j.setVisible(true);
		j.setResizable(false);
		JButton jb = new JButton(type);
		JButton jb1 = new JButton("ȡ��");
		jb1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				j.dispose();
			}
		});
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(t1.getText().equals("")||t2.getText().equals("")||t3.getText().equals("")||
						t4.getText().equals("")||t5.getText().equals("")){
					JOptionPane.showMessageDialog(j, "ÿһ�ֵ�����ܞ��");
				}else{
				int k1=Integer.valueOf(t1.getText());
				double k2=Double.valueOf(t2.getText());
				double k3=Double.valueOf(t3.getText());
				double k4=Double.valueOf(t4.getText());
				double k5=Double.valueOf(t5.getText());
				String k6=t6.getText();

				w = new WXD(k1, k2, k3, k4, k5, k6);

				shujuku(type);
				t1.setText(null);
				t2.setText(null);
				t3.setText(null);
				t4.setText(null);
				t5.setText(null);
				t6.setText(null);

			}
			}
		});

		JLabel xh = new JLabel("  ���");
		JLabel zxpl = new JLabel("  Ƶ��");
		JLabel dk = new JLabel("  ����");
		JLabel xhnl = new JLabel("  ����");
		JLabel zzb = new JLabel("�����");
		JLabel sj = new JLabel("  ʱ��");
		JPanel mb1 = new JPanel();
		JPanel mb2 = new JPanel();
		JPanel mb3 = new JPanel();
		JPanel mb4 = new JPanel();
		JPanel mb5 = new JPanel();
		JPanel mb6 = new JPanel();
		JPanel mb7 = new JPanel();

		j.setLayout(new GridLayout(7, 1));
		mb1.add(xh);
		mb1.add(t1);
		mb2.add(zxpl);
		mb2.add(t2);
		mb3.add(dk);
		mb3.add(t3);
		mb7.add(jb);
		mb7.add(jb1);
		mb4.add(xhnl);
		mb4.add(t4);
		mb5.add(zzb);
		mb5.add(t5);
		mb6.add(sj);
		mb6.add(t6);
		j.add(mb1);
		j.add(mb2);
		j.add(mb3);
		j.add(mb4);
		j.add(mb5);
		j.add(mb6);
		j.add(mb7);

	}

	public void show0(final String type) {
		final JFrame j = new JFrame();
		final JPanel mb1, mb2;
		final JButton an1, an2;
		final JLabel bq1 = new JLabel(type + "��Χ");
		final JLabel bq2 = new JLabel("~~");
		final JTextField wbk1 = new JTextField(12);
		final JTextField wbk2 = new JTextField(12);
		an1 = new JButton("ͳ��");
		an2 = new JButton("ȡ��");
		mb1 = new JPanel();
		mb2 = new JPanel();
		mb1.add(bq1);
		mb1.add(wbk1);
		mb1.add(bq2);
		mb1.add(wbk2);
		mb2.add(an1);
		mb2.add(an2);
		j.setTitle("��" + type + "ͳ��");

		an1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				show2(type , wbk1.getText(), wbk2.getText());
			}
		});
		an2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				j.dispose();
			}
		});
		j.add(mb1);
		j.add(mb2, "South");
		j.setVisible(true);
		j.setResizable(false);
		j.setLocation(200, 300);
		j.setSize(500, 120);

	}

	public Object getSqlValue(String sql){
		Object object = null;
		try {
			ps=ct.prepareStatement(sql );
			rs=ps.executeQuery();
			if (rs.next()){
				object=rs.getObject(1);
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		return object;
	}
	
	
	public void show2(String type,String s1, String s2) {
		final JFrame j1 = new JFrame();
		JPanel mb1 = new JPanel();
		JPanel mb2 = new JPanel();
		JButton an = new JButton("�ر�");
		JScrollPane gdt1 = null;
		JTextField wbk1 = new JTextField(15);
		JTextField wbk2 = new JTextField(15);
		JTextField wbk3 = new JTextField(5);
		JTable bg1 = new JTable();
		JLabel bq1,bq2,bq3,bq4;
		
		an.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				j1.dispose();

			}
		});
		
		String tt=null;
		boolean is_time=false;
		String	sql="";
		double minx=0.0;
		double second=0.0;
		double third=0.0;
		double forth=0.0;
		double fifth=0.0;
		double maxx=0.0;
		
		int a1=0;
		int b1=0;
		int c1=0;
		int d1=0;
		int e=0;
		
		if(type.equals("����Ƶ��")){
			tt="Midfrequency";
			sql="select min("+tt+") from wxd";
			
		minx=(Double)getSqlValue(sql);
			
			sql="select max("+tt+") from wxd";
			
			maxx=(Double)getSqlValue(sql);
			
			double avarge=(maxx-minx)/5.0;
			second=minx+avarge;
			third=second+avarge;
			forth=third+avarge;
			fifth=forth+avarge;
			
			sql="select count(*) from wxd where "+tt+" BETWEEN "+minx+" and "+second;
			a1=Integer.parseInt(getSqlValue(sql).toString());
			
			sql="select count(*) from wxd where "+tt+" BETWEEN "+second+" and "+third;
			b1=Integer.parseInt(getSqlValue(sql).toString());
			
			sql="select count(*) from wxd where "+tt+" BETWEEN "+third+" and "+forth;
			c1=Integer.parseInt(getSqlValue(sql).toString());
			
			sql="select count(*) from wxd where "+tt+" BETWEEN "+forth+" and "+fifth;
			d1=Integer.parseInt(getSqlValue(sql).toString());
			
			sql="select count(*) from wxd where "+tt+" BETWEEN "+fifth+" and "+maxx;
			e=Integer.parseInt(getSqlValue(sql).toString());
			System.out.println(a1+","+b1+","+c1+","+d1+","+e);
			
			
		}
		else if(type.equals("����")){
			tt="Bandwidth";
			sql="select min("+tt+") from wxd";
			
			minx=(Double)getSqlValue(sql);
				
				sql="select max("+tt+") from wxd";
				
				maxx=(Double)getSqlValue(sql);
				
				double avarge=(maxx-minx)/5.0;
				second=minx+avarge;
				third=second+avarge;
				forth=third+avarge;
				fifth=forth+avarge;
				
				sql="select count(*) from wxd where "+tt+" BETWEEN "+minx+" and "+second;
				a1=Integer.parseInt(getSqlValue(sql).toString());
				
				sql="select count(*) from wxd where "+tt+" BETWEEN "+second+" and "+third;
				b1=Integer.parseInt(getSqlValue(sql).toString());
				
				sql="select count(*) from wxd where "+tt+" BETWEEN "+third+" and "+forth;
				c1=Integer.parseInt(getSqlValue(sql).toString());
				
				sql="select count(*) from wxd where "+tt+" BETWEEN "+forth+" and "+fifth;
				d1=Integer.parseInt(getSqlValue(sql).toString());
				
				sql="select count(*) from wxd where "+tt+" BETWEEN "+fifth+" and "+maxx;
				e=Integer.parseInt(getSqlValue(sql).toString());
				System.out.println(a1+","+b1+","+c1+","+d1+","+e);
				
		}
		else if(type.equals("�ź�����")){
			tt="Scope";
			sql="select min("+tt+") from wxd";
			
			minx=(Double)getSqlValue(sql);
				
				sql="select max("+tt+") from wxd";
				
				maxx=(Double)getSqlValue(sql);
				
				double avarge=(maxx-minx)/5.0;
				second=minx+avarge;
				third=second+avarge;
				forth=third+avarge;
				fifth=forth+avarge;
				
				sql="select count(*) from wxd where "+tt+" BETWEEN "+minx+" and "+second;
				a1=Integer.parseInt(getSqlValue(sql).toString());
				
				sql="select count(*) from wxd where "+tt+" BETWEEN "+second+" and "+third;
				b1=Integer.parseInt(getSqlValue(sql).toString());
				
				sql="select count(*) from wxd where "+tt+" BETWEEN "+third+" and "+forth;
				c1=Integer.parseInt(getSqlValue(sql).toString());
				
				sql="select count(*) from wxd where "+tt+" BETWEEN "+forth+" and "+fifth;
				d1=Integer.parseInt(getSqlValue(sql).toString());
				
				sql="select count(*) from wxd where "+tt+" BETWEEN "+fifth+" and "+maxx;
				e=Integer.parseInt(getSqlValue(sql).toString());
				System.out.println(a1+","+b1+","+c1+","+d1+","+e);
			
		}
		else if(type.equals("�����")){
			tt="Carriernoise";
			sql="select min("+tt+") from wxd";
			
			minx=(Double)getSqlValue(sql);
				
				sql="select max("+tt+") from wxd";
				
				maxx=(Double)getSqlValue(sql);
				
				double avarge=(maxx-minx)/5.0;
				second=minx+avarge;
				third=second+avarge;
				forth=third+avarge;
				fifth=forth+avarge;
				
				sql="select count(*) from wxd where "+tt+" BETWEEN "+minx+" and "+second;
				a1=Integer.parseInt(getSqlValue(sql).toString());
				
				sql="select count(*) from wxd where "+tt+" BETWEEN "+second+" and "+third;
				b1=Integer.parseInt(getSqlValue(sql).toString());
				
				sql="select count(*) from wxd where "+tt+" BETWEEN "+third+" and "+forth;
				c1=Integer.parseInt(getSqlValue(sql).toString());
				
				sql="select count(*) from wxd where "+tt+" BETWEEN "+forth+" and "+fifth;
				d1=Integer.parseInt(getSqlValue(sql).toString());
				
				sql="select count(*) from wxd where "+tt+" BETWEEN "+fifth+" and "+maxx;
				e=Integer.parseInt(getSqlValue(sql).toString());
				System.out.println(a1+","+b1+","+c1+","+d1+","+e);
				
		}
		else if(type.equals("����ʱ��")){
			is_time=true;
			tt="time";
			sql="select min("+tt+") from wxd";
			
			minx=(Double)getSqlValue(sql);
				
				sql="select max("+tt+") from wxd";
				
				maxx=(Double)getSqlValue(sql);
				
				double avarge=(maxx-minx)/5.0;
				second=minx+avarge;
				third=second+avarge;
				forth=third+avarge;
				fifth=forth+avarge;
				
				sql="select count(*) from wxd where "+tt+" BETWEEN "+minx+" and "+second;
				a1=Integer.parseInt(getSqlValue(sql).toString());
				
				sql="select count(*) from wxd where "+tt+" BETWEEN "+second+" and "+third;
				b1=Integer.parseInt(getSqlValue(sql).toString());
				
				sql="select count(*) from wxd where "+tt+" BETWEEN "+third+" and "+forth;
				c1=Integer.parseInt(getSqlValue(sql).toString());
				
				sql="select count(*) from wxd where "+tt+" BETWEEN "+forth+" and "+fifth;
				d1=Integer.parseInt(getSqlValue(sql).toString());
				
				sql="select count(*) from wxd where "+tt+" BETWEEN "+fifth+" and "+maxx;
				e=Integer.parseInt(getSqlValue(sql).toString());
				System.out.println(a1+","+b1+","+c1+","+d1+","+e);
				
		}
		String a = null;
		
			sql="select count(*) from wxd ";
		try {
			ps=ct.prepareStatement(sql );
			rs=ps.executeQuery();
			if (rs.next()){
				all=rs.getInt(1);
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		if(is_time ==false){
			
		int s3=Integer.valueOf(s1);
		int s4=Integer.valueOf(s2);
		
		 sql = "select * from  wxd where " + tt + "  BETWEEN " + s3 + " AND " + s4;
		System.out.println(sql);

		gdt1 = new JScrollPane(bg1);
		WxdSearch ss1 = new WxdSearch(sql);
		bg1.setModel(ss1);
		
		
		
		
		
		
		try {
			sql="select count(*) from wxd where "+ tt + "  BETWEEN " + s3 + " AND " + s4;
			ps=ct.prepareStatement(sql );
			rs=ps.executeQuery();
			if (rs.next()){
				a=rs.getString(1);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}else{
			
			 sql = "select * from  wxd where " + tt + "  BETWEEN '" + s1 + "' AND '" + s2+"' ";
			System.out.println(sql);

			gdt1 = new JScrollPane(bg1);
			WxdSearch ss1 = new WxdSearch(sql);
			bg1.setModel(ss1);
			
			
			try {
				sql="select count(*) from wxd where "+ tt + "  BETWEEN '" + s1 + "' AND '" + s2+"'";
				ps=ct.prepareStatement(sql );
				rs=ps.executeQuery();
				if (rs.next()){
					a=rs.getString(1);
				}
				
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		
		
		DefaultTableCellRenderer   r   =   new   DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);  
		bg1.setDefaultRenderer(Object.class, r);
		
		String aa=String.valueOf(s1);
		String b=String.valueOf(s2);
		String c=String.valueOf(a);

		wbk1.setText(aa);wbk2.setText(b);wbk3.setText(c);
		bq1=new JLabel("ͳ�ƽ��"+":   "+type+"��");
		bq2=new JLabel("~~");
		bq3=new JLabel("��Χ�����ݼ�¼��");
		bq4=new JLabel("��");
		
		j1.setTitle(type+"ͳ�ƽ��");

		j1.add(gdt1);
		j1.add(mb1, "South");
		j1.add(mb2, "North");
		mb2.add(bq1);mb2.add(bq2);mb2.add(wbk1);mb2.add(bq2);mb2.add(wbk2);mb2.add(bq3);mb2.add(wbk3);mb2.add(bq4);
		mb1.add(an);
		j1.setSize(880, 500);
		j1.setLocation(301, 181);
		j1.setVisible(true);
		j1.setResizable(false);
		double sDouble=(Double.valueOf(a)/all);
		System.out.println(all);
	int m=	(int)(sDouble*1000);
	double mm=m/10.0;
	Chat.showChart(type,mm, 100-mm);
		Chat.showChart2(type,mm, 100-mm);
		Chat.showChart5(type, a1, b1, c1, d1, e,minx,second,third,forth,fifth,maxx);
	}

	public boolean shujuku(String type) {
		boolean state = false;
		// System.out.println("oii"+w);
		try {

			if (type.equals("���")) {
				boolean is = true;
				int id1 = w.getId();
				String time=w.getTime();
				
				if(time.length()==23){
				String sql = "select id from wxd";
				PreparedStatement pp1 = ct.prepareStatement(sql);

				rs = pp1.executeQuery();
				while (rs.next()) {
					if (id1 == rs.getInt(1)) {
						JOptionPane.showMessageDialog(null, "        �ظ�ID�����������룡��");
						is = false;
					}
				}

				if (is == true) {
					sql = "insert into wxd(id,Midfrequency,Bandwidth,Scope,Carriernoise,time) values(?,?,?,?,?,?) ";

					pp1 = ct.prepareStatement(sql);
					pp1.setDouble(2, w.getMidfrequency());
					pp1.setInt(1, w.getId());
					pp1.setDouble(3, w.getBandwidth());
					pp1.setDouble(4, w.getScope());
					pp1.setDouble(5, w.getCarriernoise());
					pp1.setString(6, w.getTime());
					pp1.executeUpdate();
					JOptionPane.showMessageDialog(null, "        ��ӳɹ�����");
					state = true;
				}
				WxdSearch s2 = new WxdSearch();
				biaoge.setModel(s2);
				}
				else{
					JOptionPane.showMessageDialog(null, "���ڸ�ʽ����׼ȷ��ʽΪ2016-05-16 15:23:46 666");
				}
			}
			if (type.equals("ɾ��")) {
				boolean is = false;
				
				int id1 = w.getId();
				String sql = "select id from wxd";
				PreparedStatement pp1 = ct.prepareStatement(sql);
				rs = pp1.executeQuery();
				while (rs.next()) {
					if (id1 == rs.getInt(1)) {

						is = true;
					}
				}
				
				
				
			if(!is){
					JOptionPane.showMessageDialog(null, "     ��ID��Ӧ�����ݲ����ڣ��h��ʧ��");
				}
				
				if(is){
					 sql = "delete from wxd where id=? ";
					 pp1 = ct.prepareStatement(sql);
				pp1.setInt(1, w.getId());
				pp1.executeUpdate();
				WxdSearch s2 = new WxdSearch();
				biaoge.setModel(s2);
				JOptionPane.showMessageDialog(null, "        �h���ɹ�����");
				}
				
			} else if (type.equals("�޸�")) {
				boolean is = false;
				int id1 = w.getId();
				String sql = "select id from wxd";
				PreparedStatement pp1 = ct.prepareStatement(sql);
                 String  time=w.getTime();
                 if(time.length()==23){
				rs = pp1.executeQuery();
				while (rs.next()) {
					if (id1 == rs.getInt(1)) {

						is = true;
					}
				}
				if (!is) {
					JOptionPane.showMessageDialog(null, "     ��ID��Ӧ�����ݲ����ڣ��޸�ʧ��");
				}

				if (is) {
					sql = "update wxd set Midfrequency=?,Bandwidth=?,Scope=?,Carriernoise=?,time=? where id = ?";

					pp1 = ct.prepareStatement(sql);
					System.out.println(w.getBandwidth());
					pp1.setDouble(1, w.getMidfrequency());
					pp1.setInt(6, w.getId());
					pp1.setDouble(2, w.getBandwidth());
					pp1.setDouble(3, w.getScope());
					pp1.setDouble(4, w.getCarriernoise());
					pp1.setString(5, w.getTime());
					pp1.executeUpdate();

					JOptionPane.showMessageDialog(null, "        �޸ĳɹ�����");
					state = true;
				}
				WxdSearch s2 = new WxdSearch();
				biaoge.setModel(s2);

			}else{
				JOptionPane.showMessageDialog(null, "���ڸ�ʽ������ȷ��ʽΪ2016-05-16 15:23:46 666");
			}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;

	}
	public void  sqltoexcel(){
		final JFrame j=new JFrame();
		JLabel  bq=new JLabel("Excel��·�����ļ�����");
		final JTextField  wbk=new JTextField(15);
		JPanel  mb=new JPanel();
		JPanel  mb1=new JPanel();
		JButton an1,an2;
		an1=new JButton("����");
		an2=new JButton("ȡ��");
		mb.add(bq);
		mb.add(wbk);
		mb1.add(an1);
		mb1.add(an2);
		
		j.add(mb);
		j.add(mb1,"South");
		
		j.setTitle("�����ݵ�����Excel");
		j.setVisible(true);
		j.setSize(330, 130);
		j.setLocation(300,300);
		j.setResizable(false);
		
		an1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			String a=wbk.getText();
			String b="\"select * from test.dbo.wxd\"";
			String c="\"DESKTOP-KPK9EJT\"";
			String d ="\"root\"";
			String e1="\"123456\"";
			String sql="exec master..xp_cmdshell "+" 'bcp "+b+" queryout "+a+" -c -q -S"+c+" -U"+d+" -P"+e1+"'";

			try {
				//pp1 = ct.prepareStatement(sql);
				WxdSearch sousuo=new WxdSearch(sql);
			} catch (Exception e2) {
				
				e2.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "   �����ѳɹ�������ָ����Excel��");
			j.dispose();	
			}
		});
		
        an2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
			j.dispose();	
			}
		});
		
		
		
	}
	
	public void  excelTOsql(){
		final JFrame j=new JFrame();
		JLabel  bq=new JLabel("Excel��·�����ļ�����");
		final JTextField  wbk=new JTextField(15);
		JPanel  mb=new JPanel();
		JPanel  mb1=new JPanel();
		JButton an1,an2;
		an1=new JButton("����");
		an2=new JButton("ȡ��");
		mb.add(bq);
		mb.add(wbk);
		mb1.add(an1);
		mb1.add(an2);
		
		j.add(mb);
		j.add(mb1,"South");
		
		j.setTitle("��Excel��������");
		j.setVisible(true);
		j.setSize(330, 130);
		j.setLocation(300,300);
		j.setResizable(false);
		
		an1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			String a=wbk.getText();
			String b="\"select * from test.dbo.wxd\"";
			String sql="INSERT INTO wxd SELECT * FROM OPENROWSET("+"'Microsoft.ACE.OLEDB.12.0' "+","+"'Excel 5.0;HDR=YES;DATABASE="+a+"',sheet1$)";
			System.out.println(sql);
			PreparedStatement pp1;
			try {
				//pp1 = ct.prepareStatement(sql);
				WxdSearch sousuo=new WxdSearch(sql);
			} catch (Exception e2) {
				
				e2.printStackTrace();
			}
			WxdSearch sousuo=new WxdSearch();
			biaoge.setModel(sousuo);
			JOptionPane.showMessageDialog(null, "   �����ѳɹ���Excel�������ݿ⣡");
				
			}
		});
		
        an2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
			j.dispose();	
			}
		});
		
		
		
	}
	
}

class myPanel extends JPanel{
    protected void paintComponent(Graphics g){
        super.paintComponent(g);                             
        ImageIcon image=new ImageIcon(getClass().getResource("��Ƭ/_}@9AMEFC%3@K23ZJR0P0SU.png"));        
        image.setImage(image.getImage().getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_FAST)); 
        image.paintIcon(this, g,0, 0);
    }   
    }     
