package com.telecom.mobileconnection.dto;

public class AdminResponseDto {

	private String userName;
	private String address;
	private String panCardNo;
	private Long newMobileNumber;
	private String mobileNumberStatus;
	private Integer trackId;
	private String trackStatus;
	private String planId;
	
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
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
	public Integer getTrackId() {
		return trackId;
	}
	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
	}
	public String getTrackStatus() {
		return trackStatus;
	}
	public void setTrackStatus(String trackStatus) {
		this.trackStatus = trackStatus;
	}
	
	
}
