package com.shouyubang.web.service;

import com.shouyubang.web.dao.UserInfoDao;
import com.shouyubang.web.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by KunLiu on 2017/8/23.
 */

@Service
@ComponentScan("com.shouyubang.web.dao")
public class UserInfoService {
    
    @Autowired
    private UserInfoDao userInfoDao;

    @Transactional
    public void addUserInfo(UserProfile userProfile) {
        userInfoDao.saveUserInfo(userProfile);
    }

    @Transactional
    public UserProfile getUserInfo(String phone) {
        return userInfoDao.getUserInfoByPhone(phone);
    }

    @Transactional
    public void updateUserBasicInfo(String userId, String nickname, String sign) {
        UserProfile entity = userInfoDao.getUserInfoByPhone(userId);
        if(entity!=null){
            entity.setNickname(nickname);
            entity.setIntroduction(sign);
            userInfoDao.updateUserInfo(entity);
        } else {
            UserProfile newProfile = new UserProfile();
            newProfile.setPhone(userId);
            newProfile.setNickname(nickname);
            newProfile.setIntroduction(sign);
            userInfoDao.saveUserInfo(newProfile);
        }
    }

    @Transactional
    public void updateUserAvatar(String userId, String avatarUrl) {
        UserProfile entity = userInfoDao.getUserInfoByPhone(userId);
        if(entity!=null){
            entity.setAvatarUrl(avatarUrl);
            userInfoDao.updateUserInfo(entity);
        }
    }


    @Transactional
    public void updateUser(UserProfile user) {
        UserProfile entity = userInfoDao.getUserInfoByPhone(user.getPhone());
        if(entity!=null){
            entity.setNickname(user.getNickname());
            entity.setPhone(user.getPhone());
            entity.setGender(user.getGender());
            entity.setNationality(user.getNationality());
            entity.setNativePlace(user.getNativePlace());
            entity.setEmergencyContact(user.getEmergencyContact());
            entity.setIdNumber(user.getIdNumber());
            entity.setDisabilityNumber(user.getDisabilityNumber());
            entity.setReadingLevel(user.getReadingLevel());
            entity.setWritingLevel(user.getWritingLevel());
            entity.setInsurance(user.getInsurance());
            entity.setCity(user.getCity());
            entity.setEducation(user.getEducation());
            entity.setAcademy(user.getAcademy());
            entity.setSpeciality(user.getSpeciality());
            entity.setInterests(user.getInterests());
            entity.setExperience(user.getExperience());
            entity.setPosition(user.getPosition());
            entity.setSalary(user.getSalary());
            entity.setIntroduction(user.getIntroduction());
        }
    }


@Transactional
    public List<UserProfile> findAllUsers() {

        return  userInfoDao.findAllUsers();
    }
    @Transactional
    public UserProfile findById(int id) {
        return userInfoDao.getUserInfo(id);
    }

    @Transactional
    public UserProfile findByPhone(String phone) {
        return userInfoDao.getUserInfoByPhone(phone);
    }
    @Transactional
    public void deleteUserById(int id) {
        userInfoDao.deleteUserById(id);
    }
}
