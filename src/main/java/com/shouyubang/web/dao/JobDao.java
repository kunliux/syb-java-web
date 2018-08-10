package com.shouyubang.web.dao;

import com.shouyubang.web.model.Job;

import java.util.List;

public interface JobDao {

	Job getJob(Integer id);

	void saveJob(Job job);
	
	List<Job> listAllJobs();

	void updateJob(Job job);

	void deleteJobById(int id);
}
