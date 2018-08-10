package com.shouyubang.web.dao;

import com.shouyubang.web.model.Collection;

import java.util.List;

/**
 * Created by KunLiu on 2017/9/3.
 */
public interface CollectionDao {
    Collection getCollection(Integer id);

    void saveCollection(Collection collection);

    void updateCollection(Collection collection);

    List<Collection> listCollectionsByPhone(String phone);
}
