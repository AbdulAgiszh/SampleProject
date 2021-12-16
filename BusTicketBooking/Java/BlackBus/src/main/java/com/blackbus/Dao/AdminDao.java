package com.blackbus.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.blackbus.connection.ConnectionUtill;
import com.blackbus.module.AdminModule;
import com.blackbus.module.UserModule;

public class AdminDao {

	public AdminModule admin(String contact) throws ClassNotFoundException, SQLException {
		AdminModule adminmodule;
		String loginadmin="select * from admins where admin_email='"+contact+"'";
		Connection con=ConnectionUtill.connectdb();
		PreparedStatement ps=con.prepareStatement(loginadmin);
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(loginadmin);
		
		rs.next() ;
			adminmodule=new AdminModule(rs.getString(2),rs.getString(3),rs.getString(4));
		
		
		return adminmodule;
	}
	
	
	
	 public void delete (UserModule UserModule) throws ClassNotFoundException, SQLException {
			
			String del="delete from users where user_id=?";
			
			Connection con=ConnectionUtill.connectdb();
			PreparedStatement ps=con.prepareStatement(del);
			
			ps.setInt(1, UserModule.getUserId());
			int res=ps.executeUpdate();
			System.out.println(res + "is deleted");
			ps.close();
			con.close();		
		}
	    
}
