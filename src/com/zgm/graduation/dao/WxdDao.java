package com.zgm.graduation.dao;

import java.beans.Statement;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public final class WxdDao {
    
    
    public static String  url;
    public static String  User;
    public static String  Pwd;
    public static String  Driver;
    
    private static Properties pro;
    
	static{  
		pro=new Properties();
	    InputStream  in=WxdDao.class.getClass().getResourceAsStream("/jdbc.properties");
		try {
			System.out.println("dsf"+in);
			pro.load(in);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	    User = pro.getProperty("user");  
         Pwd = pro.getProperty("password");  
         url= pro.getProperty("url");  
        Driver= pro.getProperty("jdbcDriver");  
	    try {
	    	
			Class.forName(Driver);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	    
 }   
	public static Connection getconn(){
		 Connection con=null;
		try {
			con=DriverManager.getConnection(url,User,Pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static void CloseSQL(ResultSet rs,Statement st,Connection con){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(st!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
