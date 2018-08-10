package com.shouyubang.web.service;

import com.shouyubang.web.dao.AdviceDao;
import com.shouyubang.web.model.Advice;
import com.shouyubang.web.model.Response;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by SYL on 2017/10/18.
 */
@Service
public class AdviceService {
    @Autowired
    private AdviceDao adviceDao;

    @Transactional
    public void addAdvice(Advice advice) {
        advice.setSubmitDate(new LocalDate());
      adviceDao.saveAdvice(advice);
    }
    @Transactional
    public void updateAdvice(Advice advice) {
        Advice entity = adviceDao.getAdvice(advice.getId());
        if(entity!=null){
            entity.setReply(advice.getReply());
        }
    }
    @Transactional
    public List<Advice> listAllAdvice() {
        return adviceDao.listAllAdvice();
    }

    @Transactional
    public Advice findById(int id) {
        return adviceDao.getAdvice(id);

    }
}


