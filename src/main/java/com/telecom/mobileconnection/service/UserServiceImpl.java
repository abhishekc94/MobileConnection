package com.telecom.mobileconnection.service;

import java.util.Optional;
import java.util.Random;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.mobileconnection.dto.UserRequestDto;
import com.telecom.mobileconnection.dto.UserResponseDto;
import com.telecom.mobileconnection.entity.Plan;
import com.telecom.mobileconnection.entity.Track;
import com.telecom.mobileconnection.entity.User;
import com.telecom.mobileconnection.exception.UserRegistrationException;
import com.telecom.mobileconnection.repository.PlanRepository;
import com.telecom.mobileconnection.repository.TrackRepository;
import com.telecom.mobileconnection.repository.UserRepository;
import com.telecom.mobileconnection.utils.MobileConnectionContants;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	TrackRepository trackRepository;

	@Autowired
	PlanRepository planRepository;

	Random rand;

	@Override
	public UserResponseDto register(UserRequestDto userRequestDto) throws UserRegistrationException {

		if (!validateUserName(userRequestDto.getUsername())) {
			throw new UserRegistrationException(MobileConnectionContants.INVALID_USER_NAME);
		}

		if (!validPhoneNumber(userRequestDto.getNewMobileNumber())) {
			throw new UserRegistrationException(MobileConnectionContants.INVALID_MOBILE_NUMBER);
		}

		if (!validEmailId(userRequestDto.getEmailId())) {
			throw new UserRegistrationException(MobileConnectionContants.INVALID_EMAIL);
		}
		if (!validPanNo(userRequestDto.getPanCardNo())) {
			throw new UserRegistrationException(MobileConnectionContants.INVALID_PAN_NO);
		}

		User checkCustomerEmail = userRepository.findByEmailId(userRequestDto.getEmailId());
		if (checkCustomerEmail != null) {
			throw new UserRegistrationException(MobileConnectionContants.EXIST_EMAIL);
		}
		
		Optional<Plan> checkPlan = planRepository.findByPlanId(userRequestDto.getPlanId());
		
		if(!checkPlan.isPresent()) {
			throw new UserRegistrationException(MobileConnectionContants.NO_PLAN_EXISTS);
		}
		User user = new User();
		user.setUserName(userRequestDto.getUsername());
		user.setEmailId(userRequestDto.getEmailId());
		user.setAddress(userRequestDto.getAddress());
		user.setPanCardNo(userRequestDto.getPanCardNo());
		user.setNewMobileNumber(userRequestDto.getNewMobileNumber());
		user.setMobileNumberStatus("New");
		User userResponse = userRepository.save(user);

		Track track = new Track();

		track.setTrackStatus("Initiated");
		track.setUserId(userResponse.getUserId());
		track.setPlanId(userRequestDto.getPlanId());
		track.setApproverComments("Yet to review");
		Track trackOrder = trackRepository.save(track);

		UserResponseDto userResponseDto = new UserResponseDto();
		userResponseDto.setTrackId(trackOrder.getTrackId());
		userResponseDto.setStatusCode(201);
		userResponseDto.setMessage("Customer Registered successfully, above is your track Id");
		return userResponseDto;
	}

	private boolean validateUserName(String userName) {
		String name = ("^[a-zA-Z]*$");
		return userName.matches(name);
	}

	private boolean validEmailId(String email) {
		Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		java.util.regex.Matcher m = p.matcher(email);
		return (m.find() && m.group().equals(email));
	}

	private boolean validPhoneNumber(Long number) {
		String num = number.toString();
		Pattern p = Pattern.compile("^[0-9]{10}$");
		java.util.regex.Matcher m = p.matcher(num);
		return (m.find() && m.group().equals(num));
	}

	private boolean validPanNo(String panNo) {
		Pattern p = Pattern.compile("^[a-zA-Z1-9]*$", Pattern.CASE_INSENSITIVE);
		java.util.regex.Matcher m = p.matcher(panNo);
		return (m.find() && m.group().equals(panNo));
	}

}
