package com.telecom.mobileconnection.service;

import org.springframework.stereotype.Service;

import com.telecom.mobileconnection.dto.UserRequestDto;
import com.telecom.mobileconnection.dto.UserResponseDto;
import com.telecom.mobileconnection.exception.InvalidUserNameException;

@Service
public interface UserService {
	UserResponseDto register (UserRequestDto userRequestDto) throws InvalidUserNameException;
}

