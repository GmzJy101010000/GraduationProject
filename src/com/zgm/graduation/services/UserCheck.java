package com.zgm.graduation.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zgm.graduation.dao.WxdDao;
import com.zgm.graduation.entity.User;

public final class UserCheck {
   static Connection conn;
   static PreparedStatement ps;
   static ResultSet rs; 
   
   public  static  User check(String id){
	   User u=null;
	   try {
		   String sql="select * from wcduser where user="+"'"+id+"'";
		   System.out.println(sql);
		conn=WxdDao.getconn();
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next()){
			u=new User(rs.getString(1), rs.getString(2));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	  return u; 
   }
}
