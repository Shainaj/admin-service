package com.cap.ts.adminservice.adminservice.dto;

import com.cap.ts.adminservice.adminservice.entity.UserInfo;
import com.cap.ts.adminservice.adminservice.projection.UserProjection;
import lombok.Data;

import java.util.Optional;

@Data
public class UserResponseDto {
    private Optional<UserInfo> userProjection;
    private Integer responseCode;
    private String response;

}
