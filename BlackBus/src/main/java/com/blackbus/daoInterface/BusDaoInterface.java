package com.blackbus.daoInterface;

import java.time.LocalDate;
import java.util.List;

import com.blackbus.module.BusModel;

public interface BusDaoInterface {

	public void insertBus(BusModel BusModel);
	
	public void deleteBus(BusModel BusModel);
	
	public void updateBus(BusModel BusModel);
	
	public List<BusModel> viewAllBus();
	
	public List<BusModel> searchhBus(LocalDate givenDepartureDate,String fromLocation,String toLocation) ;
	
	public BusModel findBusDetailsUsingID(int busId);
	
	
}
