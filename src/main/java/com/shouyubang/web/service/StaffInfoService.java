package com.shouyubang.web.service;

import com.shouyubang.web.dao.AccountDao;
import com.shouyubang.web.dao.StaffInfoDao;
import com.shouyubang.web.model.Account;
import com.shouyubang.web.model.StaffProfile;
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
public class StaffInfoService {
    
    @Autowired
    private StaffInfoDao staffInfoDao;

    @Autowired
    private AccountService accountService;



    @Transactional
    public void addStaffInfo(StaffProfile staffProfile) {
        staffInfoDao.saveStaffInfo(staffProfile);
    }

    @Transactional
    public StaffProfile getStaffInfo(String phone) {
        return staffInfoDao.getStaffInfoByPhone(phone);
    }

    @Transactional
    public List<StaffProfile> getAllStaffs() {
        return staffInfoDao.listAllStaffs();
    }


    @Transactional
    public StaffProfile findById(int id) {
        StaffProfile s= staffInfoDao.getStaffInfo(id);
//        s.setPhone(s.getPhone().substring(3));
        return  s;
    }
    @Transactional
    public void deleteStaffById(int id) {
        staffInfoDao.deleteStaffById(id);

    }

    @Transactional
    public void deleteStaffInfoByPhone(String phone) {
        staffInfoDao.deleteStaffInfoByPhone(phone);

    }

    @Transactional
    public void saveStaff(StaffProfile staff) {
        staff.setPhone("86-"+ staff.getPhone());
        staffInfoDao.saveStaffInfo(staff);
            Account entity = new Account();
            entity.setPhone( staff.getPhone());
        accountService.addStaffAccount(entity);
    }


    @Transactional
    public void updateStaffInfo(StaffProfile staff) {
        StaffProfile entity = staffInfoDao.getStaffInfoByPhone(staff.getPhone());
        if(entity!=null){
            entity.setNickname(staff.getNickname());
            entity.setGender(staff.getGender());
            entity.setAge(staff.getAge());
            entity.setIndustry(staff.getIndustry());
            entity.setOnline(staff.getOnline());
            entity.setCompany(staff.getCompany());
            entity.setProfession(staff.getProfession());
            staffInfoDao.updateStaffInfo(entity);
        } else {
            StaffProfile newProfile = new StaffProfile();
            newProfile.setPhone(staff.getPhone());
            newProfile.setNickname(staff.getNickname());
            newProfile.setGender(staff.getGender());
            newProfile.setAge(staff.getAge());
            newProfile.setIndustry(staff.getIndustry());
            newProfile.setCompany(staff.getCompany());
            newProfile.setProfession(staff.getProfession());
            staffInfoDao.saveStaffInfo(newProfile);
        }
    }



    @Transactional
    public void updateStaff(StaffProfile staff) {
        StaffProfile entity = staffInfoDao.getStaffInfoById(staff.getId());

        if(entity!=null){
            entity.setNickname(staff.getNickname());
//            entity.setPhone("86-"+ staff.getPhone());
            entity.setGender(staff.getGender());
            entity.setIndustry(staff.getIndustry());
            entity.setOnline(staff.getOnline());
        }



    }
    @Transactional
    public void updateStaffAvatar(String userId, String avatarUrl) {
        StaffProfile entity = staffInfoDao.getStaffInfoByPhone(userId);
        if(entity!=null){
            entity.setAvatarUrl(avatarUrl);
            staffInfoDao.updateStaffInfo(entity);

        }
//        if(entity2!=null) {
//            entity2.setPhone( staff.getPhone());
//        }


    }
}
