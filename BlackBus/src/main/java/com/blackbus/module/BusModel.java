package com.blackbus.module;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class BusModel {

	
	private OperatorModel OperatorModel;
	private int busId;
	private String busCategory;
	private String fromCity;
	private String toCity;
	private Date departure;
	private Date arrival;
	private int totalseat;
	
	public BusModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusModel(com.blackbus.module.OperatorModel operatorModel, int busId, String busCategory, String fromCity,
			String toCity, Date departure, Date arrival, int totalseat) {
		super();
		OperatorModel = operatorModel;
		this.busId = busId;
		this.busCategory = busCategory;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.departure = departure;
		this.arrival = arrival;
		this.totalseat = totalseat;
	}

	public OperatorModel getOperatorModel() {
		return OperatorModel;
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

	public Date getDeparture() {
		return departure;
	}

	public Date getArrival() {
		return arrival;
	}

	public int getTotalseat() {
		return totalseat;
	}

	public void setOperatorModel(OperatorModel operatorModel) {
		OperatorModel = operatorModel;
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

	public void setDeparture(Date departure) {
		this.departure = departure;
	}

	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

	public void setTotalseat(int totalseat) {
		this.totalseat = totalseat;
	}

	@Override
	public String toString() {
		return "BusModel [OperatorModel=" + OperatorModel + ", busId=" + busId + ", busCategory=" + busCategory
				+ ", fromCity=" + fromCity + ", toCity=" + toCity + ", departure=" + departure + ", arrival=" + arrival
				+ ", totalseat=" + totalseat + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(OperatorModel, arrival, busCategory, busId, departure, fromCity, toCity, totalseat);
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
		return Objects.equals(OperatorModel, other.OperatorModel) && Objects.equals(arrival, other.arrival)
				&& Objects.equals(busCategory, other.busCategory) && busId == other.busId
				&& Objects.equals(departure, other.departure) && Objects.equals(fromCity, other.fromCity)
				&& Objects.equals(toCity, other.toCity) && totalseat == other.totalseat;
	}

	
	


	
}
