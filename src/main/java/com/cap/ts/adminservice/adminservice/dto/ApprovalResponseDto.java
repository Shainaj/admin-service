package com.cap.ts.adminservice.adminservice.dto;

import lombok.Data;

@Data
public class ApprovalResponseDto {

    private String approvedDetails;
    private int id;
    private int count;
    private Integer responseCode;
    private String response;
}
