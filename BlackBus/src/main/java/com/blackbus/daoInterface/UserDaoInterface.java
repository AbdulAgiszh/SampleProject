package com.blackbus.daoInterface;

import java.sql.ResultSet;
import java.util.List;

import com.blackbus.module.UserModel;

public interface UserDaoInterface {

	public UserModel loginUser(long contact) ;
	
	public boolean checkUser(long contact);
	
	public void registrationUser(UserModel userModel) ;
	
	public void updateUser(UserModel userModel);
	
	public void deleteUser (UserModel userModel) ;
	
	public ResultSet viewUserDetails();
	
	 public boolean updateWallet(int updatedWallet,long userContact) ;
	 
	 public UserModel getUserDetailsById(int userId) ;
	 
	 
	
}
