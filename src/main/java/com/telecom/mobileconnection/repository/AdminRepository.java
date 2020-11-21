package com.telecom.mobileconnection.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telecom.mobileconnection.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	@Query(("SELECT u.userName, u.address, u.panCardNo, u.newMobileNumber, u.mobileNumberStatus, t.trackId, "
			+ "t.planId, t.trackStatus from User u, Track t  WHERE  t.trackStatus = 'NEW' "))
	public List<Object> getListofConnections();
}
