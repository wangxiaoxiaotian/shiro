package com.nbclass.service.service;

import com.nbclass.model.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleServices {
    List<Article> queryAllByLimit( int offset, int limit);

    List<Article>  queryAll(Article article);

    Article queryById(String article_id);

    Article queryByName( String title);

    int addArticle(Article article);

    int updateArticle(Article article);

    int delteById(String article_id);

    int delteBatch(List<String> article_id);
}
