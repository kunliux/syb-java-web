package com.shouyubang.web.dao;

import com.shouyubang.web.model.News;
import com.shouyubang.web.model.NewsList;

import java.util.List;

/**
 * Created by SYL on 2017/9/27.
 */
public interface NewsDao {

    News getNews(int id);

    void saveNews(News news);

    void updateNews(News news);

    List<News> listAllNews();

    List<NewsList> listNewsList();

    void deleteNews(int id);

}
