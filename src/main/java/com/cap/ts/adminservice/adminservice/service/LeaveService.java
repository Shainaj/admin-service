package com.cap.ts.adminservice.adminservice.service;

import com.cap.ts.adminservice.adminservice.dto.LeaveResponseDto;
import com.cap.ts.adminservice.adminservice.entity.LeaveInfo;
import com.cap.ts.adminservice.adminservice.projection.LeaveDetailsProjection;
import com.cap.ts.adminservice.adminservice.projection.LeaveList;

import java.util.List;

public interface LeaveService {

    LeaveResponseDto getLeaveDetails(Integer leaveId);

    public List<LeaveList> getAllLeaves();
}
