package com.blackbus.dao;

import java.sql.ResultSet;
import java.util.List;

import com.blackbus.model.BookedTickets;
import com.blackbus.model.Bus;
import com.blackbus.model.User;

public interface BookedTicketsDAO {

	public boolean insertBookedTickets(User userModel,Bus busModel,BookedTickets bookedTicketsModel);
	
	public int findBookingId(User userModel, BookedTickets bookedTicketsModel);
	
	public List<BookedTickets> getBookingDetailsForCurrentUser(User userModel);
	
	public BookedTickets findBookedTicketsDetails(int bookingId);
	
	public boolean cancelTicket(User userModel,BookedTickets bookedTicketsModel);
	
	public ResultSet showlistAdmin();
	
	
}
