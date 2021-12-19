package com.blackbus.module;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Objects;

public class BusModel {

	
	private OperatorModel OperatorModel;
	private int busId;
	private String busCategory;
	private String fromCity;
	private String toCity;
	private LocalDateTime departure;
	private LocalDateTime arrival;
	private int sleeperFare;
	private int seaterFare;
	private int totalseat;
	private String status;


	public BusModel(String busCategory, String fromCity, String toCity, LocalDateTime depDate,
			LocalDateTime arrDate, int sleeperFare, int seaterFare, int totalseat) {
		super();
		this.busCategory = busCategory;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.departure = depDate;
		this.arrival = arrDate;
		this.sleeperFare = sleeperFare;
		this.seaterFare = seaterFare;
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

	@Override
	public String toString() {
		return "BusModel [OperatorModel=" + OperatorModel + ", busId=" + busId + ", busCategory=" + busCategory
				+ ", fromCity=" + fromCity + ", toCity=" + toCity + ", departure=" + departure + ", arrival=" + arrival
				+ ", sleeperFare=" + sleeperFare + ", seaterFare=" + seaterFare + ", totalseat=" + totalseat + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(OperatorModel, arrival, busCategory, busId, departure, fromCity, seaterFare, sleeperFare,
				toCity, totalseat);
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
				&& seaterFare == other.seaterFare && sleeperFare == other.sleeperFare
				&& Objects.equals(toCity, other.toCity) && totalseat == other.totalseat;
	}

	
	


	
}
