package com.shouyubang.web.service;

import com.shouyubang.web.dao.AccountDao;
import com.shouyubang.web.dao.NewsDao;
import com.shouyubang.web.dao.StaffInfoDao;
import com.shouyubang.web.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by KunLiu on 2017/8/23.
 */

@Service

@ComponentScan("com.shouyubang.web.dao")
public class NewsService {

    @Autowired
    private NewsDao newsDao;

    @Transactional
    public void saveNews(News news) {
       newsDao.saveNews(news);
    }

    @Transactional
    public void updateNews(News news) {
        News entity = newsDao.getNews(news.getId());
        if(entity!=null){
            entity.setTopic(news.getTopic());
            entity.setBody(news.getBody());
        }
    }

    @Transactional
    public News findById(int id) {
        System.out.println(newsDao.getNews(id));
        return newsDao.getNews(id);

    }

    @Transactional
    public List<News> listAllNews() {
        return newsDao.listAllNews();
    }

    @Transactional
    public void deleteNews(int id) {
        newsDao.deleteNews(id);
    }

    @Transactional
    public List<NewsList> listNewsList() {
        return newsDao.listNewsList();
    }
}
