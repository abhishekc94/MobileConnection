package com.telecom.mobileconnection.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.mobileconnection.dto.AdminResponseDto;
import com.telecom.mobileconnection.service.AdminService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@GetMapping("/newConnection")
	public ResponseEntity<List<AdminResponseDto>> getListofConnections()
	{
		List<AdminResponseDto> response = new ArrayList<>();

		List<Object> connectionList = adminService.getListofConnections();
		if (!connectionList.isEmpty()) {
			for (int i = 0; i < connectionList.size(); i++) {
				
				Object[] obj = (Object[]) connectionList.get(i);
				
				AdminResponseDto dto = new AdminResponseDto();
				dto.setUserName(obj[0].toString());
				dto.setAddress(obj[1].toString());
				dto.setPanCardNo(obj[2].toString());
				dto.setNewMobileNumber(Long.valueOf(obj[3].toString()));
				dto.setMobileNumberStatus(obj[4].toString());
				dto.setTrackId(Integer.valueOf(obj[5].toString()));
				dto.setPlanId(Integer.valueOf(obj[6].toString()));
				dto.setTrackStatus(obj[7].toString());
				
				response.add(dto);
			}
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
