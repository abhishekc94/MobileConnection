package com.telecom.mobileconnection.repository;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.telecom.mobileconnection.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
