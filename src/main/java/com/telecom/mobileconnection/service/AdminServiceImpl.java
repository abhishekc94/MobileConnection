package com.telecom.mobileconnection.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.mobileconnection.repository.AdminRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public List<Object> getListofConnections() {
		
		return adminRepository.getListofConnections();
	}

	
}
