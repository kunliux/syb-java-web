package com.shouyubang.web.dao;

import com.shouyubang.web.model.StaffProfile;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by KunLiu on 2017/8/23.
 */
@Repository("staffInfoDao")
public class StaffInfoDaoImpl extends AbstractDao<Integer, StaffProfile> implements StaffInfoDao{
    @Override
    public StaffProfile getStaffInfo(int id) {
        return getByKey(id);
    }

    @Override
    public void saveStaffInfo(StaffProfile staffProfile) {
        persist(staffProfile);
    }

    @Override
    public void updateStaffInfo(StaffProfile staffProfile) {
        update(staffProfile);
    }

    public int getStaffStatus(String staffId) {
        StaffProfile profile = getStaffInfoByPhone(staffId);
        return profile.getOnline();
    }

    public void updateStaffStatus(String staffId, Integer status) {
        StaffProfile profile = getStaffInfoByPhone(staffId);
        if(null != profile) {
            profile.setOnline(status);
            updateStaffInfo(profile);
        }
    }

    @Override
    public StaffProfile getStaffInfoByPhone(String phone) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("phone", phone));
        return (StaffProfile) criteria.uniqueResult();
    }

    @Override
    public StaffProfile getStaffInfoById(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        return (StaffProfile) criteria.uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<StaffProfile> listAllStaffs() {
        Criteria criteria = createEntityCriteria();
        return (List<StaffProfile>) criteria.list();
    }
    @Override
    public void deleteStaffById(int id) {
        Query query = getSession().createSQLQuery("delete from STAFF where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }
    @Override
    public void deleteStaffInfoByPhone(String phone) {
        Query query = getSession().createSQLQuery("delete from STAFF where phone = :phone");
        query.setString("phone", phone);
        query.executeUpdate();
    }
}
