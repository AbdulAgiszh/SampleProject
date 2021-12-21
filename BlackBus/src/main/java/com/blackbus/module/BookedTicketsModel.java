package com.blackbus.module;

//LocalDate date_returned=LocalDate.now();
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class BookedTicketsModel {

	private int bookingId;
	private UserModel userModel;
	private BusModel busModel;
	private Date bookingDate;
	private int ticketCount;
	private int seatNo;
	private String bookingStatus;
	private int totalPrice;
	
	public BookedTicketsModel() {
		super();
	}

	public BookedTicketsModel(int bookingId, UserModel userModel, BusModel busModel, Date bookingDate, int ticketCount,
			int seatNo, String bookingStatus, int totalPrice) {
		super();
		this.bookingId = bookingId;
		this.userModel = userModel;
		this.busModel = busModel;
		this.bookingDate = bookingDate;
		this.ticketCount = ticketCount;
		this.seatNo = seatNo;
		this.bookingStatus = bookingStatus;
		this.totalPrice = totalPrice;
	}


	public BookedTicketsModel(UserModel userModel1, BusModel bookBusModel1, int bookTicketCount1, int bookSeatNo1,int bookTotalPrice1) {
		this.userModel=userModel1;
		this.busModel=bookBusModel1;
		this.ticketCount=bookTicketCount1;
		this.seatNo=bookSeatNo1;
		this.totalPrice=bookTotalPrice1;
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

	public Date getBookingDate() {
		return bookingDate;
	}

	public int getTicketCount() {
		return ticketCount;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public int getTotalPrice() {
		return totalPrice;
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

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public void setTicketCount(int ticketCount) {
		this.ticketCount = ticketCount;
	}

	public void setSeatNo(int seatNo) {
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
		return "BookedTicketsModel [bookingId=" + bookingId + ", userModel=" + userModel + ", busModel=" + busModel
				+ ", bookingDate=" + bookingDate + ", ticketCount=" + ticketCount + ", seatNo=" + seatNo
				+ ", bookingStatus=" + bookingStatus + ", totalPrice=" + totalPrice + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookingDate, bookingId, bookingStatus, busModel, seatNo, ticketCount, totalPrice,
				userModel);
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
				&& seatNo == other.seatNo && ticketCount == other.ticketCount && totalPrice == other.totalPrice
				&& Objects.equals(userModel, other.userModel);
	}
	
	
	
	
}
