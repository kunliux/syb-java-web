package com.shouyubang.web.dao;

import com.shouyubang.web.model.UserProfile;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by KunLiu on 2017/8/23.
 */
@Repository("userInfoDao")
public class UserInfoDaoImpl extends AbstractDao<Integer, UserProfile> implements UserInfoDao{
    @Override
    public UserProfile getUserInfo(Integer id) {
        return getByKey(id);
    }

    @Override
    public void saveUserInfo(UserProfile userProfile) {
        persist(userProfile);
    }

    @Override
    public void updateUserInfo(UserProfile userProfile) {
        update(userProfile);
    }

    @Override
    public UserProfile getUserInfoByPhone(String phone) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("phone", phone));
        return (UserProfile) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<UserProfile> findAllUsers() {
        Criteria criteria = createEntityCriteria();
        return (List<UserProfile>) criteria.list();
    }

    public void deleteUserById(int id) {
        Query query2 = getSession().createSQLQuery("delete from PROFILE where id = :id");
        query2.setInteger("id", id);
        query2.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public int countMatchUserInfo(String phone) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("phone", phone));
        return criteria.list().size();
    }
}
