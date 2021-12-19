package com.blackbus.Dao;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.blackbus.connection.ConnectionUtill;
import com.blackbus.module.BusModel;
import com.blackbus.module.UserModel;

public class BusDao {

	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm");
	
	public void insertBus(BusModel BusModel) {
		String busInsert = "insert into bus_details (bus_catagory, from_city, to_city, departure, arrival,sleeper_fare, seater_fare, total_seat) values (?,?,?,?,?,?,?,?)";
		try {
			Connection con = ConnectionUtill.connectdb();
			PreparedStatement pstatement = con.prepareStatement(busInsert);
			
			
			pstatement.setString(1, BusModel.getBusCategory());
			pstatement.setString(2, BusModel.getFromCity());
			pstatement.setString(3, BusModel.getToCity());
			Timestamp depDateTime = Timestamp.valueOf(BusModel.getDeparture());
			pstatement.setTimestamp(4,  depDateTime);
			Timestamp arrDateTime = Timestamp.valueOf(BusModel.getDeparture());
			pstatement.setTimestamp(5,  arrDateTime);
			pstatement.setInt(6, BusModel.getSleeperFare());
			pstatement.setInt(7, BusModel.getSeaterFare());
			pstatement.setInt(8, BusModel.getTotalseat());

			int result = pstatement.executeUpdate();
			if (result == 1) {
				System.out.println("Bus details added successfully");
				pstatement.close();
				con.close();
			} else {
				System.out.println("Failed to add the bus details");
			}

		} catch (ClassNotFoundException e) {
			e.getMessage();
		} catch (SQLException e) {
			e.getMessage();
		}
	}

//	public void deleteBus(BusModel BusModule) {
//
//		String busDelete = "delete from bus_details where bus_id=?";
//
//		Connection con;
//		try {
//			con = ConnectionUtill.connectdb();
//			PreparedStatement pstatement = con.prepareStatement(busDelete);
//
//			pstatement.setInt(1, BusModule.getBusId());
//			int result = pstatement.executeUpdate();
//			if (result == 1) {
//				System.out.println("Successfully deleted the bus");
//				pstatement.close();
//				con.close();
//			} else {
//				System.out.println("please enter correct id");
//			}
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}
//	
//	
//	public void updateBus(BusModel BusModule) {
//		
//            String busUpdate="update bus_details set bus_category=?, from_city=?, to_city=?, departure=?, arrival=?, total_seat=?, where bus_id='"+BusModule.getBusId()+"'";
//    	
//    	    Connection con;
//    	
//    	    try {
//			con = ConnectionUtill.connectdb();
//			PreparedStatement pstatement=con.prepareStatement(busUpdate);
//			
//			pstatement.setString(1, BusModule.getBusCategory());
//			pstatement.setString(2, BusModule.getFromCity());
//			pstatement.setString(3, BusModule.getToCity());
//			pstatement.setDate(4, );
//			pstatement.setTime(5, );
//			pstatement.setInt(6, BusModule.getTotalseat());
//			
//			int result=pstatement.executeUpdate();
//			if(result==1) {
//			System.out.println("for "+BusModule.getBusId()+ "profile is updated !!");
//			pstatement.close();
//			con.close();
//			}
//			else {
//				System.out.println("Bus updation failed");
//			}
//			}
//    	    catch (ClassNotFoundException e) {
//    			e.printStackTrace();
//    		} catch (SQLException e) {
//    			e.printStackTrace();
//    		}
//	}
//	
//	
//	
//	
//	
//public List<BusModel> viewBus(){
//    	
//    	String busView="select * from bus_details";
//    	
//    	Connection con;
//    	List<BusModel> busList=new ArrayList<BusModel>();
//		try {
//			con = ConnectionUtill.connectdb();
//			PreparedStatement ps=con.prepareStatement(busView);
//			
//			Statement statement=con.createStatement();
//			ResultSet rs=statement.executeQuery(busView);
//			
//			while(rs.next()) {
//				BusModel busmodel=new BusModel(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getLong(5),rs.getString(6),rs.getString(7));
//				busList.add(busmodel);
//			}
//			
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		return busList;
//		
//    }
//	
//	
//	
//	
	
}
