package com.shouyubang.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shouyubang.web.utils.CustomDateSerializer;
import com.shouyubang.web.utils.CustomTimeSerializer;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

/**
 * Created by KunLiu on 2017/9/3.
 */
@Entity
@Table(name="APPLICATION")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "USERID")
    private String userId;

    @Column(name = "JOBID")
    private int jobId;

    @Column(name = "JOBTITLE")
    private String jobTitle;

    @Column(name = "COMPANYID")
    private int companyId;

    @Column(name = "COMPANYNAME")
    private String companyName;

    @Column(name = "APPLYDATE")
    @DateTimeFormat(pattern="yyyy/MM/dd")
    @JsonFormat(pattern = "yyyy/MM/dd")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @JsonSerialize(using = CustomDateSerializer.class)
    private LocalDate applyDate;

    @Column(name = "process")
    private String process;

    @Column(name = "adviserId")
    private String adviserId;

    @Column(name = "status")
    private int status;

    public Application() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Application(String userId, int jobId) {
        this.userId = userId;
        this.jobId = jobId;
        this.applyDate = new LocalDate();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(LocalDate applyDate) {
        this.applyDate = applyDate;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getAdviserId() {
        return adviserId;
    }

    public void setAdviserId(String advisorId) {
        this.adviserId = advisorId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", jobId=" + jobId +
                ", jobTitle='" + jobTitle + '\'' +
                ", companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", applyDate=" + applyDate +
                ", process='" + process + '\'' +
                ", advisorId='" + adviserId + '\'' +
                ", status=" + status +
                '}';
    }
}
