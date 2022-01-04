package com.blackbus.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blackbus.daoimpl.OperatorDaoImpl;
import com.blackbus.daoimpl.UserDaoImpl;
import com.blackbus.model.Operator;
import com.blackbus.model.User;

@WebServlet("/profileupdateform")
public class UpdateUserProfileController extends HttpServlet {
	
	UserDaoImpl userDao=new UserDaoImpl();
	
	public void service(HttpServletRequest req,HttpServletResponse res) {
		HttpSession session=req.getSession();
		
		
		User user=(User) session.getAttribute("userModel");	
		int userId= user.getUserId();
		String userName=req.getParameter("userName");
		String userEmail=req.getParameter("emailId");
		long userContact=Long.parseLong(req.getParameter("mobile"));
		String userPassword=req.getParameter("password");
		LocalDate userDOB=LocalDate.parse(req.getParameter("dob"));
		String userGender=req.getParameter("gender");
		User userModel= new User(userId,userName,userDOB,
				userEmail, userContact,userGender, userPassword,0);
		boolean userUpdateFlag=userDao.updateUser(userModel);
		
		if(userUpdateFlag) {
			try {
				req.getRequestDispatcher("UserProfile.jsp").forward(req,res);
				
			} catch (ServletException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

