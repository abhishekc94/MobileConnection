package com.telecom.mobileconnection.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.mobileconnection.dto.TrackResponseDto;
import com.telecom.mobileconnection.exception.InvalidTrackIdException;
import com.telecom.mobileconnection.service.TrackService;

@RestController
@RequestMapping("/track")
public class TrackController {

	@Autowired
	TrackService trackService;

	@GetMapping("/{trackId}")
	public ResponseEntity<TrackResponseDto> getTrackDetails(@RequestParam("trackId") Integer trackId)
			throws InvalidTrackIdException {

		TrackResponseDto trackResponseDto = trackService.getTrackDetails(trackId);
		return new ResponseEntity<>(trackResponseDto, HttpStatus.OK);

	}

}
