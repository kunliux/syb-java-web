package com.shouyubang.web.dao;

import com.shouyubang.web.model.UserCredit;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by SYL on 2017/10/30.
 */
@Repository("UserCreditDao")
public class UserCreditDaoImpl extends AbstractDao<Integer, UserCredit> implements UserCreditDao{

    @Override
    public UserCredit getUserCreditByUserId(String userId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("userId", userId));
        return (UserCredit) criteria.uniqueResult();
    }




}
