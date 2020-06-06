package com.nbclass.model.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Message)实体类
 *
 * @author 王小甜
 * @since 2019-11-01 19:19:24
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 411853535468503508L;

    private Integer id;

    private String msg_id;
    
    private String name;
    
    private Integer cl_id;
    
    private String title;
    
    private String content;
    
    private Date createTime;
    
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(String msg_id) {
        this.msg_id = msg_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCl_id() {
        return cl_id;
    }

    public void setCl_id(Integer cl_id) {
        this.cl_id = cl_id;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}