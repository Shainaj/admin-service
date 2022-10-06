package com.cap.ts.adminservice.adminservice.dto;

import com.cap.ts.adminservice.adminservice.projection.LeaveDetailsProjection;
import com.cap.ts.adminservice.adminservice.projection.TimecardProjection;
import lombok.Data;

@Data
public class TimeCardResponse {

    private TimecardProjection timecardProjection;
    private Integer responseCode;
    private String response;
}
