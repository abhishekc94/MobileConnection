package com.telecom.mobileconnection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import com.telecom.mobileconnection.dto.ApproveRequestDTO;
import com.telecom.mobileconnection.dto.ApproveResponseDTO;
import com.telecom.mobileconnection.entity.Track;
import com.telecom.mobileconnection.repository.TrackRepository;

@Service
public class ApproveRequestServiceImpl implements ApproveRequestService {

	@Autowired
	TrackRepository trackRepository;	
	
	@Override
	public ApproveResponseDTO approveRequestByAdmin(ApproveRequestDTO approveRequestDTO, Integer trackId) {
		ApproveResponseDTO approveResponseDTO = new ApproveResponseDTO();
		Optional<Track> trackRecord = trackRepository.findByTrackId(trackId);
		if(trackRecord.isPresent()) {
			Track track = trackRecord.get();
			track.setTrackStatus(approveRequestDTO.getStatus());
			track.setApproverComments(approveRequestDTO.getApproverComments());
			trackRepository.save(track);
		}
		approveResponseDTO.setMessage("Success");
		approveResponseDTO.setStatusCode("200");

		return approveResponseDTO;
	}

}
