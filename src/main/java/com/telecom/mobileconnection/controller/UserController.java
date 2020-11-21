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
/**
 * 
 * @author Jyoshna
 *
 */
public class UserController {

	@Autowired
	UserService userService;
	
	/*
	 * This method is used to register the customer by providing valid details, while
	 * registering it will generate password for the user. Once user registered
	 * successfully it will generate account for the user.
	 * 
	 * @Body firstName,lastName,dateOfBirth,mobileNumber,emailId
	 * 
	 * @return CustomerResponseDto is the return object which includes
	 * customerId,password,accountNumber,statusMessage,statusCode
	 * 
	 */
	
	@PostMapping("/save")
	public ResponseEntity<UserResponseDto> register(@RequestBody UserRequestDto userRequestDto) throws InvalidUserNameException{
		UserResponseDto userResponseDto = userService.register(userRequestDto);
		return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
	}
}

