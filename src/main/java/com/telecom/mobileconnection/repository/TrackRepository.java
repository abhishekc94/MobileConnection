package com.telecom.mobileconnection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;
import com.telecom.mobileconnection.entity.Track;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer>{
	
	    public Optional<Track> findByTrackId(int trackId);

	//	public void save(Optional<Track> trackRecord);
	    
}
