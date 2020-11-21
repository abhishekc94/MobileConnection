package com.telecom.mobileconnection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.GetMapping;
import com.telecom.mobileconnection.dto.TrackResponseDto;
import com.telecom.mobileconnection.exception.InvalidTrackIdException;
import com.telecom.mobileconnection.service.TrackService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.mobileconnection.dto.ApproveRequestDTO;
import com.telecom.mobileconnection.dto.ApproveResponseDTO;
import com.telecom.mobileconnection.service.ApproveRequestService;

@RestController
@RequestMapping("/track")
public class TrackController {
	
	@Autowired
	ApproveRequestService approveRequestService;
	
	@Autowired
	TrackService trackService;

/**
 * @author Manisha
 * @apiNote This method will be used by Admin to approve/reject the application request for a new connection after verifying the details provided by customer. 
 *
 */
	@PutMapping("/{trackId}")
	public ResponseEntity<ApproveResponseDTO> approvalRequest(@RequestBody ApproveRequestDTO approveRequestDTO, @RequestParam Integer trackId)
	{
		return new ResponseEntity<>(approveRequestService.approveRequestByAdmin(approveRequestDTO, trackId), HttpStatus.OK);
	}

	@GetMapping("/{trackId}")
	public ResponseEntity<TrackResponseDto> getTrackDetails(@RequestParam("trackId") Integer trackId)
			throws InvalidTrackIdException {

		TrackResponseDto trackResponseDto = trackService.getTrackDetails(trackId);
		return new ResponseEntity<>(trackResponseDto, HttpStatus.OK);

	}


}
