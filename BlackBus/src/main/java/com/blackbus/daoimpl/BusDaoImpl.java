package com.blackbus.daoimpl;
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
import com.blackbus.dao.BusDAO;
import com.blackbus.model.Bus;
import com.blackbus.model.Operator;
import com.blackbus.model.User;

public class BusDaoImpl implements BusDAO {

	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm");
	
	public boolean insertBus(Bus busModel) {
		String busInsert = "insert into bus_details (bus_category, from_city, to_city, departure, arrival, seater_fare, total_seat) values (?,?,?,?,?,?,?)";
		int result = 0 ;
		try {
			Connection con = ConnectionUtill.connectdb();
			PreparedStatement pstatement = con.prepareStatement(busInsert);
			
			pstatement.setString(1, busModel.getBusCategory());
			pstatement.setString(2, busModel.getFromCity());
			pstatement.setString(3, busModel.getToCity());
			Timestamp depDateTime = Timestamp.valueOf(busModel.getDeparture());
			pstatement.setTimestamp(4,  depDateTime);
			Timestamp arrDateTime = Timestamp.valueOf(busModel.getArrival());
			pstatement.setTimestamp(5,  arrDateTime);
			pstatement.setInt(6, busModel.getSeaterFare());
			pstatement.setInt(7, busModel.getTotalseat());

			result = pstatement.executeUpdate();

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result>0;
	}

	public boolean deleteBus(int busId) {

		String busDelete = "delete from bus_details where bus_id=?";
		int result=0;
		Connection con;
		try {
			con = ConnectionUtill.connectdb();
			PreparedStatement pstatement = con.prepareStatement(busDelete);

			pstatement.setInt(1, busId);
			result = pstatement.executeUpdate();
			
			con.close();
			pstatement.close();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result>0;
	}
	
	
	public boolean updateBus(Bus busModel) {
		
            String busUpdate="update bus_details set bus_no=?,operator_id=?,bus_category=?, from_city=?, to_city=?, departure=?, arrival=?, seater_fare=?, total_seat=?,seat_status=? where bus_id='"+busModel.getBusId()+"'";
            int result=0;
    	    Connection con;
    	    try {
			con = ConnectionUtill.connectdb();
			PreparedStatement pstatement=con.prepareStatement(busUpdate);
			
			pstatement.setInt(1, busModel.getBusNo());
			pstatement.setInt(2, busModel.getOperatorId());
			pstatement.setString(3, busModel.getBusCategory());
			pstatement.setString(4, busModel.getFromCity());
			pstatement.setString(5, busModel.getToCity());
			Timestamp depDateTime = Timestamp.valueOf(busModel.getDeparture());
			pstatement.setTimestamp(6,  depDateTime);
			Timestamp arrDateTime = Timestamp.valueOf(busModel.getArrival());
			pstatement.setTimestamp(7,  arrDateTime);
			pstatement.setInt(8, busModel.getSeaterFare());
			pstatement.setInt(9, busModel.getTotalseat());
			pstatement.setString(10, busModel.getSeatStatus());
			
			result=pstatement.executeUpdate();
			
			con.close();
			pstatement.close();
			}
    	    catch (ClassNotFoundException e) {
    	    	System.out.println(e.getMessage());
    		} catch (SQLException e) {
    			System.out.println(e.getMessage());
    		}
    	    return result>0;
	}
	
	
	
	
	

	//for admin use to view all busses:
	 public ResultSet viewAllBus(){
	    	
	    	String busView="select * from bus_details";
	    	
	    	Connection con;
	    	ResultSet rs=null;
//	    	List<Bus> busList=new ArrayList<Bus>();
			try {
				con = ConnectionUtill.connectdb();
				PreparedStatement pstatement=con.prepareStatement(busView);
				rs=pstatement.executeQuery();
				
//				while(rs.next()) {
//					
//					Bus busModel=new Bus(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getTimestamp(6).toLocalDateTime(),rs.getTimestamp(7).toLocalDateTime(),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getString(11));
//					busList.add(busModel);
//				}
//				con.close();
//				pstatement.close();
				return rs;
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
			return rs;
			
	    }
	 
	 
	 
	 
	 //for users use to filter the bus according to date and location:
		public ResultSet searchhBus(LocalDate givenDepartureDate,String fromLocation,String toLocation) 
		 {
				String findBus="select * from bus_details where to_char(departure,'yyyy-mm-dd')='"+givenDepartureDate+"' and from_city='"+fromLocation+"' and to_city='"+toLocation+"'";
				Connection con=null;
				Statement statement=null;
				Bus busModel;
				ResultSet rs=null;
				//List<Bus> busFilterList=new ArrayList<Bus>();
				try {
					con=ConnectionUtill.connectdb();
					statement =con.createStatement();
					rs=statement.executeQuery(findBus);
//					while(rs.next()) {					
//						busModel=new Bus(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getTimestamp(6).toLocalDateTime(),rs.getTimestamp(7).toLocalDateTime(),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getString(11));
//						busFilterList.add(busModel);
//						busModel.toString();
//					System.out.println("busIdINRS"+rs.getInt(1));
//					}
					return rs;
				} catch (ClassNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}	
				return rs;
		    }
		
		
	 
		public void updateSeatCount(Bus busModel) {
			
			String updateSeat="update bus_details set total_seat=? where bus_id=?";
			 Connection con;
		    	
	    	    try {
				con = ConnectionUtill.connectdb();
				PreparedStatement pstatement=con.prepareStatement(updateSeat);
				
				pstatement.setInt(1, busModel.getTotalseat());
				pstatement.setInt(2, busModel.getBusId());
				pstatement.executeUpdate();
				con.close();
				pstatement.close();
				}
	    	    catch (ClassNotFoundException e) {
	    			System.out.println(e.getMessage());
	    		} catch (SQLException e) {
	    			System.out.println(e.getMessage());
	    		}
		}
		
	 
	 public Bus findBusDetailsUsingID(int busId)  {
		 String getBus ="select * from bus_details where bus_id=?";
			Connection	 con = null;
			PreparedStatement pstatement=null;
			Bus busModel = null;
			
			 try {
				 
				con = ConnectionUtill.connectdb();
				pstatement=con.prepareStatement(getBus);
				pstatement.setInt(1, busId);
				ResultSet rs = pstatement.executeQuery();
				
				 if(rs.next()) {
					 busModel=new Bus(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getTimestamp(7).toLocalDateTime(),rs.getTimestamp(8).toLocalDateTime(),rs.getInt(9),rs.getInt(10),rs.getString(11));
				 
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

	@Override
	public boolean deleteBus(Bus busModel) {
		// TODO Auto-generated method stub
		return false;
	}


}
