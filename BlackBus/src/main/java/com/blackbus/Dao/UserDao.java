package com.blackbus.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.blackbus.connection.ConnectionUtill;
import com.blackbus.module.AdminModel;
import com.blackbus.module.UserModel;



public class UserDao {
	
		
		 public UserModel loginUser(long contact) throws ClassNotFoundException, SQLException {
			 
			String userLogin="select * from user_details where user_contact='"+contact+"'";
			Connection con=ConnectionUtill.connectdb();
			PreparedStatement ps=con.prepareStatement(userLogin);
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(userLogin);
			
			rs.next() ;
			UserModel userModel=new UserModel(rs.getString(2),rs.getInt(3),rs.getString(4),rs.getLong(5),rs.getString(6),rs.getString(7));
			
				return userModel;
		}
		 
		 
		 public boolean checkUser(long contact) throws ClassNotFoundException, SQLException {
			 
				String userLogin="select * from user_details where user_contact='"+contact+"'";
				Connection con=ConnectionUtill.connectdb();
				PreparedStatement ps=con.prepareStatement(userLogin);
				
				Statement st=con.createStatement();
				int i=st.executeUpdate(userLogin);
				if(i>0) {
					return true;
				}
				else {
					return false;	
				}
				
			}
		
	
	
	public void registrationUser(UserModel userModel) throws ClassNotFoundException, SQLException {
		
		String insertUser="insert into user_details (user_name,user_age,user_email,user_contact,user_gender,user_password) values (?,?,?,?,?,?)";
		Connection con=ConnectionUtill.connectdb();
		PreparedStatement ps=con.prepareStatement(insertUser);
	
		ps.setString(1,userModel.getUserName());
		ps.setInt(2,userModel.getUserAge());
		ps.setString(3, userModel.getUserEmail());
		ps.setLong(4,userModel.getUserContact());
		ps.setString(5,userModel.getUserGender());
		ps.setString(6, userModel.getUserPassword());
	
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
	
	
	
    public void updateUser (UserModel userModel) throws ClassNotFoundException, SQLException {
    	
    	String userUpdate="update user_details set user_name=?, user_age=?, user_gender=?, user_password=? where user_contact='"+userModel.getUserContact()+"'";
    	
    	Connection con=ConnectionUtill.connectdb();
		PreparedStatement ps=con.prepareStatement(userUpdate);
		
		ps.setString(1,userModel.getUserName());
		ps.setInt(2,userModel.getUserAge());
		ps.setString(3,userModel.getUserGender());
		ps.setString(4, userModel.getUserPassword());
		
		ps.executeUpdate();
		System.out.println("for "+userModel.getUserContact()+ "profile is updated !!");
		ps.close();
		con.close();
    }
	
   
	
    public void deleteUser (int userId) throws ClassNotFoundException, SQLException {
		
		String userDelete="delete from user_details where user_id=?";
		
		Connection con=ConnectionUtill.connectdb();
		PreparedStatement ps=con.prepareStatement(userDelete);
		
		ps.setInt(1, userId);
		int result=ps.executeUpdate();
		if(result==1) {
		System.out.println(" Successfully deleted");
		ps.close();
		con.close();		
		}
		else
		{
			System.out.println("please enter correct id");
		}
	}
    
    
    
    public List<UserModel> viewUser(){
    	
    	String userView="select * from user_details";
    	
    	Connection con;
    	List<UserModel> userList=new ArrayList<UserModel>();
		try {
			con = ConnectionUtill.connectdb();
			PreparedStatement ps=con.prepareStatement(userView);
			
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(userView);
			
			while(rs.next()) {
				UserModel userModel=new UserModel(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getLong(5),rs.getString(6),rs.getString(7));
				userList.add(userModel);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return userList;
		
    }
    
    
    
    
    
    
//public class ProductDao {
//		
//		public List<ProductModule> viewProduts()
//		{
//			String viewQuery="select * from products";
//			Connection con=GetConnection.getDBconnect();
//			List<ProductModule> productList=new ArrayList<ProductModule>();
//			try {
//				Statement smt = con.createStatement();
//				ResultSet rs= smt.executeQuery(viewQuery);
//				
//				while(rs.next()) {
//					ProductModule product=new ProductModule(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),
//							rs.getInt(6),rs.getString(7));
//					productList.add(product);				
//				}
//				
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				System.out.println(e.getMessage());
//			}
//		
//			return productList;
//		
//		}
 
    
}
