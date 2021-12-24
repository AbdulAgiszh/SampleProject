package com.blackbus.daoInterface;

import java.util.List;

import com.blackbus.module.AdminModel;

public interface AdminDaoInterface {

	public AdminModel adminLogin(String contact) ;
	
	public boolean checkadmin(String contact);
	
	public void updateAdmin (AdminModel AdminModel);
	
	public List<AdminModel> viewAdmin();
	
	
}
