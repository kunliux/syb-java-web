package com.shouyubang.web.dao;

import com.shouyubang.web.model.NotifyModel;
import com.shouyubang.web.model.ReturnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("NotifyDao")
public class NotifyDaoImpl extends AbstractDao<Integer, NotifyModel> implements NotifyDao{
    @Override
    public void saveNotifyMsg(NotifyModel notify) {
        persist(notify);
    }
}
