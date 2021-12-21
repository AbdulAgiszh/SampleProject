package com.blackbus.module;


import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class BusModel {

	
	private int operatorId;
	private int busId;
	private String busCategory;
	private String fromCity;
	private String toCity;
	private LocalDateTime departure;
	private LocalDateTime arrival;
	private int sleeperFare;
	private int seaterFare;
	private int totalseat;
//	private int availableSeat;
	private String status;


	public BusModel(int operatorId,String busCategory, String fromCity, String toCity, LocalDateTime depDate,
			LocalDateTime arrDate, int sleeperFare, int seaterFare, int totalseat) {
		super();
		this.operatorId=operatorId;
		this.busCategory = busCategory;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.departure = depDate;
		this.arrival = arrDate;
		this.sleeperFare = sleeperFare;
		this.seaterFare = seaterFare;
		this.totalseat = totalseat;
		
	}

	public BusModel(int busId, int operatorId1, String busCategory1, String fromCity1, String toCity1, LocalDateTime depDate1, LocalDateTime arrDate1,
			 int sleeperFare1, int seaterFare1, int totalseat1, String status1) {
		super();
		this.busId=busId;
		this.operatorId=operatorId1;
		this.busCategory = busCategory1;
		this.fromCity = fromCity1;
		this.toCity = toCity1;
		this.departure = depDate1;
		this.arrival = arrDate1;
		this.sleeperFare = sleeperFare1;
		this.seaterFare = seaterFare1;
		this.totalseat = totalseat1;
		this.status=status1;
	}

	public BusModel(int operatorId1, String busCategory1, String fromCity1, String toCity1, LocalDateTime depDate1,
			LocalDateTime arrDate1, int sleeperFare1, int seaterFare1, int totalseat1, String status1) {
		super();
		this.operatorId=operatorId1;
		this.busCategory = busCategory1;
		this.fromCity = fromCity1;
		this.toCity = toCity1;
		this.departure = depDate1;
		this.arrival = arrDate1;
		this.sleeperFare = sleeperFare1;
		this.seaterFare = seaterFare1;
		this.totalseat = totalseat1;
		this.status=status1;
	}

	public  int getoperatorId() {
		return operatorId;
	}

	public int getBusId() {
		return busId;
	}

	public String getBusCategory() {
		return busCategory;
	}

	public String getFromCity() {
		return fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public LocalDateTime getDeparture() {
		return departure;
	}

	public LocalDateTime getArrival() {
		return arrival;
	}

	public int getSleeperFare() {
		return sleeperFare;
	}

	public int getSeaterFare() {
		return seaterFare;
	}

	public int getTotalseat() {
		return totalseat;
	}
	
	public String getStatus() {
		return status;
	}

	public void setoperatorId(int operatorModel) {
		operatorId = operatorId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public void setBusCategory(String busCategory) {
		this.busCategory = busCategory;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public void setDeparture(LocalDateTime departure) {
		this.departure = departure;
	}

	public void setArrival(LocalDateTime arrival) {
		this.arrival = arrival;
	}

	public void setSleeperFare(int sleeperFare) {
		this.sleeperFare = sleeperFare;
	}

	public void setSeaterFare(int seaterFare) {
		this.seaterFare = seaterFare;
	}

	public void setTotalseat(int totalseat) {
		this.totalseat = totalseat;
	}
	
	public void setStatus(String status) {
		this.status=status;
	}

	DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	@Override
	public String toString() {
		return "BusModel [operatorId=" + operatorId + ", busId=" + busId + ", busCategory=" + busCategory
				+ ", fromCity=" + fromCity + ", toCity=" + toCity + ", departure=" + departure.format(format) + ", arrival=" + arrival.format(format)
				+ ", sleeperFare=" + sleeperFare + ", seaterFare=" + seaterFare + ", totalseat=" + totalseat + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(arrival, busCategory, busId, departure, fromCity, operatorId, seaterFare, sleeperFare,
				status, toCity, totalseat);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BusModel other = (BusModel) obj;
		return Objects.equals(arrival, other.arrival) && Objects.equals(busCategory, other.busCategory)
				&& busId == other.busId && Objects.equals(departure, other.departure)
				&& Objects.equals(fromCity, other.fromCity) && operatorId == other.operatorId
				&& seaterFare == other.seaterFare && sleeperFare == other.sleeperFare
				&& Objects.equals(status, other.status) && Objects.equals(toCity, other.toCity)
				&& totalseat == other.totalseat;
	}

	

	
	


	
}
