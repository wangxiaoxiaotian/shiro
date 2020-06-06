package com.nbclass.model.entity;

import java.util.Date;

public class Article {
    private Integer id;
    private String article_id;
    private String title;
    private String content;
    private Date createTime;
    private Integer give;
    private Integer follow;
    private Integer cl_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getGive() {
        return give;
    }

    public void setGive(Integer give) {
        this.give = give;
    }

    public Integer getFollow() {
        return follow;
    }

    public void setFollow(Integer follow) {
        this.follow = follow;
    }

    public Integer getCl_id() {
        return cl_id;
    }

    public void setCl_id(Integer cl_id) {
        this.cl_id = cl_id;
    }
}
