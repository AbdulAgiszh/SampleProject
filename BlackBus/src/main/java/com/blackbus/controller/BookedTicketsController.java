package com.blackbus.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blackbus.daoimpl.BookedTicketsDaoImpl;
import com.blackbus.daoimpl.BusDaoImpl;
import com.blackbus.daoimpl.UserDaoImpl;
import com.blackbus.model.BookedTickets;
import com.blackbus.model.Bus;
import com.blackbus.model.User;

public class BookedTicketsController {

public void service(HttpServletRequest req,HttpServletResponse res) {
		
		HttpSession session=req.getSession();
	
		BusDaoImpl busDao=new BusDaoImpl();
		UserDaoImpl userDao=new UserDaoImpl();
		BookedTicketsDaoImpl bookTicketsDao=new BookedTicketsDaoImpl();
		User userModel=(User)session.getAttribute("userModel");
		String currentBusId=(String) session.getAttribute("currentBusId");
		
	    Bus bus=busDao.findBusDetailsUsingID(Integer.parseInt(currentBusId));
	       
	    User user=userDao.getUserDetailsById(userModel.getUserId());
	       
	  //LocalDate departureDate=LocalDate.parse(req.getParameter("departureDate"));
	  //String seatNo=req.getParameter("seatNo");
		int ticketCount=Integer.parseInt(req.getParameter("noofseats"));
		int totalPrice=Integer.parseInt(req.getParameter("totalFair"));
		
		BookedTickets bookTickets=new BookedTickets(0,user,bus,0,bus.getDeparture().toLocalDate(),"",ticketCount,totalPrice,"Success");
		bookTicketsDao.insertBookedTickets(user, bus, bookTickets);
		
		
		
	}
}
