package com.telecom.mobileconnection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.telecom.mobileconnection.dto.UserRequestDto;
import com.telecom.mobileconnection.dto.UserResponseDto;
import com.telecom.mobileconnection.exception.UserRegistrationException;
import com.telecom.mobileconnection.service.UserService;

@RestController
@RequestMapping("/customer")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/user")
	public ResponseEntity<UserResponseDto> register(@RequestBody UserRequestDto userRequestDto)
			throws UserRegistrationException {
		UserResponseDto userResponseDto = userService.register(userRequestDto);
		return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
	}
}
