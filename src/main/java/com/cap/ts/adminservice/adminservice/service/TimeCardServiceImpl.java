package com.cap.ts.adminservice.adminservice.service;


import com.cap.ts.adminservice.adminservice.dto.TimeCardResponse;
import com.cap.ts.adminservice.adminservice.entity.LeaveInfo;
import com.cap.ts.adminservice.adminservice.entity.TimeCardInfo;
import com.cap.ts.adminservice.adminservice.projection.TimecardList;
import com.cap.ts.adminservice.adminservice.projection.TimecardProjection;
import com.cap.ts.adminservice.adminservice.repository.TimecardInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class TimeCardServiceImpl implements  TimeCardService{

    @Autowired
    TimecardInfoRepository  timecardInfoRepository;

    @Override
    public TimeCardResponse getTimeCardDetails(Integer timeCardId) {
        TimeCardResponse timeCardResponse = new TimeCardResponse();
        try{
            if(timeCardId!=null){
                final TimecardProjection timecardProjection = timecardInfoRepository.fetchTimecardDetailsById(timeCardId);
                log.info("Leave details {} ", timecardProjection.getUserId());
                timeCardResponse.setResponse("Successful");
                timeCardResponse.setResponseCode(200);
                timeCardResponse.setTimecardProjection(timecardProjection);
            }else{

                timeCardResponse.setResponseCode(400);
                timeCardResponse.setResponse("Bad Request");
                timeCardResponse.setTimecardProjection(null);

            }
        }catch (Exception e){
            log.error("Exception while fetching leave details {}", e.getMessage(), e);
            timeCardResponse.setResponseCode(500);
            String message = e.getMessage().contains("SQL")?"Server Down":"Unknown Error";
            timeCardResponse.setResponse(message);
        }
        return timeCardResponse;
    }


    @Override
    public List<TimecardList> getAllTimecards(){
        log.info(" Get all leave details");
        List<TimecardList>  timeCardInfoList = null;
        try {
            timeCardInfoList = timecardInfoRepository.fetchAllTimecards();
        }catch (Exception e){
            log.error("Error while fetching all leaves {}", e, e.getMessage());
        }

        return  timeCardInfoList;
    }
}
