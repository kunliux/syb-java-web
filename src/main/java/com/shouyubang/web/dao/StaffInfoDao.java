package com.shouyubang.web.dao;

import com.shouyubang.web.model.StaffProfile;
import com.shouyubang.web.model.UserProfile;

import java.util.List;

/**
 * Created by KunLiu on 2017/8/23.
 */
public interface StaffInfoDao {

    StaffProfile getStaffInfo(int id);

    void saveStaffInfo(StaffProfile staffProfile);

    void updateStaffInfo(StaffProfile staffProfile);

    StaffProfile getStaffInfoByPhone(String phone);

    StaffProfile getStaffInfoById(int id);

    List<StaffProfile> listAllStaffs();

    void deleteStaffById(int id);

    void deleteStaffInfoByPhone(String phone);



}
