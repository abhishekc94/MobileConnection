package com.telecom.mobileconnection.service;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.telecom.mobileconnection.repository.TrackRepository;

@RunWith(MockitoJUnitRunner.class)
public class ApproveRequestServiceImplTest {
		
	@Mock
	TrackRepository trackRepository;
		
	@Before
	public void initialize(){
			
	}

	/**
	 * Test method for {@link com.telecom.mobileconnection.service.ApproveRequestServiceImpl#approveRequestByAdmin(com.telecom.mobileconnection.dto.ApproveRequestDTO, java.lang.Integer)}.
	 */
	@Test
	public void testApproveRequestByAdmin() {
		fail("Not yet implemented");
	}

}
