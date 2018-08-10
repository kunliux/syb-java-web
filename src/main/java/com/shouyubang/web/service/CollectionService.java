package com.shouyubang.web.service;

import com.shouyubang.web.dao.CollectionDao;
import com.shouyubang.web.dao.CollectionDaoImpl;
import com.shouyubang.web.model.Collection;
import com.shouyubang.web.utils.ApiConstants;
import org.joda.time.LocalDateTime;
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
public class CollectionService {

    @Autowired
    private CollectionDaoImpl collectionDao;

    @Transactional
    public void addCollection(String userId, Integer jobId) {
        Collection collection = new Collection(userId, jobId);
        collection.setCollectTime(new LocalDateTime());
        System.out.println("MatchCollection: " + collectionDao.countMatchCollection(userId, jobId));
        if(collectionDao.countMatchCollection(userId, jobId) == 0) {
            collection.setStatus(ApiConstants.JOB_MARK);
            collectionDao.saveCollection(collection);
        } else {
            collection.setStatus(ApiConstants.JOB_MARK);
            collectionDao.updateCollection(collection);
        }
    }

    @Transactional
    public void updateCollection(String userId, Integer jobId, Integer status) {
        Collection collection = new Collection(userId, jobId);
        collection.setStatus(status);
        collectionDao.updateCollection(collection);
    }

    @Transactional
    public List<Collection> getCollections(String phone) {
        return collectionDao.listCollectionsByPhone(phone);
    }
    
}
