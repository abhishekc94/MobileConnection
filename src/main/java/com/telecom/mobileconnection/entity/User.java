package com.telecom.mobileconnection.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String userName;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPanCardNo() {
		return panCardNo;
	}

	public void setPanCardNo(String panCardNo) {
		this.panCardNo = panCardNo;
	}

	public Long getNewMobileNumber() {
		return newMobileNumber;
	}

	public void setNewMobileNumber(Long newMobileNumber) {
		this.newMobileNumber = newMobileNumber;
	}

	public String getMobileNumberStatus() {
		return mobileNumberStatus;
	}

	public void setMobileNumberStatus(String mobileNumberStatus) {
		this.mobileNumberStatus = mobileNumberStatus;
	}

	private String address;
	private String emailId;
	private String panCardNo;
	private Long newMobileNumber;
	private String mobileNumberStatus;
}
