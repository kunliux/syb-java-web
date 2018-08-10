package com.shouyubang.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.shouyubang.web.utils.CustomTimeDeserializer;
import com.shouyubang.web.utils.CustomTimeSerializer;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by KunLiu on 2017/7/26.
 */
@Entity
@Table(name="VIDEO")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "COVERURL")
    private String coverUrl;

    @Column(name = "USERID")
    private String userId;

    @Column(name = "STAFFID")
    private String staffId;

    @Column(name = "VIDEOURL")
    private String videoUrl;

    @Column(name = "UPLOADTIME")
    @DateTimeFormat(pattern="yyyyMMddHHmmss")
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @JsonSerialize(using = CustomTimeSerializer.class)
    private LocalDateTime uploadTime;

    @Column(name = "REPLYURL")
    private String replyUrl;

    @Column(name = "REPLYTIME")
    @DateTimeFormat(pattern="yyyyMMddHHmmss")
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @JsonSerialize(using = CustomTimeSerializer.class)
//    @JsonDeserialize(using = CustomTimeDeserializer.class)
    private LocalDateTime replyTime;

    @Column(name = "STATUS")
    private int status;

    @Column(name = "ORDERID")
    private String orderId;

    @Column(name = "REWARD")
    private int reward;

    public int getId() {
        return id;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getReplyUrl() {
        return replyUrl;
    }

    public void setReplyUrl(String replyUrl) {
        this.replyUrl = replyUrl;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public LocalDateTime getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(LocalDateTime uploadTime) {
        this.uploadTime = uploadTime;
    }

    public LocalDateTime getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(LocalDateTime replyTime) {
        this.replyTime = replyTime;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", staffId='" + staffId + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", uploadTime=" + uploadTime +
                ", replyUrl='" + replyUrl + '\'' +
                ", replyTime=" + replyTime +
                ", status=" + status +
                ", orderId='" + orderId + '\'' +
                ", reward=" + reward +
                '}';
    }
}
