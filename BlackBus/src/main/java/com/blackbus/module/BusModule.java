package com.blackbus.module;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class BusModule {

	private int busId;
	private int operatorId;
	private String busName;
	private String busFeatures;
	private String busCategory;
	private LocalDate departuredate;
	private String fromCity;
	private String toCity;
	private LocalTime departuretime;
	private LocalTime arrivaltime; 
	private int totalSeat;
	private int Price;
	
	


	public BusModule() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BusModule(int busId, int operatorId, String busName, String busFeatures, String busCategory,
			LocalDate departuredate, String fromCity, String toCity, LocalTime departuretime, LocalTime arrivaltime,
			int totalSeat, int price) {
		super();
		this.busId = busId;
		this.operatorId = operatorId;
		this.busName = busName;
		this.busFeatures = busFeatures;
		this.busCategory = busCategory;
		this.departuredate = departuredate;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.departuretime = departuretime;
		this.arrivaltime = arrivaltime;
		this.totalSeat = totalSeat;
		Price = price;
	}

	public int getBusId() {
		return busId;
	}

	public int getOperatorId() {
		return operatorId;
	}

	public String getBusName() {
		return busName;
	}

	public String getBusFeatures() {
		return busFeatures;
	}

	public String getBusCategory() {
		return busCategory;
	}

	public LocalDate getDeparturedate() {
		return departuredate;
	}

	public String getFromCity() {
		return fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public LocalTime getDeparturetime() {
		return departuretime;
	}

	public LocalTime getArrivaltime() {
		return arrivaltime;
	}

	public int getTotalSeat() {
		return totalSeat;
	}

	public int getPrice() {
		return Price;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public void setBusFeatures(String busFeatures) {
		this.busFeatures = busFeatures;
	}

	public void setBusCategory(String busCategory) {
		this.busCategory = busCategory;
	}

	public void setDeparturedate(LocalDate departuredate) {
		this.departuredate = departuredate;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public void setDeparturetime(LocalTime departuretime) {
		this.departuretime = departuretime;
	}

	public void setArrivaltime(LocalTime arrivaltime) {
		this.arrivaltime = arrivaltime;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

	public void setPrice(int price) {
		Price = price;
	}

	@Override
	public String toString() {
		return "BusModule [busId=" + busId + ", operatorId=" + operatorId + ", busName=" + busName + ", busFeatures="
				+ busFeatures + ", busCategory=" + busCategory + ", departuredate=" + departuredate + ", fromCity="
				+ fromCity + ", toCity=" + toCity + ", departuretime=" + departuretime + ", arrivaltime=" + arrivaltime
				+ ", totalSeat=" + totalSeat + ", Price=" + Price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Price, arrivaltime, busCategory, busFeatures, busId, busName, departuredate, departuretime,
				fromCity, operatorId, toCity, totalSeat);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BusModule other = (BusModule) obj;
		return Price == other.Price && Objects.equals(arrivaltime, other.arrivaltime)
				&& Objects.equals(busCategory, other.busCategory) && Objects.equals(busFeatures, other.busFeatures)
				&& busId == other.busId && Objects.equals(busName, other.busName)
				&& Objects.equals(departuredate, other.departuredate)
				&& Objects.equals(departuretime, other.departuretime) && Objects.equals(fromCity, other.fromCity)
				&& operatorId == other.operatorId && Objects.equals(toCity, other.toCity)
				&& totalSeat == other.totalSeat;
	}

	
	


	
}
