package com.shouyubang.web.dao;

import com.shouyubang.web.model.Application;

import java.util.List;

/**
 * Created by KunLiu on 2017/9/3.
 */
public interface ApplicationDao {
    Application getApplication(Integer id);

    void saveApplication(Application application);

    void updateApplication(Application application);

    List<Application> listApplicationsByUserId(String phone);


    List<Application> listApplicationsByJobId(int jobId);

    List<Application> listAllApplications();

    int countMatchApplication(String userId, Integer jobId);
}
