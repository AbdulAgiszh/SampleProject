package com.blackbus.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blackbus.daoimpl.UserDaoImpl;
import com.blackbus.model.BookedTickets;
import com.blackbus.model.User;

public class BookedTicketsController {

public void service(HttpServletRequest req,HttpServletResponse res) {
		
		HttpSession session=req.getSession();
	
		int userId=Integer.parseInt(req.getParameter("userId"));
		int busId=Integer.parseInt(req.getParameter("busId"));
		LocalDate departureDate=LocalDate.parse(req.getParameter("departureDate"));
	  //String seatNo=req.getParameter("seatNo");
		int ticketCount=Integer.parseInt(req.getParameter("ticketCount"));
		int totalPrice=Integer.parseInt(req.getParameter("totalPrice"));
		
		BookedTickets bookTickets=new BookedTickets(0,userId,busId,0,"",departureDate,"",ticketCount,totalPrice,"","Success");
		
		
		
		
	}
}
