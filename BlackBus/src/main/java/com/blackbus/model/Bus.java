package com.blackbus.model;


import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Bus {

	private int busId;
	private int busNo;
	private int operatorId;
	private String busCategory;
	private String fromCity;
	private String toCity;
	private LocalDateTime departure;
	private LocalDateTime arrival;
	private int sleeperFare;
	private int seaterFare;
	private int totalseat;
	private String status;


	public Bus(int operatorId,String busCategory, String fromCity, String toCity, LocalDateTime depDate,
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

	public Bus(int busNo1,int operatorId1, String busCategory1, String fromCity1, String toCity1, LocalDateTime depDate1,
			LocalDateTime arrDate1, int sleeperFare1, int seaterFare1, int totalseat1, String status1) {
		super();
		this.busNo=busNo1;
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

	public Bus(int busId, int busNo, int operatorId, String busCategory, String fromCity, String toCity,
			LocalDateTime departure, LocalDateTime arrival, int sleeperFare, int seaterFare, int totalseat,
			String status) {
		super();
		this.busId = busId;
		this.busNo = busNo;
		this.operatorId = operatorId;
		this.busCategory = busCategory;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.departure = departure;
		this.arrival = arrival;
		this.sleeperFare = sleeperFare;
		this.seaterFare = seaterFare;
		this.totalseat = totalseat;
		this.status = status;
	}

	public Bus(String busCategory2, String fromCity2, String toCity2, LocalDateTime departure2,
			LocalDateTime arrival2, int sleeperFare2, int seaterFare2, int totalSeat2) {
		super();
		this.busCategory = busCategory2;
		this.fromCity = fromCity2;
		this.toCity = toCity2;
		this.departure = departure2;
		this.arrival = arrival2;
		this.sleeperFare = sleeperFare2;
		this.seaterFare = seaterFare2;
		this.totalseat = totalSeat2;
	}

	public int getBusId() {
		return busId;
	}

	public int getBusNo() {
		return busNo;
	}

	public int getOperatorId() {
		return operatorId;
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

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
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
		this.status = status;
	}

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busNo=" + busNo + ", operatorId=" + operatorId + ", busCategory="
				+ busCategory + ", fromCity=" + fromCity + ", toCity=" + toCity + ", departure=" + departure
				+ ", arrival=" + arrival + ", sleeperFare=" + sleeperFare + ", seaterFare=" + seaterFare
				+ ", totalseat=" + totalseat + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(arrival, busCategory, busId, busNo, departure, fromCity, operatorId, seaterFare,
				sleeperFare, status, toCity, totalseat);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bus other = (Bus) obj;
		return Objects.equals(arrival, other.arrival) && Objects.equals(busCategory, other.busCategory)
				&& busId == other.busId && busNo == other.busNo && Objects.equals(departure, other.departure)
				&& Objects.equals(fromCity, other.fromCity) && operatorId == other.operatorId
				&& seaterFare == other.seaterFare && sleeperFare == other.sleeperFare
				&& Objects.equals(status, other.status) && Objects.equals(toCity, other.toCity)
				&& totalseat == other.totalseat;
	}
	
	
	
	

	
	


	
}
