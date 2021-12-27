package com.blackbus.controller;

import java.io.IOException;

import com.blackbus.Dao.AdminDao;
import com.blackbus.Dao.UserDao;
import com.blackbus.module.AdminModel;
import com.blackbus.module.UserModel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginWay")
public class LoginController extends HttpServlet{

	public void service(HttpServletRequest req,HttpServletResponse res) {
		
		String loginId=req.getParameter("name");
		String password=req.getParameter("password");
		
		System.out.println(loginId);
		System.out.println(password);
		AdminDao adminDao=new AdminDao();
		UserDao userDao=new UserDao();
		AdminModel adminModel;
		UserModel userModel=new UserModel();
		
		//admin Login
		if(loginId.endsWith("admin@gmail.com")) {
			boolean adminCheckFlag;
			adminCheckFlag=adminDao.checkadmin(loginId);
			if(adminCheckFlag) {
				adminModel=adminDao.adminLogin(loginId);
				if(adminModel.getAdminPassword().equals(password)) {
					try {
						res.sendRedirect("adminhome.jsp");
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
				}
			}
					
		}
		//userLogin
		else {
			boolean userCheckFlag;
			long userId=Long.parseLong(loginId);
			userCheckFlag=userDao.checkUser(userId);
			if(userCheckFlag) {
				userModel=userDao.loginUser(userId);
				if(userModel.getUserPassword().equals(password)) {
					try {
						res.sendRedirect("UserHome.jsp");
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
				}
					
				
			}
		}
	}
}
