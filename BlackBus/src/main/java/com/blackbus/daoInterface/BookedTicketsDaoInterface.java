package com.blackbus.daoInterface;

import java.util.List;

import com.blackbus.module.BookedTicketsModel;
import com.blackbus.module.BusModel;
import com.blackbus.module.UserModel;

public interface BookedTicketsDaoInterface {

	public boolean insertBookedTickets(UserModel userModel,BusModel busModel,BookedTicketsModel bookedTicketsModel);
	
	public int findBookingId(UserModel userModel, BookedTicketsModel bookedTicketsModel);
	
	public List<BookedTicketsModel> getBookingDetailsForCurrentUser(UserModel userModel);
	
	public BookedTicketsModel findBookedTicketsDetails(int bookingId);
	
	public boolean cancelTicket(UserModel userModel,BookedTicketsModel bookedTicketsModel);
	
	public List<BookedTicketsModel> showlistAdmin();
	
	
}
