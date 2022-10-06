package com.cap.ts.adminservice.adminservice.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="TimeCardInfo")
public class TimeCardInfo implements Serializable {

    @Id
    @Column(name = "TimecardId", nullable = false )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer timecardId;

    @Column(name = "UserId", nullable = false)
    private String userId;

    @Column(name = "ProjectId", nullable = false )
    private Integer projectId;

    @Column(name = "ProjectName", nullable = false)
    private String projectName;

    @Column(name = "WeekEnding",nullable = false)
    private Date weekEnding;

    @Column(name = "Comments")
    private String comments;


    TimeCardInfo(){

    }

    public Integer getTimecardId() {
        return timecardId;
    }

    public String getUserId() {
        return userId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public Date getWeekEnding() {
        return weekEnding;
    }

    public String getComments() {
        return comments;
    }

}
