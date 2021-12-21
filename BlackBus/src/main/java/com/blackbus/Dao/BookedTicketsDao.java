package com.blackbus.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.blackbus.connection.ConnectionUtill;
import com.blackbus.module.BookedTicketsModel;
import com.blackbus.module.BusModel;
import com.blackbus.module.UserModel;

public class BookedTicketsDao {
	
	public void insertBookedTickets(UserModel userModel,BusModel busModel)
	{
//		String ticketsInsert = "insert into Booked_tickets (userModel.) values (?,?,?,?,?,?,?,?,?)";
//		try {
//			Connection con = ConnectionUtill.connectdb();
//			PreparedStatement pstatement = con.prepareStatement(busInsert);
//			
//			pstatement.setInt(1, BusModel.getoperatorId());
//			pstatement.setString(2, BusModel.getBusCategory());
//			pstatement.setString(3, BusModel.getFromCity());
//			pstatement.setString(4, BusModel.getToCity());
//			Timestamp depDateTime = Timestamp.valueOf(BusModel.getDeparture());
//			pstatement.setTimestamp(5,  depDateTime);
//			Timestamp arrDateTime = Timestamp.valueOf(BusModel.getArrival());
//			pstatement.setTimestamp(6,  arrDateTime);
//			pstatement.setInt(7, BusModel.getSleeperFare());
//			pstatement.setInt(8, BusModel.getSeaterFare());
//			pstatement.setInt(9, BusModel.getTotalseat());
//
//			int result = pstatement.executeUpdate();
//			if (result == 1) {
//				System.out.println("Bus details added successfully");
//				pstatement.close();
//				con.close();
//			} else {
//				System.out.println("Failed to add the bus details");
//			}
//
//		} catch (ClassNotFoundException e) {
//			e.getMessage();
//		} catch (SQLException e) {
//			e.getMessage();
//		}
		
	}
	
	
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
