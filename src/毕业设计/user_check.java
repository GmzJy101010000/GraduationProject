package ±œ“µ…Ëº∆;

import java.awt.RadialGradientPaint;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.plaf.synth.SynthStyle;

public final class user_check {
   static Connection conn;
   static PreparedStatement ps;
   static ResultSet rs; 
   
   public  static  user check(String id){
	   user u=null;
	   try {
		   String sql="select * from wcduser where user="+"'"+id+"'";
		   System.out.println(sql);
		conn=wxd_DAO.getconn();
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next()){
			u=new user(rs.getString(1), rs.getString(2));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	  return u; 
   }
}
