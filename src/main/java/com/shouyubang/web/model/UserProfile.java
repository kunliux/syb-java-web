package com.shouyubang.web.model;

import javax.persistence.*;

/**
 * Created by KunLiu on 2017/8/10.
 */
@Entity
@Table(name="profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "AVATARURL")
    private String avatarUrl; //头像地址

    @Column(name = "NICKNAME")
    private String nickname; //真实姓名

    @Column(name = "GENDER")
    private int gender; //男1，女2，其他0

    @Column(name = "NATIONALITY")
    private String nationality; //民族

    @Column(name = "NATIVEPLACE")
    private String nativePlace; //籍贯

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMERGENCYCONTACT")
    private String emergencyContact; //紧急联系人

    @Column(name = "IDNUMBER")
    private String idNumber; //身份证号

    @Column(name = "DISABLITYNUMBER")
    private String disabilityNumber; // 残疾证号

    @Column(name = "READINGLEVEL")
    private int readingLevel; //好3，中2，差1，默认0

    @Column(name = "WRITINGLEVEL")
    private int writingLevel; //好3，中2，差1，默认0

    @Column(name = "INSURANCE")
    private int insurance; //有1，无0

    @Column(name = "CITY")
    private String city; //城市

    @Column(name = "ADDRESS")
    private String address; //常住地址

    @Column(name = "EDUCATION")
    private String education; //最高学历

    @Column(name = "ACADEMY")
    private String academy; //毕业院校

    @Column(name = "SPECIALITY")
    private String speciality; //特长

    @Column(name = "INTERESTS")
    private String interests; //兴趣爱好

    @Column(name = "EXPERIENCE")
    private String experience; //工作经历

    @Column(name = "POSITION")
    private String position; //期望职位

    @Column(name = "SALARY")
    private String salary; //期望工资

    @Column(name = "INTRODUCTION")
    private String introduction; //个人介绍

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getDisabilityNumber() {
        return disabilityNumber;
    }

    public void setDisabilityNumber(String disabilityNumber) {
        this.disabilityNumber = disabilityNumber;
    }

    public int getReadingLevel() {
        return readingLevel;
    }

    public void setReadingLevel(int readingLevel) {
        this.readingLevel = readingLevel;
    }

    public int getWritingLevel() {
        return writingLevel;
    }

    public void setWritingLevel(int writingLevel) {
        this.writingLevel = writingLevel;
    }

    public int getInsurance() {
        return insurance;
    }

    public void setInsurance(int insurance) {
        this.insurance = insurance;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "nickname='" + nickname + '\'' +
                ", gender=" + gender +
                ", nationality='" + nationality + '\'' +
                ", nativePlace='" + nativePlace + '\'' +
                ", phone='" + phone + '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", disabilityNumber='" + disabilityNumber + '\'' +
                ", readingLevel=" + readingLevel +
                ", writingLevel=" + writingLevel +
                ", insurance=" + insurance +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", education='" + education + '\'' +
                ", academy='" + academy + '\'' +
                ", speciality='" + speciality + '\'' +
                ", interests='" + interests + '\'' +
                ", experience='" + experience + '\'' +
                ", position='" + position + '\'' +
                ", salary='" + salary + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
