package com.shouyubang.web.utils;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by KunLiu on 2017/4/4.
 */
@Service
public class TimeService {
    public String getCurTime() {
        Date curDate = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(curDate);
    }
}
