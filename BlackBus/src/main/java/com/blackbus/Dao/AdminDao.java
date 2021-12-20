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

	public AdminModel adminLogin(String contact)  {
		
		String loginadmin="select * from admin_details where admin_email='"+contact+"'";
		Connection con;
		AdminModel adminmodule=null;
		try {
			con = ConnectionUtill.connectdb();
			PreparedStatement pstatement=con.prepareStatement(loginadmin);
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(loginadmin);
			
			rs.next() ;
				adminmodule=new AdminModel(rs.getString(2),rs.getLong(3),rs.getString(4),rs.getString(5));
			
			
		} catch (ClassNotFoundException e) {
			e.getMessage();
		} catch (SQLException e) {
			e.getMessage();
		}
		
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
	
	
public void updateAdmin (AdminModel AdminModel) {
    	
    	String adminUpdate="update admin_details set admin_name=?,admin_contact=?, admin_password=? where admin_email='"+AdminModel.getAdminEmail()+"'";
    	
    	Connection con;
		try {
			con = ConnectionUtill.connectdb();
			PreparedStatement pstatement=con.prepareStatement(adminUpdate);
			
			pstatement.setString(1, AdminModel.getAdminName());
			pstatement.setLong(2, AdminModel.getAdmincontact());
			pstatement.setString(3, AdminModel.getAdminPassword());
			
			pstatement.executeUpdate();
			System.out.println("for "+AdminModel.getAdminEmail()+ "profile is updated !!");
			pstatement.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.getMessage();
		} catch (SQLException e) {
			e.getMessage();
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
				AdminModel adminModel=new AdminModel(rs.getString(2),rs.getLong(3),rs.getString(4),rs.getString(5));
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
