package com.shouyubang.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shouyubang.web.utils.CustomTimeSerializer;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import org.joda.time.LocalDateTime;
/**
 * Created by SYL on 2017/10/18.
 */
@Entity
@Table(name="ADVICE")
public class Advice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "USERID")
    private String userId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "IMG")
    private String img;

    @Column(name = "SUBMITDATE")
    @DateTimeFormat(pattern="yyyyMMdd")
    @JsonFormat(pattern = "yyyyMMdd")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @JsonSerialize(using = CustomTimeSerializer.class)
    private LocalDate submitDate;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "REPLY")
    private String reply;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public LocalDate getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(LocalDate submitDate) {
        this.submitDate = submitDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    @Override
    public String toString() {
        return "Advice{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", title='" + title + '\'' +
                ", img='" + img + '\'' +
                ", submitDate=" + submitDate +
                ", content='" + content + '\'' +
                ", reply='" + reply + '\'' +
                '}';
    }
}
