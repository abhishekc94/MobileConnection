package com.telecom.mobileconnection.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.mobileconnection.dto.ApproveRequestDTO;
import com.telecom.mobileconnection.dto.ApproveResponseDTO;
import com.telecom.mobileconnection.entity.Track;
import com.telecom.mobileconnection.exception.InvalidTrackIdException;
import com.telecom.mobileconnection.repository.TrackRepository;
import com.telecom.mobileconnection.utils.MobileConnectionContants;

@Service
public class ApproveRequestServiceImpl implements ApproveRequestService {

	@Autowired
	TrackRepository trackRepository;	
	
	@Override
	public ApproveResponseDTO approveRequestByAdmin(ApproveRequestDTO approveRequestDTO, Integer trackId) throws InvalidTrackIdException {
		ApproveResponseDTO approveResponseDTO = new ApproveResponseDTO();
		Optional<Track> trackRecord = trackRepository.findByTrackId(trackId);
		if(trackRecord.isPresent()) {
			Track track = trackRecord.get();
			track.setTrackStatus(approveRequestDTO.getStatus());
			track.setApproverComments(approveRequestDTO.getApproverComments());
			track.setApproverId(1);
			trackRepository.save(track);
		}else {
			throw new InvalidTrackIdException(MobileConnectionContants.NO_TRACK_ID_FOUND);
		}
		approveResponseDTO.setMessage("Success");
		approveResponseDTO.setStatusCode("200");

		return approveResponseDTO;
	}

}
