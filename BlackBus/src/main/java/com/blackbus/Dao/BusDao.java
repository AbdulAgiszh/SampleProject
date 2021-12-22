package com.blackbus.Dao;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.blackbus.connection.ConnectionUtill;
import com.blackbus.module.BusModel;
import com.blackbus.module.OperatorModel;
import com.blackbus.module.UserModel;

public class BusDao {

	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm");
	
	public void insertBus(BusModel BusModel) {
		String busInsert = "insert into bus_details (operator_id,bus_category, from_city, to_city, departure, arrival,sleeper_fare, seater_fare, total_seat) values (?,?,?,?,?,?,?,?,?)";
		try {
			Connection con = ConnectionUtill.connectdb();
			PreparedStatement pstatement = con.prepareStatement(busInsert);
			
			pstatement.setInt(1, BusModel.getoperatorId());
			pstatement.setString(2, BusModel.getBusCategory());
			pstatement.setString(3, BusModel.getFromCity());
			pstatement.setString(4, BusModel.getToCity());
			Timestamp depDateTime = Timestamp.valueOf(BusModel.getDeparture());
			pstatement.setTimestamp(5,  depDateTime);
			Timestamp arrDateTime = Timestamp.valueOf(BusModel.getArrival());
			pstatement.setTimestamp(6,  arrDateTime);
			pstatement.setInt(7, BusModel.getSleeperFare());
			pstatement.setInt(8, BusModel.getSeaterFare());
			pstatement.setInt(9, BusModel.getTotalseat());

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

	public void deleteBus(BusModel BusModel) {

		String busDelete = "delete from bus_details where bus_id=?";

		Connection con;
		try {
			con = ConnectionUtill.connectdb();
			PreparedStatement pstatement = con.prepareStatement(busDelete);

			pstatement.setInt(1, BusModel.getBusId());
			int result = pstatement.executeUpdate();
			if (result == 1) {
				System.out.println("Successfully deleted the bus");
				pstatement.close();
				con.close();
			} else {
				System.out.println("please enter correct id");
			}
			con.close();
			pstatement.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	public void updateBus(BusModel BusModel) {
		
            String busUpdate="update bus_details set operator_id=?,bus_category=?, from_city=?, to_city=?, departure=?, arrival=?,sleeper_fare=?, seater_fare=?, total_seat=?,status=? where bus_id='"+BusModel.getBusId()+"'";
    	
    	    Connection con;
    	
    	    try {
			con = ConnectionUtill.connectdb();
			PreparedStatement pstatement=con.prepareStatement(busUpdate);
			
			pstatement.setInt(1, BusModel.getoperatorId());
			pstatement.setString(2, BusModel.getBusCategory());
			pstatement.setString(3, BusModel.getFromCity());
			pstatement.setString(4, BusModel.getToCity());
			Timestamp depDateTime = Timestamp.valueOf(BusModel.getDeparture());
			pstatement.setTimestamp(5,  depDateTime);
			Timestamp arrDateTime = Timestamp.valueOf(BusModel.getArrival());
			pstatement.setTimestamp(6,  arrDateTime);
			pstatement.setInt(7, BusModel.getSleeperFare());
			pstatement.setInt(8, BusModel.getSeaterFare());
			pstatement.setInt(9, BusModel.getTotalseat());
			pstatement.setString(10, BusModel.getStatus());
			
			int result=pstatement.executeUpdate();
			if(result==1) {
			System.out.println("for "+BusModel.getBusId()+ "profile is updated !!");
			pstatement.close();
			con.close();
			}
			else {
				System.out.println("Bus updation failed");
			}
			con.close();
			pstatement.close();
			}
    	    catch (ClassNotFoundException e) {
    			e.printStackTrace();
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
	}
	
	
	
	
	

	
	 public List<BusModel> viewAllBus(){
	    	
	    	String busView="select * from bus_details";
	    	
	    	Connection con;
	    	List<BusModel> busList=new ArrayList<BusModel>();
			try {
				con = ConnectionUtill.connectdb();
				PreparedStatement pstatement=con.prepareStatement(busView);
				
				Statement statement=con.createStatement();
				ResultSet rs=statement.executeQuery(busView);
				
				
				
				while(rs.next()) {
					
					BusModel busModel=new BusModel(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getTimestamp(6).toLocalDateTime(),rs.getTimestamp(7).toLocalDateTime(),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getString(11));
					busList.add(busModel);
				}
				con.close();
				pstatement.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
			return busList;
			
	    }
	 
	 
	 
	 
	 
	 
	 public BusModel getBusById(int busId)  {
		 String getBus ="select * from bus_details where bus_id=?";
			Connection con = null;
			PreparedStatement pstatement=null;
			BusModel busModel = null;
			
			 try {
				 
				con = ConnectionUtill.connectdb();
				pstatement=con.prepareStatement(getBus);
				pstatement.setInt(1, busId);
				ResultSet rs = pstatement.executeQuery();
				
				 if(rs.next()) {
					 busModel=new BusModel(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getTimestamp(6).toLocalDateTime(),rs.getTimestamp(7).toLocalDateTime(),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getString(11));
				 
				 }
				con.close();
				pstatement.close();
			} catch (ClassNotFoundException e) {
				e.getMessage();
				System.out.println("classnot found");
			} catch (SQLException e) {
				e.getMessage();
				System.out.println("sql exception");
			}
			
			 return busModel;
		}

	
	 
//	 rs.getTimestamp(6).toLocalDateTime(),rs.getTimestamp(7).toLocalDateTime(),
	    
	    
//	 select BUS_ID,OPERATOR_ID,BUS_CATEGORY,FROM_CITY,TO_CITY,to_char(DEPARTURE,'dd-mm-yy'),to_char(DEPARTURE,'HH:MI'),to_char(ARRIVAL,'dd-mm-yy'),to_char(ARRIVAL,'HH:MI'),SLEEPER_FARE,SEATER_FARE,TOTAL_SEAT,STATUS 
	
}
