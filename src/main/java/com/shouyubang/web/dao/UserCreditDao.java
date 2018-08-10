package com.shouyubang.web.dao;

import com.shouyubang.web.model.UserCredit;

/**
 * Created by SYL on 2017/10/30.
 */


public interface UserCreditDao {

    UserCredit getUserCreditByUserId(String userId);

}
