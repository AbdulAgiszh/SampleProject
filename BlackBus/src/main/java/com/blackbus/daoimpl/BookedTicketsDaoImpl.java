package com.blackbus.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.blackbus.connection.ConnectionUtill;
import com.blackbus.dao.BookedTicketsDAO;
import com.blackbus.model.BookedTickets;
import com.blackbus.model.Bus;
import com.blackbus.model.User;

public class BookedTicketsDaoImpl implements BookedTicketsDAO {
	
	BusDaoImpl busDao=new BusDaoImpl();
	UserDaoImpl userDao=new UserDaoImpl();
	//DateTimeFormatter formatDate=DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	
	public boolean insertBookedTickets(User userModel,Bus busModel,BookedTickets bookedTicketsModel) {
		String ticketsInsert = "insert into Booked_tickets (user_id,bus_id,departure_date,ticket_count,seat_category,seat_no,total_price,payment_status) values (?,?,?,?,?,?,?,?)"; 
		
		Connection con;
		int result=0;
		
		try {
			con = ConnectionUtill.connectdb();
			PreparedStatement pstatement=con.prepareStatement(ticketsInsert);
			
			pstatement.setInt(1, userModel.getUserId());
			pstatement.setInt(2, busModel.getBusId());
			pstatement.setDate(3,  java.sql.Date.valueOf(bookedTicketsModel.getDepartureDate()));
			pstatement.setInt(4, bookedTicketsModel.getTicketCount());
			pstatement.setString(5, bookedTicketsModel.getSeatCategory());
			pstatement.setString(6, bookedTicketsModel.getSeatNo());
			pstatement.setInt(7, bookedTicketsModel.getTotalPrice());
			pstatement.setString(8, bookedTicketsModel.getPaymentStatus());
			result=pstatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.getMessage();
		} catch (SQLException e) {
			e.getMessage();
		}
		return result>0;
	}
		
		
//
//	public List<BookedTickets> listBookingTickets(){
//		String bookingList="select "
//	}
//	
	
	
	public int findBookingId(User userModel, BookedTickets bookedTicketsModel) {
		
		String bookingIdFinder="select booking_id from booked_tickets where user_id='"+userModel.getUserId()+"' and to_char(departure_date,'yyyy-mm-dd')='"+bookedTicketsModel.getDepartureDate()+"' and seat_no='"+bookedTicketsModel.getSeatNo()+"' ";
		Connection con;
		PreparedStatement pstatement;
		int bookingId = 0;
		try {
			con=ConnectionUtill.connectdb();
			pstatement=con.prepareStatement(bookingIdFinder);
			ResultSet rs=pstatement.executeQuery();
			if(rs.next()) {
				bookingId=rs.getInt(1);
			}
			
		} catch (ClassNotFoundException e) {
			e.getMessage();
		} catch (SQLException e) {
			e.getMessage();
		}
		return bookingId;
		
	}

	
	//to show all booking for particular user
	public List<BookedTickets> getBookingDetailsForCurrentUser(User userModel) {
		String query="select * from booked_tickets where user_id='"+userModel.getUserId()+"'";
		
		Connection con;
		PreparedStatement pstatement;
		ResultSet rs;
		Bus busModel=null;
		User userModel1=null;
		List<BookedTickets> bookingList=new ArrayList<BookedTickets>();
		
		try {
			con=ConnectionUtill.connectdb();
			pstatement=con.prepareStatement(query);
			rs=pstatement.executeQuery();
			
			while(rs.next()) {
				busModel=busDao.findBusDetailsUsingID(rs.getInt(3));
				userModel1=userDao.getUserDetailsById(userModel.getUserId());
				BookedTickets bookedTicketsModel=new BookedTickets(rs.getInt(1),userModel1,busModel,rs.getDate(4).toLocalDate(),rs.getDate(5).toLocalDate(),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getString(11));
				bookingList.add(bookedTicketsModel);
				
			}	
			
		} catch (ClassNotFoundException e) {
			e.getMessage();
		} catch (SQLException e) {
			e.getMessage();
		}
		
		return bookingList;
	}
	
	
	//user for invoice to collect booked tickets full details by using booking id or booking number
	public BookedTickets findBookedTicketsDetails(int bookingId) {
		String findTicketDetails="select * from booked_tickets where booking_id='"+bookingId+"'";
		
		Connection con;
		PreparedStatement pstatement;
		ResultSet rs;
		Bus busModel=null;
		User userModel=null;
		BookedTickets bookedTicketsModel=null;
		try {
			con=ConnectionUtill.connectdb();
			pstatement=con.prepareStatement(findTicketDetails);
			rs=pstatement.executeQuery();
			
			if(rs.next()) {
				busModel=busDao.findBusDetailsUsingID(rs.getInt(3));
				userModel=userDao.getUserDetailsById(rs.getInt(2));
				bookedTicketsModel=new BookedTickets(rs.getInt(1),userModel,busModel,rs.getDate(4).toLocalDate(),rs.getDate(5).toLocalDate(),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getString(11));
				
			}	
			
		} catch (ClassNotFoundException e) {
			e.getMessage();
		} catch (SQLException e) {
			e.getMessage();
		}
		
		return bookedTicketsModel;
	}
	
	
	
	public boolean cancelTicket(User userModel,BookedTickets bookedTicketsModel) {
		String ticketCancel="update booked_tickets set booking_status='Cancelled',payment_status='refunded' where user_id='"+userModel.getUserId()+"' and to_char(departure_date,'yyyy-mm-dd')='"+bookedTicketsModel.getDepartureDate()+"' and seat_no='"+bookedTicketsModel.getSeatNo()+"' ";
		int result = 0;
		try {
			Connection con=ConnectionUtill.connectdb();
			PreparedStatement pstatement=con.prepareStatement(ticketCancel);
			result=pstatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.getMessage();
		} catch (SQLException e) {
			e.getMessage();
			System.out.println("invalid Ticket number");
		}
		return result>0;
		
	}
	
	
	public ResultSet showlistAdmin() {
		
        String showQuery="select * from booked_tickets";
		
		Connection con;
		PreparedStatement pstatement;
		ResultSet rs = null;
		Bus busModel=null;
		User userModel=null;
		List<BookedTickets> bookingListAdmin=new ArrayList<BookedTickets>();
		
		try {
			con=ConnectionUtill.connectdb();
			pstatement=con.prepareStatement(showQuery);
			rs=pstatement.executeQuery();
			
//			while(rs.next()) { 
//				busModel=busDao.findBusDetailsUsingID(rs.getInt(3));
//				userModel=userDao.getUserDetailsById(rs.getInt(2));
//				BookedTickets bookedTicketsModel=new BookedTickets(rs.getInt(1),userModel,busModel,rs.getDate(4).toLocalDate(),rs.getDate(5).toLocalDate(),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getString(11));
//				bookingListAdmin.add(bookedTicketsModel);
//			
//			}	
			return rs;
		} catch (ClassNotFoundException e) {
			e.getMessage();
		} catch (SQLException e) {
			e.getMessage();
		}
		
		return rs;
	}
	
	
	}
	
	
	

