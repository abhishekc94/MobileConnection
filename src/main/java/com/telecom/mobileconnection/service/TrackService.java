package com.telecom.mobileconnection.service;

import com.telecom.mobileconnection.dto.TrackResponseDto;
import com.telecom.mobileconnection.exception.InvalidTrackIdException;

public interface TrackService {

	public TrackResponseDto getTrackDetails(Integer trackId) throws InvalidTrackIdException;
}
