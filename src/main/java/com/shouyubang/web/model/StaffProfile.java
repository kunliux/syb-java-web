package com.shouyubang.web.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by KunLiu on 2015/12/13.
 */
@Entity
@Table(name="STAFF")
public class StaffProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "PHONE")
    private String phone;

    @Column(name = "AVATARURL")
    private String avatarUrl;

    @NotNull
    @Column(name = "NICKNAME")
    private String nickname;

    @NotNull
    @Column(name = "GENDER")
    private int gender;

    @Column(name = "AGE")
    private String age;

    @Column(name = "CITY")
    private String city;

    @Column(name = "INDUSTRY")
    private String industry; //行业

    @Column(name="COMPANY")
    private String company; //工作单位

    @Column(name = "PROFESSION")
    private String profession; //职业

    @Column(name = "ONLINE")
    private int online; //0离线，1在线，2离开（隐身），3忙碌

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    @Override
    public String toString() {
        return "StaffProfile{" +
                "id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", nickname='" + nickname + '\'' +
                ", gender=" + gender +
                ", age='" + age + '\'' +
                ", city='" + city + '\'' +
                ", industry='" + industry + '\'' +
                ", company='" + company + '\'' +
                ", profession='" + profession + '\'' +
                ", online=" + online +
                '}';
    }
}


