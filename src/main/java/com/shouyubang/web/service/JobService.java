package com.shouyubang.web.service;

import com.shouyubang.web.dao.*;
import com.shouyubang.web.model.Job;
import com.shouyubang.web.model.Response;
import com.shouyubang.web.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KunLiu on 2017/8/9.
 */

@Service
@ComponentScan("com.shouyubang.web.dao")
public class JobService {
    @Autowired
    private JobDaoImpl jobDao;

    @Autowired
    private CollectionDaoImpl collectionDao;

    @Autowired
    private UserInfoDaoImpl userInfoDao;

    @Transactional
    public List<Job> getAllJobs() {
        return jobDao.listAllJobs();
    }

    @Transactional
    public List<Job> getJobsByType(Integer type) {
        if(type == 0) {
            return jobDao.listAllJobs();
        } else {
            return jobDao.listJobsByType(type);
        }
    }

    @Transactional
    public Response getJob(String userId, Integer jobId) {
        Response response = new Response(16, "SUCCESS");
        if(userInfoDao.countMatchUserInfo(userId) == 0) {
            response.setCode(-1);
            response.setMessage("未完善个人资料");
            return response;
        }
        Job job = jobDao.getJob(jobId);
        job.setCollected(collectionDao.isJobCollected(userId, jobId));
        String json = JsonUtil.toJSon(job);
        response.setData(json);
        return response;
    }
    @Transactional
    public void saveJob(Job job) {
        jobDao.saveJob(job);
    }

    @Transactional
    public Job findById(int id) {
        return jobDao.getJob(id);
    }

    @Transactional
    public void updateJob(Job job) {
        Job entity = jobDao.getJob(job.getId());
        if(entity!=null){
            entity.setJobTitle(job.getJobTitle());
            entity.setType(job.getType());
            entity.setCompany(job.getCompany());
            entity.setCity(job.getCity());
            entity.setDistrict(job.getDistrict());
            entity.setWorkplace(job.getWorkplace());
            entity.setMinSalary(job.getMinSalary());
            entity.setMaxSalary(job.getMaxSalary());
            entity.setGender(job.getGender());
            entity.setMinAge(job.getMinAge());
            entity.setMaxAge(job.getMaxAge());
            entity.setJobContent(job.getJobContent());
            entity.setRequirement(job.getRequirement());
            entity.setWorkTime(job.getWorkTime());
            entity.setSalary(job.getSalary());
            entity.setInsurance(job.getInsurance());
            entity.setRoomBoard(job.getRoomBoard());
            entity.setBenefits(job.getBenefits());
            entity.setContract(job.getContract());
            entity.setEducation(job.getEducation());
            entity.setBenefits(job.getBenefits());
            entity.setAmount(job.getAmount());
            entity.setDisabilityType(job.getDisabilityType());
            entity.setRemark(job.getRemark());

        }
    }
    @Transactional
    public void deleteJobById(int id) {
        jobDao.deleteJobById(id);
    }
}
