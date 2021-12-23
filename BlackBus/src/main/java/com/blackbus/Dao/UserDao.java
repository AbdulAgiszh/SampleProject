package com.blackbus.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.blackbus.connection.ConnectionUtill;
import com.blackbus.module.AdminModel;
import com.blackbus.module.OperatorModel;
import com.blackbus.module.UserModel;



public class UserDao {
	
		
		 public UserModel loginUser(long contact) throws ClassNotFoundException, SQLException {
			 
			String userLogin="select * from user_details where user_contact='"+contact+"'";
			Connection con=ConnectionUtill.connectdb();
			PreparedStatement pstatement=con.prepareStatement(userLogin);
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(userLogin);
			
			rs.next() ;
			UserModel userModel=new UserModel(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getLong(5),rs.getString(6),rs.getString(7),rs.getInt(8));
			con.close();
			pstatement.close();
				return userModel;
		}
		 
		 
		 public boolean checkUser(long contact) throws ClassNotFoundException, SQLException {
			 
				String userLogin="select * from user_details where user_contact='"+contact+"'";
				Connection con=ConnectionUtill.connectdb();
				PreparedStatement pstatement=con.prepareStatement(userLogin);
				
				Statement statement=con.createStatement();
				int i=pstatement.executeUpdate(userLogin);
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
		PreparedStatement pstatement=con.prepareStatement(insertUser);
	
		pstatement.setString(1,userModel.getUserName());
		pstatement.setInt(2,userModel.getUserAge());
		pstatement.setString(3, userModel.getUserEmail());
		pstatement.setLong(4,userModel.getUserContact());
		pstatement.setString(5,userModel.getUserGender());
		pstatement.setString(6, userModel.getUserPassword());
	
		int result=pstatement.executeUpdate();
		if(result==1) {
		System.out.println( "Your Have Registered Successfully!!");
		pstatement.close();
		con.close();
		}
		else {
			System.out.println("your record has not registered");
		}
	}
	
	
	
    public void updateUser(UserModel userModel) throws ClassNotFoundException, SQLException {
    	
    	String userUpdate="update user_details set user_name=?, user_age=?, user_gender=?, user_password=? where user_contact='"+userModel.getUserContact()+"'";
    	
    	Connection con=ConnectionUtill.connectdb();
		PreparedStatement pstatement=con.prepareStatement(userUpdate);
		
		pstatement.setString(1,userModel.getUserName());
		pstatement.setInt(2,userModel.getUserAge());
		pstatement.setString(3,userModel.getUserGender());
		pstatement.setString(4, userModel.getUserPassword());
		
		pstatement.executeUpdate();
		System.out.println("for "+userModel.getUserContact()+ "profile is updated !!");
		pstatement.close();
		con.close();
    }
	
   
	
    public void deleteUser (UserModel userModel) throws ClassNotFoundException, SQLException {
		
		String userDelete="delete from user_details where user_id=?";
		
		Connection con=ConnectionUtill.connectdb();
		PreparedStatement pstatement=con.prepareStatement(userDelete);
		
		pstatement.setInt(1, userModel.getUserId());
		int result=pstatement.executeUpdate();
		if(result==1) {
		System.out.println(" Successfully deleted");
		pstatement.close();
		con.close();		
		}
		else
		{
			System.out.println("please enter correct id");
		}
	}
    
    
    
    public List<UserModel> viewUserDetails(){
    	
    	String userView="select * from user_details";
    	
    	Connection con;
    	List<UserModel> userList=new ArrayList<UserModel>();
		try {
			con = ConnectionUtill.connectdb();
			PreparedStatement pstatement=con.prepareStatement(userView);
			
			ResultSet rs=pstatement.executeQuery(userView);
			
			while(rs.next()) {
				UserModel userModel=new UserModel(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getLong(5),rs.getString(6),rs.getString(7),rs.getInt(8));
				userList.add(userModel);
			}
			con.close();
			pstatement.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return userList;
		
    }
    
    
    public boolean updateWallet(int updatedWallet,long userContact) {
    	String wallet="update user_details set user_wallet=? where user_contact=?";
    	
    	Connection con;
    	PreparedStatement pstatement;
    	int result = 0;
    	try {
			con=ConnectionUtill.connectdb();
			pstatement=con.prepareStatement(wallet);
			
			pstatement.setInt(1, updatedWallet);
			pstatement.setLong(2, userContact);
			result=pstatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.getMessage();
		} catch (SQLException e) {
			e.getMessage();
		}
    	return result>0;
    	
    }
    
    
    public UserModel getUserDetailsById(int userId) throws SQLException  {
		
		String getUser ="select * from user_details where user_id=?";
		Connection con = null;
		PreparedStatement pstatement = null;
		UserModel userModel=null;
		
		 try {
			con = ConnectionUtill.connectdb();
			pstatement = con.prepareStatement(getUser);
			 pstatement.setInt(1, userId);
			ResultSet rs = pstatement.executeQuery();
			
			 if (rs.next()) {
				 userModel=new UserModel(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getLong(5),rs.getString(6),rs.getString(7),rs.getInt(8));
				}
			con.close();
			pstatement.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		 return userModel;

	}
    

    
}
