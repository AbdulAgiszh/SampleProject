package com.blackbus.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.blackbus.connection.ConnectionUtill;
import com.blackbus.module.BusModule;

public class BusDao {

	public void insertBus(BusModule BusModule) {
		String insertbus="insert into buses (BUS_NAME,BUS_FEATURES,BUS_CATEGORY, DEPARTURE_DATE,FROM_CITY,TO_CITY,DEPARTURE_TIME,ARRIVAL_TIME,TOTAL_SEAT,PRICE) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			Connection con=ConnectionUtill.connectdb();
			PreparedStatement pstatement=con.prepareStatement(insertbus);
			
			pstatement.setString(1, BusModule.getBusName());
			pstatement.setString(2, BusModule.getBusFeatures());
			pstatement.setString(3, BusModule.getBusCategory());
			pstatement.setDate(4, java.sql.Date.valueOf(BusModule.getDeparturedate()));
			pstatement.setString(5, BusModule.getFromCity());
			pstatement.setString(6, BusModule.getToCity());
			pstatement.setTime(7, java.sql.Time.valueOf(BusModule.getDeparturetime()));
			pstatement.setTime(8, java.sql.Time.valueOf(BusModule.getArrivaltime()));
			pstatement.setInt(9, BusModule.getTotalSeat());
			pstatement.setInt(10, BusModule.getPrice());
			
			int result=pstatement.executeUpdate();
			if(result==1) {
				System.out.println("Bus details added successfully");
				pstatement.close();
				con.close();
			}
			else {
				System.out.println("Failed to add the bus details");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void deleteBus() {
		
		String deletebus="delete from bus_details where bus_id=?";
	}
}
