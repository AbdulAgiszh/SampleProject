package com.blackbus.Dao;

import java.sql.*;

import com.blackbus.connection.ConnectionUtill;
import com.blackbus.module.AdminModule;
import com.blackbus.module.UserModule;



public class UserDao {
	
		
		 public UserModule login(long contact) throws ClassNotFoundException, SQLException {
			 
			String useradmin="select * from users where user_contact='"+contact+"'";
			Connection con=ConnectionUtill.connectdb();
			PreparedStatement ps=con.prepareStatement(useradmin);
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(useradmin);
			
			rs.next() ;
			UserModule usermodule=new UserModule(rs.getString(2),rs.getInt(3),rs.getString(4),rs.getLong(5),rs.getString(6),rs.getString(7));
			
				return usermodule;
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
		System.out.println(result + " is inserted !!");
		ps.close();
		con.close();
	}
	
	
	
    public void update (UserModule UserModule) throws ClassNotFoundException, SQLException {
    	
    	String update="update users set user_name=?, user_age=?, user_contact=?, user_gender=?, user_password=? where user_email='"+UserModule.getUserEmail()+"'";
    	
    	Connection con=ConnectionUtill.connectdb();
		PreparedStatement ps=con.prepareStatement(update);
		
		ps.setString(1,UserModule.getUserName());
		ps.setInt(2,UserModule.getUserAge());
		ps.setLong(3,UserModule.getUserContact());
		ps.setString(4,UserModule.getUserGender());
		ps.setString(5, UserModule.getUserPassword());
		
		int result=ps.executeUpdate();
		System.out.println(result+ " is updated !!");
		ps.close();
		con.close();
    }
	
 
    
}
