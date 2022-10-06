package com.cap.ts.adminservice.adminservice.controller;

import com.cap.ts.adminservice.adminservice.dto.TimeCardResponse;
import com.cap.ts.adminservice.adminservice.entity.AuthorizationInfo;
import com.cap.ts.adminservice.adminservice.entity.LeaveInfo;
import com.cap.ts.adminservice.adminservice.entity.TimeCardInfo;
import com.cap.ts.adminservice.adminservice.projection.TimecardList;
import com.cap.ts.adminservice.adminservice.projection.TimecardProjection;
import com.cap.ts.adminservice.adminservice.service.TimeCardService;
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
@RequestMapping("/timecard")
@Slf4j
@Tag(name = "Timecard Api details")
public class TimecardController {

    @Autowired
    TimeCardService timeCardService;

    @Operation(summary = "Gives the detail of the user time card")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully logged in  user details",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TimeCardInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "No records found",
                    content = @Content) })
    @GetMapping("/details/{timecardId}")
    public TimeCardResponse getTimecardById(@PathVariable  Integer timecardId){

        return  timeCardService.getTimeCardDetails(timecardId);

    }

    @Operation(summary = "Gives the detail of the time application")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully fetched  leave details",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TimeCardInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "No records found",
                    content = @Content) })
    @GetMapping("/allTimecardDetails")
    public List<TimecardList> getAllTimecardDetails(){

        return timeCardService.getAllTimecards();

    }
}
