package com.shouyubang.web.dao;

import com.shouyubang.web.model.Job;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("jobDao")
public class JobDaoImpl extends AbstractDao<Integer, Job> implements JobDao {

	public Job getJob(Integer id) {
		return getByKey(id);
	}

	public void saveJob(Job job) {
		persist(job);
	}

	@SuppressWarnings("unchecked")
	public List<Job> listAllJobs() {
		Criteria criteria = createEntityCriteria();
		return (List<Job>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Job> listJobsByType(Integer type) {
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("type", type));
		return (List<Job>) criteria.list();
	}

	public void updateJob(Job job) {
	    update(job);
    }

	public void deleteJobById(int id) {
		Query query2 = getSession().createSQLQuery("delete from JOB where id = :id");
		query2.setInteger("id", id);
		query2.executeUpdate();
	}

}
