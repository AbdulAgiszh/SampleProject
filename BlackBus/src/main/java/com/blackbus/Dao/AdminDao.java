package com.blackbus.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.blackbus.connection.ConnectionUtill;
import com.blackbus.module.AdminModel;

import com.blackbus.module.UserModel;

public class AdminDao {

	public AdminModel adminLogin(String contact) throws ClassNotFoundException, SQLException {
		AdminModel adminmodule;
		String loginadmin="select * from admin_details where admin_email='"+contact+"'";
		Connection con=ConnectionUtill.connectdb();
		PreparedStatement ps=con.prepareStatement(loginadmin);
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(loginadmin);
		
		rs.next() ;
			adminmodule=new AdminModel(rs.getString(2),rs.getString(3),rs.getString(4));
		
		
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
	

public List<AdminModel> viewAdmin(){
    	
    	String adminView="select * from admin_details";
    	
    	Connection con;
    	List<AdminModel> adminList=new ArrayList<AdminModel>();
		try {
			con = ConnectionUtill.connectdb();
			PreparedStatement ps=con.prepareStatement(adminView);
			
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(adminView);
			
			while(rs.next()) {
				AdminModel adminModel=new AdminModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				adminList.add(adminModel);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return adminList;
		
    }
	



	    
}
