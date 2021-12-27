package com.blackbus.controller;

import com.blackbus.Dao.UserDao;
import com.blackbus.module.UserModel;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class UserController extends HttpServlet{

	public void service(HttpServletRequest req,HttpServletResponse res) {
	
		String name=req.getParameter("name");
		System.out.println(name);
		String email=req.getParameter("emailId");
		System.out.println(email);
		long mobile=Long.parseLong(req.getParameter("mobile"));
		System.out.println(mobile);
		String password=req.getParameter("password");
		System.out.println(password);
		int age=Integer.parseInt(req.getParameter("age"));
		System.out.println(age);
		String gender=req.getParameter("gender");
		System.out.println(gender);
		UserModel userModel=new UserModel(name,age,email,mobile,gender,password);
		UserDao userDao=new UserDao();
		
		userDao.registrationUser(userModel);
	}
	
}
