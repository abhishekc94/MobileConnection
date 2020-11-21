package com.telecom.mobileconnection.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.mobileconnection.dto.TrackResponseDto;
import com.telecom.mobileconnection.entity.Track;
import com.telecom.mobileconnection.exception.InvalidTrackIdException;
import com.telecom.mobileconnection.repository.TrackRepository;
import com.telecom.mobileconnection.utils.MobileConnectionContants;

@Service
public class TrackServiceImpl implements TrackService {

	@Autowired
	TrackRepository trackingRepository;

	@Override
	public TrackResponseDto getTrackDetails(Integer trackId) throws InvalidTrackIdException {

		Optional<Track> trackingDetails = trackingRepository.findByTrackId(trackId);
		if (trackingDetails.isPresent()) {
			TrackResponseDto trackingResponseDto = new TrackResponseDto();
			trackingResponseDto.setApproverComments(trackingDetails.get().getApproverComments());
			trackingResponseDto.setTrackStatus(trackingDetails.get().getTrackStatus());

			return trackingResponseDto;
		} else {
			throw new InvalidTrackIdException(MobileConnectionContants.NO_TRACK_ID_FOUND);
		}
	}

}
