package com.shouyubang.web.dao;

import com.shouyubang.web.model.Application;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by KunLiu on 2017/9/3.
 */
@Repository("applicationDao")
public class ApplicationDaoImpl extends AbstractDao<Integer, Application> implements ApplicationDao {
    @Override
    public Application getApplication(Integer id) {
        return getByKey(id);
    }

    @Override
    public void saveApplication(Application a) {
        persist(a);
    }

    @Override
    public void updateApplication(Application application) {
        update(application);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Application> listApplicationsByUserId(String userId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("userId", userId));
        return (List<Application>) criteria.list();
    }
    @Override
    @SuppressWarnings("unchecked")
    public List<Application> listApplicationsByJobId(int jobId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("jobId", jobId));
        System.out.println((List<Application>) criteria.list());
        return (List<Application>) criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Application> listAllApplications() {
        Criteria criteria = createEntityCriteria();
        System.out.println((List<Application>) criteria.list());
        return (List<Application>) criteria.list();
    }

    @SuppressWarnings("unchecked")
    public int countMatchApplication(String userId, Integer jobId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("userId", userId))
                .add(Restrictions.eq("jobId", jobId));
        return criteria.list().size();
    }
}
