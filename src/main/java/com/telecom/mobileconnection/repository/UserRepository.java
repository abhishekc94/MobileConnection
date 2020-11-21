package com.telecom.mobileconnection.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telecom.mobileconnection.entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmailId(String emailId);

	@Transactional
	@Modifying
	@Query("UPDATE User u set u.mobileNumberStatus = :newStatus " + "WHERE  u.userId in :userIdList")
	public List<Integer> updateNewMobileNumberStatus(@Param("userIdList") List<Integer> userIdList,
			@Param("newStatus") String newStatus);

}
