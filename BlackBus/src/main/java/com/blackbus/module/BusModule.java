package com.blackbus.module;

import java.util.Date;
import java.util.Objects;

public class BusModule {

	private int busId;
	private int operatorId;
	private String busName;
	private String busFeatures;
	private String busCatagory;
	private int busNumber;
	private Date busDate;
	private String fromCity;
	private String toCity;
	private String startTime;
	private String endTime; 
	private int totalSeat;
	private int availableSeat;
	private int totalPrice;
	
	public BusModule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusModule(int busId, int operatorId, String busName, String busFeatures, String busCatagory, int busNumber,
			Date busDate, String fromCity, String toCity, String startTime, String endTime, int totalSeat,
			int availableSeat, int totalPrice) {
		super();
		this.busId = busId;
		this.operatorId = operatorId;
		this.busName = busName;
		this.busFeatures = busFeatures;
		this.busCatagory = busCatagory;
		this.busNumber = busNumber;
		this.busDate = busDate;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.startTime = startTime;
		this.endTime = endTime;
		this.totalSeat = totalSeat;
		this.availableSeat = availableSeat;
		this.totalPrice = totalPrice;
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

	public String getBusCatagory() {
		return busCatagory;
	}

	public int getBusNumber() {
		return busNumber;
	}

	public Date getBusDate() {
		return busDate;
	}

	public String getFromCity() {
		return fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public int getTotalSeat() {
		return totalSeat;
	}

	public int getAvailableSeat() {
		return availableSeat;
	}

	public int getTotalPrice() {
		return totalPrice;
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

	public void setBusCatagory(String busCatagory) {
		this.busCatagory = busCatagory;
	}

	public void setBusNumber(int busNumber) {
		this.busNumber = busNumber;
	}

	public void setBusDate(Date busDate) {
		this.busDate = busDate;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

	public void setAvailableSeat(int availableSeat) {
		this.availableSeat = availableSeat;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "BusModule [busId=" + busId + ", operatorId=" + operatorId + ", busName=" + busName + ", busFeatures="
				+ busFeatures + ", busCatagory=" + busCatagory + ", busNumber=" + busNumber + ", busDate=" + busDate
				+ ", fromCity=" + fromCity + ", toCity=" + toCity + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", totalSeat=" + totalSeat + ", availableSeat=" + availableSeat + ", totalPrice=" + totalPrice + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(availableSeat, busCatagory, busDate, busFeatures, busId, busName, busNumber, endTime,
				fromCity, operatorId, startTime, toCity, totalPrice, totalSeat);
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
		return availableSeat == other.availableSeat && Objects.equals(busCatagory, other.busCatagory)
				&& Objects.equals(busDate, other.busDate) && Objects.equals(busFeatures, other.busFeatures)
				&& busId == other.busId && Objects.equals(busName, other.busName) && busNumber == other.busNumber
				&& Objects.equals(endTime, other.endTime) && Objects.equals(fromCity, other.fromCity)
				&& operatorId == other.operatorId && Objects.equals(startTime, other.startTime)
				&& Objects.equals(toCity, other.toCity) && totalPrice == other.totalPrice
				&& totalSeat == other.totalSeat;
	}

	
	


	
}
