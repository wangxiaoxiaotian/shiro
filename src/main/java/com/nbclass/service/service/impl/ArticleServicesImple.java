package com.nbclass.service.service.impl;

import com.nbclass.mapper.dao.ArticleDao;
import com.nbclass.model.entity.Article;
import com.nbclass.service.service.ArticleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArticleServicesImple implements ArticleServices {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<Article> queryAllByLimit(int offset, int limit) {
        return articleDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Article> queryAll(Article article) {
        return articleDao.queryAll(article);
    }

    @Override
    public Article queryById(String article_id) {
        return articleDao.queryById(article_id);
    }

    @Override
    public Article queryByName(String title) {
        return articleDao.queryByName(title);
    }

    @Override
    public int addArticle(Article article) {
        return articleDao.addArticle(article);
    }

    @Override
    public int updateArticle(Article article) {
        return articleDao.updateArticle(article);
    }

    @Override
    public int delteById(String article_id) {
        return articleDao.delteById(article_id);
    }

    @Override
    public int delteBatch(List<String> article_id) {
        return articleDao.delteBatch(article_id);
    }
}
