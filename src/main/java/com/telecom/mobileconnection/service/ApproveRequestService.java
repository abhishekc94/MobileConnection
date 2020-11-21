package com.telecom.mobileconnection.service;

import com.telecom.mobileconnection.dto.ApproveRequestDTO;
import com.telecom.mobileconnection.dto.ApproveResponseDTO;
import com.telecom.mobileconnection.exception.InvalidTrackIdException;

public interface ApproveRequestService {

	public ApproveResponseDTO approveRequestByAdmin(ApproveRequestDTO approveRequestDTO, Integer trackId)throws InvalidTrackIdException;
}
