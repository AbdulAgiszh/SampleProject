package com.blackbus.dao;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

import com.blackbus.model.Bus;

public interface BusDAO {

	public void insertBus(Bus busModel);
	
	public void deleteBus(Bus busModel);
	
	public void updateBus(Bus busModel);
	
	public ResultSet viewAllBus();
	
	public ResultSet searchhBus(LocalDate givenDepartureDate,String fromLocation,String toLocation) ;
	
	public void updateSeatCount(Bus busModel);
	
	public Bus findBusDetailsUsingID(int busId);
	
	
}
