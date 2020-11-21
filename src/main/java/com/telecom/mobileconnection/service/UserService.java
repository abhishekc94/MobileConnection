package com.telecom.mobileconnection.service;

import com.telecom.mobileconnection.dto.UserRequestDto;
import com.telecom.mobileconnection.dto.UserResponseDto;

public interface UserService {
	UserResponseDto register(UserRequestDto userRequestDto);
}

