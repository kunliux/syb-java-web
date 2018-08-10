package com.shouyubang.web.service;

import com.shouyubang.web.dao.ApplicationDao;
import com.shouyubang.web.dao.JobDao;
import com.shouyubang.web.model.Application;
import com.shouyubang.web.model.Job;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by KunLiu on 2017/9/3.
 */
@Service
@ComponentScan("com.shouyubang.web.dao")
public class ApplicationService {

    @Autowired
    private ApplicationDao applicationDao;

    @Autowired
    private JobDao jobDao;

    @Transactional
    public void addApplication(String userId, Integer jobId) {
        Application application = new Application(userId, jobId);
        Job job = jobDao.getJob(jobId);
        application.setJobTitle(job.getJobTitle());
        application.setCompanyName(job.getCompany());
        application.setApplyDate(new LocalDate());
        application.setStatus(0);
        application.setProcess("审核中");
        System.out.println(application.toString());
        if(applicationDao.countMatchApplication(userId, jobId) == 0)
            applicationDao.saveApplication(application);
    }

    @Transactional
    public void updateApplication(Application application) {
        applicationDao.updateApplication(application);
    }
    @Transactional
    public void updateApplicationProcess(Application application) {
        Application entity = applicationDao.getApplication(application.getId());
        if(entity!=null){
            entity.setProcess(application.getProcess());
            System.out.println(application.getProcess());
        }
    }
    @Transactional
    public List<Application> getApplications(String phone) {
        return applicationDao.listApplicationsByUserId(phone);
    }

    @Transactional
    public List<Application> getApplicationsById(int jobId) {
        return applicationDao.listApplicationsByJobId(jobId);


    }

    @Transactional
    public Application getApplication(int id) {
        return applicationDao.getApplication(id);
    }

    @Transactional
    public List<Application> getAllApplications() {
        return applicationDao.listAllApplications();
    }

}

