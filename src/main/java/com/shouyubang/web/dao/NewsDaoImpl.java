package com.shouyubang.web.dao;

import com.shouyubang.web.model.News;
import com.shouyubang.web.model.NewsList;
import com.shouyubang.web.model.UserProfile;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by KunLiu on 2017/8/23.
 */
@Repository("newsDao")
public class NewsDaoImpl extends AbstractDao<Integer, News> implements NewsDao{
    @Override
    public News getNews(int id) {
        return getByKey(id);
    }

    @Override
    public void saveNews(News news) {
        persist(news);
    }

    @Override
    public void updateNews(News news) {
        update(news);
    }



    @SuppressWarnings("unchecked")
    public List<News> listAllNews() {
        Criteria criteria = createEntityCriteria();
        return (List<News>) criteria.list();
    }

    public void deleteNews(int id) {
        Query query2 = getSession().createSQLQuery("delete from News where id = :id");
        query2.setInteger("id", id);
        query2.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<NewsList> listNewsList() {
        Criteria criteria = createEntityCriteria();
        return (List<NewsList>) criteria.list();
    }

}
