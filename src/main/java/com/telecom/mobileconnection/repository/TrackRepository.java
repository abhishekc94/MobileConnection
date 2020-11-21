package com.telecom.mobileconnection.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telecom.mobileconnection.entity.Track;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {

	public Optional<Track> findByTrackId(Integer trackId);

	@Query("SELECT t.userId from Track t " + "WHERE  t.trackStatus = :status")
	public List<Integer> getApprovedOrdersList(@Param("status") String status);

}
