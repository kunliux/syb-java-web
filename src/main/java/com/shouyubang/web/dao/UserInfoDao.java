package com.shouyubang.web.dao;

import com.shouyubang.web.model.UserProfile;

import java.util.List;

/**
 * Created by KunLiu on 2017/8/23.
 */
public interface UserInfoDao {

    UserProfile getUserInfo(Integer id);

    void saveUserInfo(UserProfile userProfile);

    void updateUserInfo(UserProfile userProfile);

    UserProfile getUserInfoByPhone(String phone);

    void deleteUserById(int id);

    List<UserProfile> findAllUsers();

}
