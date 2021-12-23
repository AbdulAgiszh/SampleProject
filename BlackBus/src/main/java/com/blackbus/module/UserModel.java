package com.blackbus.module;

import java.util.Objects;

public class UserModel {

	
	private int userId;
	private String userName;
	private int userAge;
	private String userEmail;
	private long userContact;
	private String userGender;
	private String userPassword;
	private int userWallet;
	

	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public UserModel(int userId, String userName, int userAge, String userEmail, long userContact, String userGender,
			String userPassword, int userWallet) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAge = userAge;
		this.userEmail = userEmail;
		this.userContact = userContact;
		this.userGender = userGender;
		this.userPassword = userPassword;
		this.userWallet = userWallet;
	}

	public UserModel( String userName, int userAge, String userEmail, long userContact, String userGender,
			String userPassword) {
		super();
		this.userName = userName;
		this.userAge = userAge;
		this.userEmail = userEmail;
		this.userContact = userContact;
		this.userGender = userGender;
		this.userPassword = userPassword;
	}

	public UserModel(String userName1, int userAge1, long userContact1, String userGender1, String userPassword1) {
		super();
		this.userName = userName1;
		this.userAge = userAge1;
		this.userContact = userContact1;
		this.userGender = userGender1;
		this.userPassword = userPassword1;
	}

	public UserModel(long contact, String password) {
		super();
		this.userContact=contact;
		this.userPassword=password;
	}




	public int getUserId() {
		return userId;
	}


	public String getUserName() {
		return userName;
	}


	public int getUserAge() {
		return userAge;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public long getUserContact() {
		return userContact;
	}


	public String getUserGender() {
		return userGender;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public int getUserWallet() {
		return userWallet;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public void setUserContact(long userContact) {
		this.userContact = userContact;
	}


	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public void setUserWallet(int userWallet) {
		this.userWallet = userWallet;
	}


	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", userName=" + userName + ", userAge=" + userAge + ", userEmail="
				+ userEmail + ", userContact=" + userContact + ", userGender=" + userGender + ", userPassword="
				+ userPassword + ", userWallet=" + userWallet + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(userAge, userContact, userEmail, userGender, userId, userName, userPassword, userWallet);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserModel other = (UserModel) obj;
		return userAge == other.userAge && userContact == other.userContact
				&& Objects.equals(userEmail, other.userEmail) && Objects.equals(userGender, other.userGender)
				&& userId == other.userId && Objects.equals(userName, other.userName)
				&& Objects.equals(userPassword, other.userPassword) && userWallet == other.userWallet;
	}

	

	
	
	
}
