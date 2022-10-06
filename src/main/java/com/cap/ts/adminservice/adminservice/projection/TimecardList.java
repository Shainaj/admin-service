package com.cap.ts.adminservice.adminservice.projection;

import java.util.Date;

public interface TimecardList {

    public Integer getTimecardId();

    public String getUserId();

    public Integer getProjectId();

    public String getProjectName();

    public Date getWeekEnding();

    public String getComments();
}
