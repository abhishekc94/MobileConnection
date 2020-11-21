package com.telecom.mobileconnection.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.telecom.mobileconnection.dto.TrackResponseDto;
import com.telecom.mobileconnection.exception.InvalidTrackIdException;
import com.telecom.mobileconnection.service.TrackService;

@RunWith(MockitoJUnitRunner.class)
public class TrackControllerTest {

	@Mock
	TrackService trackService;

	@InjectMocks
	TrackController trackController;

	Integer trackId = 1;
	TrackResponseDto trackResponseDto = new TrackResponseDto();

	@Before
	public void setup() {
		trackResponseDto.setApproverComments("Approved");
		trackResponseDto.setTrackStatus("Completed");
	}

	@Test
	public void getTrackDetailsSuccess() throws InvalidTrackIdException {
		Mockito.when(trackService.getTrackDetails(Mockito.any())).thenReturn(trackResponseDto);
		ResponseEntity<TrackResponseDto> response = trackController.getTrackDetails(trackId);
		// expected actual
		Assert.assertEquals(200, response.getStatusCodeValue());
		Assert.assertEquals("Completed", response.getBody().getTrackStatus());
		Assert.assertEquals("Approved", response.getBody().getApproverComments());
	}

}