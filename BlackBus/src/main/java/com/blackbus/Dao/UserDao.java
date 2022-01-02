package com.blackbus.dao;

import java.sql.ResultSet;
import java.util.List;

import com.blackbus.model.User;

public interface UserDAO {

	public User loginUser(long contact) ;
	
	public boolean checkUser(long contact);
	
	public boolean registrationUser(User userModel) ;
	
	public void updateUser(User userModel);
	
	public void deleteUser (User userModel) ;
	
	public ResultSet viewUserDetails();
	
	 public boolean updateWallet(int updatedWallet,long userContact) ;
	 
	 public User getUserDetailsById(int userId) ;
	 
	 
	
}
