package com.blackbus.module;


import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class BookedTicketsModel {

	
	private UserModel userModel;
	private BusModel busModel;
	private LocalDate bookingDate;
	private int ticketCount;
	private String seatNo;
	private String bookingStatus;
	private int totalPrice;
	
	public BookedTicketsModel() {
		super();
	}

	public BookedTicketsModel(UserModel userModel, BusModel busModel, LocalDate bookingDate, int ticketCount,
			String seatNo, String bookingStatus, int totalPrice) {
		super();
		this.userModel = userModel;
		this.busModel = busModel;
		this.bookingDate = bookingDate;
		this.ticketCount = ticketCount;
		this.seatNo = seatNo;
		this.bookingStatus = bookingStatus;
		this.totalPrice = totalPrice;
	}

	
	
	public BookedTicketsModel(UserModel userModel1, BusModel busModel1, int bookTicketCount1, String bookSeatNo1,
			int bookTotalPrice1) {
		this.userModel=userModel1;
		this.busModel=busModel1;
		this.ticketCount=bookTicketCount1;
		this.seatNo=bookSeatNo1;
		this.totalPrice=bookTotalPrice1;
				
	}

	public BookedTicketsModel(int int1, int int2, LocalDate localDate, int int3, String string, String string2,
			int int4) {
		
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public BusModel getBusModel() {
		return busModel;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public int getTicketCount() {
		return ticketCount;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public void setBusModel(BusModel busModel) {
		this.busModel = busModel;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public void setTicketCount(int ticketCount) {
		this.ticketCount = ticketCount;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "BookedTicketsModel [userModel=" + userModel + ", busModel=" + busModel + ", bookingDate=" + bookingDate
				+ ", ticketCount=" + ticketCount + ", seatNo=" + seatNo + ", bookingStatus=" + bookingStatus
				+ ", totalPrice=" + totalPrice + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookingDate, bookingStatus, busModel, seatNo, ticketCount, totalPrice, userModel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookedTicketsModel other = (BookedTicketsModel) obj;
		return Objects.equals(bookingDate, other.bookingDate) && Objects.equals(bookingStatus, other.bookingStatus)
				&& Objects.equals(busModel, other.busModel) && Objects.equals(seatNo, other.seatNo)
				&& ticketCount == other.ticketCount && totalPrice == other.totalPrice
				&& Objects.equals(userModel, other.userModel);
	}

	
	
	

	

	}
	
	
	
	
