package com.shouyubang.web.dao;

import com.shouyubang.web.model.Collection;
import com.shouyubang.web.model.Job;
import com.shouyubang.web.model.UserProfile;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by KunLiu on 2017/9/3.
 */
@Repository("collectionDao")
public class CollectionDaoImpl extends AbstractDao<Integer, Collection> implements CollectionDao {
    @Override
    public Collection getCollection(Integer id) {
        return getByKey(id);
    }

    @SuppressWarnings("unchecked")
    public int countMatchCollection(String userId, Integer jobId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("userId", userId))
                .add(Restrictions.eq("jobId", jobId));
        List<Collection> list = (List<Collection>) criteria.list();
        return list.size();
    }

    public int isJobCollected(String userId, Integer jobId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("userId", userId))
                .add(Restrictions.eq("jobId", jobId));
        Collection c = (Collection) criteria.uniqueResult();
        if (null != c) {
            return c.getStatus();
        } else {
            return 0;
        }
    }

    @Override
    public void saveCollection(Collection collection) {
        persist(collection);
    }

    @Override
    public void updateCollection(Collection collection) {
        update(collection);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Collection> listCollectionsByPhone(String phone) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("phone", phone));
        return (List<Collection>) criteria.list();
    }
}
