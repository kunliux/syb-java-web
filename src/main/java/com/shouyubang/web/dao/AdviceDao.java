package com.shouyubang.web.dao;

import com.shouyubang.web.model.Advice;

import java.util.List;

/**
 * Created by SYL on 2017/10/18.
 */
public interface AdviceDao {

    Advice getAdvice(int id);

    void saveAdvice(Advice advice);

    List<Advice> listAllAdvice();

    void updateAdvice(Advice advice);
}
