package com.blackbus.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackbus.daoimpl.BusDaoImpl;

@WebServlet("/updateBusPage")
public class DeleteBusController extends HttpServlet  {
		
		BusDaoImpl busDao=new BusDaoImpl();
		
		public void service(HttpServletRequest req,HttpServletResponse res) {
			System.out.println("hei");
			
			int busId=Integer.parseInt(req.getParameter("busId"));
			boolean busDeleteFlag=busDao.deleteBus(busId);
			
			if(busDeleteFlag) {
				try {
					req.getRequestDispatcher("BusList.jsp").forward(req,res);
					
				} catch (ServletException e) {
					System.out.println(e.getMessage());
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
			
		}
}