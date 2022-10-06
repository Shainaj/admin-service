package com.cap.ts.adminservice.adminservice.repository;

import com.cap.ts.adminservice.adminservice.entity.TimeCardInfo;
import com.cap.ts.adminservice.adminservice.projection.LeaveDetailsProjection;
import com.cap.ts.adminservice.adminservice.projection.TimecardList;
import com.cap.ts.adminservice.adminservice.projection.TimecardProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimecardInfoRepository extends JpaRepository<TimeCardInfo, Integer> {

    @Query(value = "SELECT ti.timecardId as timecardId, ti.userId as userId, ti.projectId as projectId, " +
            "ti.projectName as projectName, ti.weekEnding as weekEnding, ti.comments as comments, " +
            "ui.userName as userName FROM TimeCardInfo ti join UserInfo ui on ui.userId = ti.userId" +
            " WHERE ti.timecardId = :timecardId", nativeQuery = true)
    TimecardProjection fetchTimecardDetailsById(Integer timecardId);


    @Query(value = "SELECT * FROM TimeCardInfo" , nativeQuery = true)
    List<TimecardList> fetchAllTimecards();
}
