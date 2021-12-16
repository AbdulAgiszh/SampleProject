package com.blackbus.Dao;

import java.sql.*;

import com.blackbus.connection.ConnectionUtill;
import com.blackbus.module.AdminModule;
import com.blackbus.module.UserModule;



public class UserDao {
	
		
		 public UserModule loginUser(long contact) throws ClassNotFoundException, SQLException {
			 
			String userlogin="select * from users where user_contact='"+contact+"'";
			Connection con=ConnectionUtill.connectdb();
			PreparedStatement ps=con.prepareStatement(userlogin);
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(userlogin);
			
			rs.next() ;
			UserModule usermodule=new UserModule(rs.getString(2),rs.getInt(3),rs.getString(4),rs.getLong(5),rs.getString(6),rs.getString(7));
			
				return usermodule;
		}
		 
		 
		 public boolean checkUser(long contact) throws ClassNotFoundException, SQLException {
			 
				String userlogin="select * from users where user_contact='"+contact+"'";
				Connection con=ConnectionUtill.connectdb();
				PreparedStatement ps=con.prepareStatement(userlogin);
				
				Statement st=con.createStatement();
				int i=st.executeUpdate(userlogin);
				if(i>0) {
					return true;
				}
				else {
					return false;	
				}
				
			}
		
	
	
	public void insert(UserModule UserModule) throws ClassNotFoundException, SQLException {
		
		String insertquery="insert into users (user_name,user_age,user_email,user_contact,user_gender,user_password) values (?,?,?,?,?,?)";
		Connection con=ConnectionUtill.connectdb();
		PreparedStatement ps=con.prepareStatement(insertquery);
	
		ps.setString(1,UserModule.getUserName());
		ps.setInt(2,UserModule.getUserAge());
		ps.setString(3, UserModule.getUserEmail());
		ps.setLong(4,UserModule.getUserContact());
		ps.setString(5,UserModule.getUserGender());
		ps.setString(6, UserModule.getUserPassword());
	
		int result=ps.executeUpdate();
		if(result==1) {
		System.out.println( "Your Have Registered Successfully!!");
		ps.close();
		con.close();
		}
		else {
			System.out.println("your record has not registered");
		}
	}
	
	
	
    public void update (UserModule UserModule) throws ClassNotFoundException, SQLException {
    	
    	String userUpdate="update users set user_name=?, user_age=?, user_gender=?, user_password=? where user_contact='"+UserModule.getUserContact()+"'";
    	
    	Connection con=ConnectionUtill.connectdb();
		PreparedStatement ps=con.prepareStatement(userUpdate);
		
		ps.setString(1,UserModule.getUserName());
		ps.setInt(2,UserModule.getUserAge());
		ps.setString(3,UserModule.getUserGender());
		ps.setString(4, UserModule.getUserPassword());
		
		ps.executeUpdate();
		System.out.println("for "+UserModule.getUserContact()+ "profile is updated !!");
		ps.close();
		con.close();
    }
	
   
	
 
    
}
