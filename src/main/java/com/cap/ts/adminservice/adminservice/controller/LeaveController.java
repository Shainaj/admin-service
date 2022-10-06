package com.cap.ts.adminservice.adminservice.controller;


import com.cap.ts.adminservice.adminservice.dto.LeaveResponseDto;
import com.cap.ts.adminservice.adminservice.entity.LeaveInfo;
import com.cap.ts.adminservice.adminservice.projection.LeaveDetailsProjection;
import com.cap.ts.adminservice.adminservice.projection.LeaveList;
import com.cap.ts.adminservice.adminservice.service.LeaveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/leave")
@Slf4j
@Tag(name = "Leave Api details")
public class LeaveController {


    @Autowired
    LeaveService  leaveService;

    @Operation(summary = "Gives the detail of the leave application by leaveId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully fetched  leave details",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = LeaveInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "No records found",
                    content = @Content) })
    @GetMapping("/leaveDetails/{leaveId}")
    public LeaveResponseDto getLeaveDetails(@PathVariable Integer leaveId){

        return leaveService.getLeaveDetails(leaveId);

    }

    @Operation(summary = "Gives the detail of the leave application by leaveId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully fetched  leave details",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = LeaveInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "No records found",
                    content = @Content) })
    @GetMapping("/allLeaveDetails")
    public List<LeaveList> getAllLeaveDetails(){

        return leaveService.getAllLeaves();

    }
}
