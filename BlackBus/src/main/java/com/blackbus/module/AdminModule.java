package com.blackbus.module;

import java.util.Objects;

public class AdminModule {

	private int adminId;
	private String adminName;
	private String adminPassword;
	private String adminEmail;
	
	public AdminModule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminModule(String adminName, String adminPassword, String adminEmail) {
		super();
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.adminEmail = adminEmail;
	}

	public int getAdminId() {
		return adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	@Override
	public String toString() {
		return "AdminModule [adminId=" + adminId + ", adminName=" + adminName + ", adminPassword=" + adminPassword
				+ ", adminEmail=" + adminEmail + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(adminEmail, adminId, adminName, adminPassword);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminModule other = (AdminModule) obj;
		return Objects.equals(adminEmail, other.adminEmail) && adminId == other.adminId
				&& Objects.equals(adminName, other.adminName) && Objects.equals(adminPassword, other.adminPassword);
	}
	
	
	
	
}
