package com.blackbus.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blackbus.daoimpl.BookedTicketsDaoImpl;
import com.blackbus.daoimpl.BusDaoImpl;
import com.blackbus.daoimpl.UserDaoImpl;
import com.blackbus.model.BookedTickets;
import com.blackbus.model.Bus;
import com.blackbus.model.User;

@WebServlet("/bookingPage")
public class BookedTicketsController extends HttpServlet {

public void service(HttpServletRequest req,HttpServletResponse res) {
		
		HttpSession session=req.getSession();
		DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		BusDaoImpl busDao=new BusDaoImpl();
		UserDaoImpl userDao=new UserDaoImpl();
		BookedTicketsDaoImpl bookTicketsDao=new BookedTicketsDaoImpl();
		
		User user1=(User)session.getAttribute("userModel");
		User user=userDao.getUserDetailsById(user1.getUserId());
		
		int currentBusId2=(int) session.getAttribute("currentBusId");
	    Bus busModel=busDao.findBusDetailsUsingID(currentBusId2);

	    
	    String randomNo=req.getParameter("randomnumber");
	    System.out.println(randomNo);
		int ticketCount=Integer.parseInt(req.getParameter("noofseats"));
		int totalPrice=Integer.parseInt(req.getParameter("totalFair"));
		
//		if(user.getUserWallet()>=totalPrice) {
		
		int updateAmountInWallet=user.getUserWallet()-totalPrice;
		User userModel2=new User(user.getUserId(),user.getUserName(),user.getUserDOB(),user.getUserEmail(),user.getUserContact(),
				user.getUserGender(),user.getUserPassword(),updateAmountInWallet);
		
		
		BookedTickets bookTickets=new BookedTickets(0,randomNo,userModel2,busModel,0,busModel.getDeparture(),"",ticketCount,totalPrice,"Success");
		System.out.println("datetime " +busModel.getDeparture());
		
		boolean ticketInsertFlag=bookTicketsDao.insertBookedTickets(bookTickets);
		session.setAttribute("FinalBookTicketsModel", bookTickets);
		session.setAttribute("FinalBusModel", busModel);  
	    session.setAttribute("FinalUserModel", userModel2);
		
		if(ticketInsertFlag) {
			try {
				res.sendRedirect("BookSuccess.jsp");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		
	}
}
