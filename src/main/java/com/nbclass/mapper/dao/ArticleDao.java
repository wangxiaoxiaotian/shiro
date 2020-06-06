package com.nbclass.mapper.dao;

import com.nbclass.model.entity.Classify;
import com.nbclass.model.entity.Article;
import com.nbclass.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleDao extends MyMapper<Article> {

    List<Article> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<Article>  queryAll(Article article);

    Article queryById(String article_id);

    Article queryByName(@Param("title") String title);

    int addArticle(Article article);

    int updateArticle(Article article);

    int delteById(String article_id);

    int delteBatch(List<String> article_id);
}
