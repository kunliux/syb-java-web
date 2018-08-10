package com.shouyubang.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shouyubang.web.utils.CustomTimeSerializer;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

/**
 * Created by KunLiu on 2017/9/3.
 */
@Entity
@Table(name="COLLECTION")
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "USERID")
    private String userId;

    @Column(name = "JOBID")
    private Integer jobId;

    @Column(name = "COLLECTTIME")
    @DateTimeFormat(pattern="yyyyMMddHHmmss")
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @JsonSerialize(using = CustomTimeSerializer.class)
    private LocalDateTime collectTime;

    @Column(name = "STATUS")
    private int status;


    public Collection() {
    }

    public Collection(String userId, Integer jobId) {
        this.userId = userId;
        this.jobId = jobId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public LocalDateTime getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(LocalDateTime collectTime) {
        this.collectTime = collectTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", jobId=" + jobId +
                ", collectTime=" + collectTime +
                '}';
    }
}
