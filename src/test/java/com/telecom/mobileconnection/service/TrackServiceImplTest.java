package com.telecom.mobileconnection.service;

 

import java.util.Optional;

 

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

 

import com.telecom.mobileconnection.dto.TrackResponseDto;
import com.telecom.mobileconnection.entity.Track;
import com.telecom.mobileconnection.exception.InvalidTrackIdException;
import com.telecom.mobileconnection.repository.TrackRepository;

 

@RunWith(MockitoJUnitRunner.class)
public class TrackServiceImplTest {
    
    @Mock
    TrackRepository trackRepository;
    
    @InjectMocks
    TrackServiceImpl trackServiceImpl;
    
    Track track = new Track();
    
    Integer trackId = 1;
    
    @Before
    public void setup() {
        track.setApproverComments("Approved");
        track.setTrackStatus("Completed");
    }
    
    @Test
    public void getTrackDetailsSuccess() throws InvalidTrackIdException {
        Mockito.when(trackRepository.findByTrackId(Mockito.any())).thenReturn(Optional.of(track));
        TrackResponseDto trackResponseDto = trackServiceImpl.getTrackDetails(trackId);
        Assert.assertEquals("Completed", trackResponseDto.getTrackStatus());
        Assert.assertEquals("Approved", trackResponseDto.getApproverComments());
    }
    
    @Test(expected=InvalidTrackIdException.class)
    public void noTrackIdFound() throws InvalidTrackIdException {
        Mockito.when(trackRepository.findByTrackId(Mockito.any())).thenReturn(Optional.empty());
        trackServiceImpl.getTrackDetails(trackId);
    }
    

 

}