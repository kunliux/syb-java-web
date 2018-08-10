package com.shouyubang.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shouyubang.web.utils.CustomTimeDeserializer;
import com.shouyubang.web.utils.CustomTimeSerializer;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

/**
 * Created by KunLiu on 2017/5/31.
 */
@Entity
@Table(name="COMMENT")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "STAFFID")
    private String staffId;

    @Column(name = "USERID")
    private String userId;

    @Column(name = "CALLID")
    private String callId;

    @Column(name = "TIME")
    @DateTimeFormat(pattern="yyyyMMddHHmmss")
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @JsonSerialize(using = CustomTimeSerializer.class)
    private LocalDateTime time;

    @Column(name = "RATING")
    private int rating; //评分，整型，取值1-10

    @Column(name = "ORDERID")
    private String orderId;

    @Column(name = "REWARD")
    private int reward; //打赏，整型，100整数倍

    @Column(name = "ISANONYMOUS")
    private int isAnonymous;

    @Column(name = "CONTENT")
    private String content;

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(int isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", staffId='" + staffId + '\'' +
                ", userId='" + userId + '\'' +
                ", callId='" + callId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", time='" + time + '\'' +
                ", rating=" + rating +
                ", isAnonymous=" + isAnonymous +
                ", content='" + content + '\'' +
                '}';
    }
}
