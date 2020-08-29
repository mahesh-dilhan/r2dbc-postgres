package com.mopus.trackerpostgress;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Traker {
    @Id
    private Integer trakerId;
    private String messageIdentifer;
    private String subscriptionId;
    private String appId;
    private String deviceId;
    private String status;
    private Date createTimeStamp;
    private Date lastUpdatedTimestamp;
    private String dl;
    private String url;
    private String title;
    private String body;
    private int isMutable;
    private String userId;
    private String emailId;
    private String recepientId;
}
