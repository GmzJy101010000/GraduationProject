package com.zgm.graduation.services;
import java.sql.*;
import  java.util.*;

import javax.swing.table.*;

import com.zgm.graduation.dao.WxdDao;
public class WxdSearch extends  AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Vector ziduan,jilu;
	PreparedStatement ps=null;
	Connection  ct=null;
	ResultSet  rs=null;
	
	
	public int getRowCount() {
		
		return this.jilu.size();
	}

	
	public int getColumnCount() {
		
		return this.ziduan.size();
	}

	
	public Object getValueAt(int hang, int lie) {
		
		return ((Vector)this.jilu.get(hang)).get(lie);
	}
	
	public WxdSearch(){
		this.sqlyj("select * from wxd");
	}
	
	public WxdSearch (String ss)
	{
		this.sqlyj(ss);
		
	}
    public String getColumnName(int e){
    	return   (String)this.ziduan.get(e);
    }

	private void sqlyj(String sql) {
		ziduan=new Vector();
		  ziduan.add("ID(序号)");
		  ziduan.add("中心频率（MHz）");
		  ziduan.add("带宽（dB）");
		  ziduan.add("信号能量单位(dBm)");
		  ziduan.add("载噪比(dB)");
		  ziduan.add("发现时间");
		  
		  jilu=new Vector();
		  try{
//			  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//				ct=DriverManager.getConnection
//				("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=test","sa","123456");
			    ct=WxdDao.getconn();
				ps=ct.prepareStatement(sql );
				rs=ps.executeQuery();
				
				while(rs.next()){
					Vector hang=new Vector();
					hang.add(rs.getString(1));
					hang.add(rs.getString(2));
					hang.add(rs.getString(3));
					hang.add(rs.getString(4));
					hang.add(rs.getString(5));
					hang.add(rs.getString(6));
					jilu.add(hang);
				}
		  }
		  catch(Exception e){}

		
	}
   
}
