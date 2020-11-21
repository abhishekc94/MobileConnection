package com.telecom.mobileconnection.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.telecom.mobileconnection.repository.TrackRepository;
import com.telecom.mobileconnection.repository.UserRepository;

@Component
public class MobileReleaseSchedule {
	@Autowired
	UserRepository UserRepository;
	@Autowired
	TrackRepository TrackRepository;

	@Scheduled(fixedRate = 2000)
	public void mobileConnectionSchedule() {
		List<Integer> userIdList = TrackRepository.getApprovedOrdersList(MobileConnectionContants.APPROVED_STATUS);
		UserRepository.updateNewMobileNumberStatus(userIdList, MobileConnectionContants.NEW_CONNECTION_STATUS);
	}
}