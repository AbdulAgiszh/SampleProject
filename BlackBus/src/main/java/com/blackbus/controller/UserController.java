package com.blackbus.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackbus.daoimpl.UserDaoImpl;
import com.blackbus.model.User;



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
		User userModel=new User(name,age,email,mobile,gender,password);
		UserDaoImpl userDao=new UserDaoImpl();
		
		userDao.registrationUser(userModel);
	}
	
}
