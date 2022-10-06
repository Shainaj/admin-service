package com.cap.ts.adminservice.adminservice.service;

import com.cap.ts.adminservice.adminservice.dto.TimeCardResponse;
import com.cap.ts.adminservice.adminservice.entity.TimeCardInfo;
import com.cap.ts.adminservice.adminservice.projection.TimecardList;
import com.cap.ts.adminservice.adminservice.projection.TimecardProjection;

import java.util.List;

public interface TimeCardService {

    TimeCardResponse getTimeCardDetails(Integer timeCardId);

     List<TimecardList> getAllTimecards();
}
