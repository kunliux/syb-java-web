package com.shouyubang.web.service;

import com.shouyubang.web.dao.UserCreditDao;
import com.shouyubang.web.model.UserCredit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by SYL on 2017/10/30.
 */
@Service
public class UserCreditService {

    @Autowired
    private UserCreditDao userCreditDao;

    @Transactional
    public UserCredit getUserCredit(String userId) {
        return userCreditDao.getUserCreditByUserId(userId);
    }

}
