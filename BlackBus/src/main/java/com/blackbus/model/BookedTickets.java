package com.blackbus.model;


import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class BookedTickets {

	private int bookingId;
	private User userModel;
	private Bus busModel;
	private int BusNo;
	private LocalDate bookingDate;
	private LocalDate departureDate;
	private int ticketCount;
	private String seatNo;
	private String bookingStatus;
	private int totalPrice;
	private String paymentStatus;
	
	public BookedTickets() {
		super();
	}

	public BookedTickets(int bookingId, User userModel, Bus busModel, int busNo, LocalDate bookingDate,
			LocalDate departureDate, String seatNo, int ticketCount,  int totalPrice,String bookingStatus,
			String paymentStatus) {
		super();
		this.bookingId = bookingId;
		this.userModel = userModel;
		this.busModel = busModel;
		BusNo = busNo;
		this.bookingDate = bookingDate;
		this.departureDate = departureDate;
		this.ticketCount = ticketCount;
		this.seatNo = seatNo;
		this.bookingStatus = bookingStatus;
		this.totalPrice = totalPrice;
		this.paymentStatus = paymentStatus;
	}


	public int getBookingId() {
		return bookingId;
	}

	public User getUserModel() {
		return userModel;
	}

	public Bus getBusModel() {
		return busModel;
	}

	public int getBusNo() {
		return BusNo;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
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

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public void setUserModel(User userModel) {
		this.userModel = userModel;
	}

	public void setBusModel(Bus busModel) {
		this.busModel = busModel;
	}

	public void setBusNo(int busNo) {
		BusNo = busNo;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
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

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "BookedTickets [bookingId=" + bookingId + ", userModel=" + userModel + ", busModel=" + busModel
				+ ", BusNo=" + BusNo + ", bookingDate=" + bookingDate + ", departureDate=" + departureDate
				+ ", ticketCount=" + ticketCount + ", seatNo=" + seatNo + ", bookingStatus=" + bookingStatus
				+ ", totalPrice=" + totalPrice + ", paymentStatus=" + paymentStatus + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(BusNo, bookingDate, bookingId, bookingStatus, busModel, departureDate, paymentStatus,
				seatNo, ticketCount, totalPrice, userModel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookedTickets other = (BookedTickets) obj;
		return BusNo == other.BusNo && Objects.equals(bookingDate, other.bookingDate) && bookingId == other.bookingId
				&& Objects.equals(bookingStatus, other.bookingStatus) && Objects.equals(busModel, other.busModel)
				&& Objects.equals(departureDate, other.departureDate)
				&& Objects.equals(paymentStatus, other.paymentStatus) && Objects.equals(seatNo, other.seatNo)
				&& ticketCount == other.ticketCount && totalPrice == other.totalPrice
				&& Objects.equals(userModel, other.userModel);
	}

	
	
	}
	
	

