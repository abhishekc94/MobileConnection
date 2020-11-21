package com.telecom.mobileconnection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.mobileconnection.dto.UserRequestDto;
import com.telecom.mobileconnection.dto.UserResponseDto;
import com.telecom.mobileconnection.exception.InvalidUserNameException;
import com.telecom.mobileconnection.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/customer")
@Slf4j

public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/user")
	public ResponseEntity<UserResponseDto> register(@RequestBody UserRequestDto userRequestDto)
			throws InvalidUserNameException {
		UserResponseDto userResponseDto = userService.register(userRequestDto);
		return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
	}
}
