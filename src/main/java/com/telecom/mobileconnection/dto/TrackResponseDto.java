package com.telecom.mobileconnection.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TrackResponseDto {
	
	private String trackStatus;
	private String approverComments;
	
	public String getTrackStatus() {
		return trackStatus;
	}
	public void setTrackStatus(String trackStatus) {
		this.trackStatus = trackStatus;
	}
	public String getApproverComments() {
		return approverComments;
	}
	public void setApproverComments(String approverComments) {
		this.approverComments = approverComments;
	}
	
}
