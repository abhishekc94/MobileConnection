package com.telecom.mobileconnection.service;

import java.security.SecureRandom;
import java.util.Random;
import java.util.regex.Pattern;

import javax.sound.midi.Track;

import org.springframework.beans.factory.annotation.Autowired;

import com.telecom.mobileconnection.dto.UserRequestDto;
import com.telecom.mobileconnection.dto.UserResponseDto;
import com.telecom.mobileconnection.entity.User;
import com.telecom.mobileconnection.exception.InvalidUserNameException;
import com.telecom.mobileconnection.repository.TrackRepository;
import com.telecom.mobileconnection.repository.UserRepository;
import com.telecom.mobileconnection.utils.MobileConnectionContants;

public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;

	@Autowired
	TrackRepository trackRepository;

	Random rand;

	/*
	 * This method is used to register the customer by providing valid details,
	 * while registering it will generate trackId for the customer. Once user
	 * registered successfully it will generate account for the customer.
	 * 
	 * @Param username,address,phoneNumber,emailId
	 * 
	 * @return userResponseDto is the return object which includes
	 * trackId,statusMessage,statusCode
	 * 
	 */

	@Override
	public UserResponseDto register(UserRequestDto userRequestDto) {

		if (!validateUserName(userRequestDto.getUsername()) {
			throw new InvalidUserNameException(MobileConnectionContants.INVALID_USER_NAME);
		}

		if (!validPhoneNumber(userRequestDto.getNewMobileNumber())) {
			throw new InvalidUserNameException(MobileConnectionContants.INVALID_MOBILE_NUMBER);
		}

		if (!validEmailId(userRequestDto.getEmailId())) {
			throw new InvalidUserNameException(MobileConnectionContants.INVALID_EMAIL);
		}

		User checkCustomerEmail = userRepository.findByEmailId(userRequestDto.getEmailId());
		if (checkCustomerEmail != null) {
			throw new InvalidUserNameException(MobileConnectionContants.EXIST_EMAIL);
		}

		User user = new User();
		user.setUserName(userRequestDto.getUsername());
		user.setEmailId(userRequestDto.getEmailId());
		user.setAddress(userRequestDto.getAddress());
		user.setPanCardNo(generatePancard());
		user.setNewMobileNumber(userRequestDto.getNewMobileNumber());
		User userResponse = userRepository.save(user);

		Track track=new Track();
		
        track.setTrackStatus("New");
		track.set
		Track trackOrder = trackRepository.save(track);

		UserResponseDto userResponseDto = new UserResponseDto();
		userResponseDto.setTrackId(trackOrder.g);
		userResponseDto.setStatusCode(201);
		userResponseDto.setMessage("Customer Registered successfully and account created");
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

	public String generatePancard() {
		SecureRandom r = new SecureRandom();
		final String alphaCaps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		final String alpha = "abcdefghijklmnopqrstuvwxyz";
		final String numeric = "0123456789";
		int length = 8;
		String str = null ;
		String dic = alphaCaps + alpha + numeric;
		StringBuilder result= new StringBuilder();
		for (int i = 0; i < length; i++) {
			int index = r.nextInt(dic.length());
			result.append(dic.charAt(index));
			str=result.toString();
		}

		return str;
	}


}
