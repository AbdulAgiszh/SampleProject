package com.blackbus.controller;

import java.io.IOException;

import com.blackbus.Dao.AdminDao;
import com.blackbus.Dao.UserDao;
import com.blackbus.module.AdminModel;
import com.blackbus.module.UserModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginWay")
public class LoginController extends HttpServlet{

	public void service(HttpServletRequest req,HttpServletResponse res) {
		
		HttpSession session=req.getSession();
		
		String loginId=req.getParameter("name");
		String password=req.getParameter("password");
		
//		System.out.println(loginId);
//		System.out.println(password);
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
					if(userModel != null) {
						try {
							res.sendRedirect("UserHome.jsp");
						} catch (IOException e) {
							System.out.println(e.getMessage());
						}
						
					}
					else {
						session.setAttribute("erroruserpass", "password is incorrect");
						try {
							req.getRequestDispatcher("Login.jsp").forward(req,res);
						} catch (ServletException e) {
							System.out.println(e.getMessage());
						} catch (IOException e) {
							System.out.println(e.getMessage());
						}
				}
			}
			else {
				session.setAttribute("erroruserid", "user name mismatch");
				try {
					req.getRequestDispatcher("Login.jsp").forward(req,res);
				} catch (ServletException e) {
					System.out.println(e.getMessage());
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
	}
}


//HttpSession session=req.getSession();
//session.setAttribute("error", "user name and password mismatch");
//req.getRequestDispatcher("login.jsp").forward(req,res);
//<% String error=(String)session.getAttribute("error");
//if(error!=null) {%>
//<p ><%=session.getAttribute("error") %></p>
//<%} session.removeAttribute("error"); %>

