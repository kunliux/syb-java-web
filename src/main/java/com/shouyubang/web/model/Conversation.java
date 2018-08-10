package com.shouyubang.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

/**
 * Created by KunLiu on 2017/5/26.
 */
@Entity
@Table(name="CONVERSATION")
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CALLID")
    private String callId;

    @Column(name = "CALLERID")
    private String callerId;

    @Column(name = "ANSWERID")
    private String answerId;

    @Column(name = "STARTTIME")
    @DateTimeFormat(pattern="yyyyMMddHHmmss")
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime startTime;

    @Column(name = "ENDTIME")
    @DateTimeFormat(pattern="yyyyMMddHHmmss")
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime endTime;

    @Column(name = "TYPE")
    private String type;

    public Conversation() {
    }

    public Conversation(String callId, String callerId, String answerId) {
        this.callId = callId;
        this.callerId = callerId;
        this.answerId = answerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public String getCallerId() {
        return callerId;
    }

    public void setCallerId(String callerId) {
        this.callerId = callerId;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Conversation{" +
                "id=" + id +
                ", callId='" + callId + '\'' +
                ", callerId='" + callerId + '\'' +
                ", answerId='" + answerId + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", type=" + type +
                '}';
    }
}
