package com.blackbus.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.blackbus.connection.ConnectionUtill;
import com.blackbus.module.BookedTicketsModel;
import com.blackbus.module.BusModel;
import com.blackbus.module.UserModel;

public class BookedTicketsDao {
	
	BusDao busDao=new BusDao();
	UserDao userDao=new UserDao();
	public boolean insertBookedTickets(UserModel userModel,BusModel busModel,BookedTicketsModel bookedTicketsModel)
	{
		String ticketsInsert = "insert into Booked_tickets (user_id,bus_id,ticket_count,seat_no,total_price) values (?,?,?,?,?)"; 
		
		Connection con;
		int result=0;
		
		try {
			con = ConnectionUtill.connectdb();
			PreparedStatement pstatement=con.prepareStatement(ticketsInsert);
			
			pstatement.setInt(1, userModel.getUserId());
			pstatement.setInt(2, busModel.getBusId());
			pstatement.setInt(3, bookedTicketsModel.getTicketCount());
			pstatement.setString(4, bookedTicketsModel.getSeatNo());
			pstatement.setInt(5, bookedTicketsModel.getTotalPrice());
			
			result=pstatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.getMessage();
		} catch (SQLException e) {
			e.getMessage();
		}
		return result>0;
	}
		
		
	
//	
//	public void userInvoice(UserModel userModel,BusModel busModel,BookedTicketsModel bookedTicketModel) {
//		System.out.println("Name : "+ userModel.getUserName());
//		System.out.println("");
//	}
//		

		
	
	
	
	public List<BusModel> searchhBus(LocalDate givenDepartureDate,String fromLocation,String toLocation) 
	 {
			String findBus="select * from bus_details where to_char(departure,'yyyy-mm-dd')='"+givenDepartureDate+"' and from_city='"+fromLocation+"' and to_city='"+toLocation+"'";
			Connection con=null;
			Statement statement=null;
			BusModel busModel;
			List<BusModel> busFilterList=new ArrayList<BusModel>();
			
			try {
				con=ConnectionUtill.connectdb();
				statement =con.createStatement();
				ResultSet rs=statement.executeQuery(findBus);
				while(rs.next()) {					
					busModel=new BusModel(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getTimestamp(6).toLocalDateTime(),rs.getTimestamp(7).toLocalDateTime(),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getString(11));
					busFilterList.add(busModel);
//					busModel.toString();
				}
			} catch (ClassNotFoundException e) {
				e.getMessage();
			} catch (SQLException e) {
				e.getMessage();
			}	
			return busFilterList;
	    }
	
//	public BookedTicketsModel findBookedTicketsDetails(int bookingId) {
//		String detailsBooked="select * from booked_tickets where booking_id='"+bookingId+"'";
//		
//		Connection con;
//		PreparedStatement pstatement;
//		BookedTicketsModel bookedTicketsModel1=null;
//		BookedTicketsModel bookedTicketsModel = 0;
//		try {
//			con=ConnectionUtill.connectdb();
//			pstatement=con.prepareStatement(detailsBooked);
//			ResultSet rs=pstatement.executeQuery();
//			if(rs.next()) {
//				bookedTicketsModel= new BookedTicketsModel
//			}
//		} catch (ClassNotFoundException e) {
//			e.getMessage();
//		} catch (SQLException e) {
//			e.getMessage();
//		}
//		return bookedTicketsModel;
//	}
	
	public int findBookingId(UserModel userModel) {
		String bookingIdFinder="select booking_id from booked_tickets where user_id='"+userModel.getUserId()+"'";
		Connection con;
		PreparedStatement pstatement;
		BookedTicketsModel bookedTicketsModel1=null;
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

	
	public List<BookedTicketsModel> getBookingModel(UserModel userModel) {
		String query="select * from booked_tickets where user_id='"+userModel.getUserId()+"'";
		
		Connection con;
		PreparedStatement pstatement;
		ResultSet rs;
		BusModel busModel=null;
		UserModel userModel1=null;
		List<BookedTicketsModel> bookingList=new ArrayList<BookedTicketsModel>();
		
		try {
			con=ConnectionUtill.connectdb();
			pstatement=con.prepareStatement(query);
			rs=pstatement.executeQuery();
			
			while(rs.next()) {
				busModel=busDao.getBusById(rs.getInt(3));
				userModel1=userDao.getUserById(userModel.getUserId());
				BookedTicketsModel bookedTicketsModel=new BookedTicketsModel(userModel1,busModel,rs.getDate(4).toLocalDate(),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getInt(8));
				bookingList.add(bookedTicketsModel);
				
			}	
			
		} catch (ClassNotFoundException e) {
			e.getMessage();
		} catch (SQLException e) {
			e.getMessage();
		}
		
		return bookingList;
	}
	
	
	
	public BookedTicketsModel findBookedTicketsDetails(UserModel userModel) {
		String query="select * from booked_tickets where user_id='"+userModel.getUserId()+"'";
		
		Connection con;
		PreparedStatement pstatement;
		ResultSet rs;
		BusModel busModel=null;
		UserModel userModel1=null;
		BookedTicketsModel bookedTicketsModel=null;
		try {
			con=ConnectionUtill.connectdb();
			pstatement=con.prepareStatement(query);
			rs=pstatement.executeQuery();
			
			if(rs.next()) {
				busModel=busDao.getBusById(rs.getInt(3));
				userModel1=userDao.getUserById(userModel.getUserId());
				bookedTicketsModel=new BookedTicketsModel(userModel1,busModel,rs.getDate(4).toLocalDate(),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getInt(8));
				
			}	
			
		} catch (ClassNotFoundException e) {
			e.getMessage();
		} catch (SQLException e) {
			e.getMessage();
		}
		
		return bookedTicketsModel;
	}
	
	//public class ProductDao {
//	
//	public List<ProductModule> viewProduts()
//	{
//		String viewQuery="select * from products";
//		Connection con=GetConnection.getDBconnect();
//		List<ProductModule> productList=new ArrayList<ProductModule>();
//		try {
//			Statement smt = con.createStatement();
//			ResultSet rs= smt.executeQuery(viewQuery);
//			
//			while(rs.next()) {
//				ProductModule product=new ProductModule(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),
//						rs.getInt(6),rs.getString(7));
//				productList.add(product);				
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
//	
//		return productList;
//	
//	}
}
