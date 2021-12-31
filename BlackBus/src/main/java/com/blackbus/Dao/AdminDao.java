package com.blackbus.dao;

import java.util.List;

import com.blackbus.model.Admin;

public interface AdminDAO {

	public Admin adminLogin(String contact) ;
	
	public boolean checkadmin(String contact);
	
	public void updateAdmin (Admin AdminModel);
	
	public List<Admin> viewAdmin();
	
	
}
