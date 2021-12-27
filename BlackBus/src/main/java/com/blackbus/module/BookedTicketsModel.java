package com.blackbus.module;


import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class BookedTicketsModel {

	private int bookingId;
	private UserModel userModel;
	private BusModel busModel;
	private LocalDate bookingDate;
	private LocalDate departureDate;
	private int ticketCount;
	private String seatCategory;
	private String seatNo;
	private String bookingStatus;
	private int totalPrice;
	private String paymentStatus;
	
	public BookedTicketsModel() {
		super();
	}

	
	public BookedTicketsModel(int bookingId, UserModel userModel, BusModel busModel, LocalDate bookingDate,
			LocalDate departureDate, int ticketCount, String seatCategory, String seatNo, String bookingStatus,
			int totalPrice, String paymentStatus) {
		super();
		this.bookingId = bookingId;
		this.userModel = userModel;
		this.busModel = busModel;
		this.bookingDate = bookingDate;
		this.departureDate = departureDate;
		this.ticketCount = ticketCount;
		this.seatCategory = seatCategory;
		this.seatNo = seatNo;
		this.bookingStatus = bookingStatus;
		this.totalPrice = totalPrice;
		this.paymentStatus = paymentStatus;
	}

	public BookedTicketsModel(UserModel userModel1, BusModel busModel1,LocalDate departureDate1, int bookTicketCount1,String seatCategory1, String bookSeatNo1,
			int bookTotalPrice1,String paymentStatus1) {
		this.userModel=userModel1;
		this.busModel=busModel1;
		this.departureDate=departureDate1;
		this.ticketCount=bookTicketCount1;
		this.seatCategory=seatCategory1;
		this.seatNo=bookSeatNo1;
		this.totalPrice=bookTotalPrice1;
		this.paymentStatus = paymentStatus1;
	}
		
	
	
	
	public int getBookingId() {
		return bookingId;
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


	public LocalDate getDepartureDate() {
		return departureDate;
	}


	public int getTicketCount() {
		return ticketCount;
	}


	public String getSeatCategory() {
		return seatCategory;
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


	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}


	public void setBusModel(BusModel busModel) {
		this.busModel = busModel;
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


	public void setSeatCategory(String seatCategory) {
		this.seatCategory = seatCategory;
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
		return "BookedTicketsModel [bookingId=" + bookingId + ", userModel=" + userModel + ", busModel=" + busModel
				+ ", bookingDate=" + bookingDate + ", departureDate=" + departureDate + ", ticketCount=" + ticketCount
				+ ", seatCategory=" + seatCategory + ", seatNo=" + seatNo + ", bookingStatus=" + bookingStatus
				+ ", totalPrice=" + totalPrice + ", paymentStatus=" + paymentStatus + "]";
	}


	public String toStringUser() {
		return "Booking Details : \n UserName: " + userModel.getUserName()+",\n Booking Ticket Number : " +bookingId+  ",\n Bus_No : " +busModel.getBusId()+ ",\n Bus_category : " 
				+busModel.getBusCategory()+ ",\n Source : " +busModel.getFromCity()+ ",\n Destination : " +busModel.getToCity()+ ",\n Departure : " +busModel.getDeparture() +
				",\n Arrival : "+busModel.getArrival()+ ",\n Booking_Date : "+bookingDate+",\n Seat_Category : " +seatCategory+ ",\n Seat_No : " +seatNo+  ",\n Total_Price : " + totalPrice + 
				 ", bookingStatus=" + bookingStatus+ ", paymentStatus=" + paymentStatus + "" ; 
	}
	
	public String toStringAdmin() {
		return "Booking Details :\n UserLoginId : " +userModel.getUserContact()+ ",\n Booking Ticket Number : " +bookingId+ ",\n Bus_No : " +busModel.getBusId()+ ",\n Bus_category : " 
				+busModel.getBusCategory()+ ",\n Source : " +busModel.getFromCity()+ ",\n Destination : " +busModel.getToCity()+ ",\n Departure : " +busModel.getDeparture() +
				",\n Arrival : "+busModel.getArrival()+ ",\n Booking_Date : "+bookingDate+",\n Seat_Category : " +seatCategory+ ",\n Seat_No : " +seatNo+  ",\n Total_Price : " + totalPrice + 
						",\n payment Status : " +paymentStatus+"" ;
	}


	@Override
	public int hashCode() {
		return Objects.hash(bookingDate, bookingId, bookingStatus, busModel, departureDate, paymentStatus, seatCategory,
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
		BookedTicketsModel other = (BookedTicketsModel) obj;
		return Objects.equals(bookingDate, other.bookingDate) && bookingId == other.bookingId
				&& Objects.equals(bookingStatus, other.bookingStatus) && Objects.equals(busModel, other.busModel)
				&& Objects.equals(departureDate, other.departureDate)
				&& Objects.equals(paymentStatus, other.paymentStatus)
				&& Objects.equals(seatCategory, other.seatCategory) && Objects.equals(seatNo, other.seatNo)
				&& ticketCount == other.ticketCount && totalPrice == other.totalPrice
				&& Objects.equals(userModel, other.userModel);
	}

	
	
	}
	
	

