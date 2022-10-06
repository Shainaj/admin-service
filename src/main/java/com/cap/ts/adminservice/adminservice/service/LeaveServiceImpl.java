package com.cap.ts.adminservice.adminservice.service;

import com.cap.ts.adminservice.adminservice.dto.LeaveResponseDto;
import com.cap.ts.adminservice.adminservice.entity.LeaveInfo;
import com.cap.ts.adminservice.adminservice.projection.LeaveDetailsProjection;
import com.cap.ts.adminservice.adminservice.projection.LeaveList;
import com.cap.ts.adminservice.adminservice.repository.LeaveInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LeaveServiceImpl implements  LeaveService{


    @Autowired
    LeaveInfoRepository leaveInfoRepository;


    @Override
    public LeaveResponseDto getLeaveDetails(Integer leaveId) {
        LeaveResponseDto leaveResponseDto = new LeaveResponseDto();
        try{
            if(leaveId!=null){
                final LeaveDetailsProjection leaveDetailsProjection = leaveInfoRepository.fetchLeaveDetailsByLeaveId(leaveId);
                log.info("Leave details {} ", leaveDetailsProjection.getUserId());
                leaveResponseDto.setResponse("Successful");
                leaveResponseDto.setResponseCode(200);
                leaveResponseDto.setLeaveDetailsProjection(leaveDetailsProjection);
            }else{

                leaveResponseDto.setResponseCode(400);
                leaveResponseDto.setResponse("Bad Request");
                leaveResponseDto.setLeaveDetailsProjection(null);

            }
        }catch (Exception e){
            log.error("Exception while fetching leave details {}", e.getMessage(), e);
            leaveResponseDto.setResponseCode(500);
            String message = e.getMessage().contains("SQL")?"Server Down":"Unknown Error";
            leaveResponseDto.setResponse(message);
        }
        return leaveResponseDto;
    }

    @Override
    public List<LeaveList>  getAllLeaves(){
        log.info(" Get all leave details");
         List<LeaveList> leaveDetailsProjections = null;
        try {
            leaveDetailsProjections = leaveInfoRepository.fetchAllLeaves();
        }catch (Exception e){
            log.error("Error while fetching all leaves {}", e, e.getMessage());
        }

        return  leaveDetailsProjections;
    }


}
