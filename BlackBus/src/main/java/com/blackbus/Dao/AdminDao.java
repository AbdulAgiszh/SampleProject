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

	public AdminModule adminLogin(String contact) throws ClassNotFoundException, SQLException {
		AdminModule adminmodule;
		String loginadmin="select * from admin_details where admin_email='"+contact+"'";
		Connection con=ConnectionUtill.connectdb();
		PreparedStatement ps=con.prepareStatement(loginadmin);
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(loginadmin);
		
		rs.next() ;
			adminmodule=new AdminModule(rs.getString(2),rs.getString(3),rs.getString(4));
		
		
		return adminmodule;
	}
	
	public boolean checkadmin(String contact) throws ClassNotFoundException, SQLException {
		 
		String loginadmin="select * from admin_details where admin_email='"+contact+"'";
		Connection con=ConnectionUtill.connectdb();
		PreparedStatement ps=con.prepareStatement(loginadmin);
		
		Statement st=con.createStatement();
		
		int i=st.executeUpdate(loginadmin);
		
		if(i>0) {
			return true;
		}
		else {
			return false;	
		}
		
	}
	
	
	
	
	
	 public void deleteUser (UserModule UserModule) throws ClassNotFoundException, SQLException {
			
			String del="delete from user_details where user_id=?";
			
			Connection con=ConnectionUtill.connectdb();
			PreparedStatement ps=con.prepareStatement(del);
			
			ps.setInt(1, UserModule.getUserId());
			int res=ps.executeUpdate();
			if(res==1) {
			System.out.println(" Successfully deleted");
			ps.close();
			con.close();		
			}
			else
			{
				System.out.println("please enter correct id");
			}
		}
	    
}
