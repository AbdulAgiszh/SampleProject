package com.blackbus.dao;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

import com.blackbus.model.Bus;

public interface BusDAO {

	public boolean insertBus(Bus busModel);
	
	public boolean deleteBus(Bus busModel);
	
	public boolean updateBus(Bus busModel);
	
	public ResultSet viewAllBus();
	
	public ResultSet searchhBus(LocalDate givenDepartureDate,String fromLocation,String toLocation) ;
	
	public void updateSeatCount(Bus busModel);
	
	public Bus findBusDetailsUsingID(int busId);
	
	
}
