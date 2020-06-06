package com.nbclass.service.service;

import com.nbclass.model.entity.Message;
import com.nbclass.model.entity.Student;

import java.util.List;

/**
 * (Message)表服务接口
 *
 * @author 王小甜
 * @since 2019-11-01 19:20:19
 */
public interface MessageService {

    List<Message> queryAll(Message message);


    List<Message> queryType(Message message);
    /**
     * 通过ID查询单条数据
     *
     * @param msgId 主键
     * @return 实例对象
     */
    Message queryById(String msgId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Message> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    int insert(Message message);

    /**
     * 修改数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    int update(Message message);

    /**
     * 通过主键删除数据
     *
     * @param msgId 主键
     * @return 是否成功
     */
    boolean deleteById(String msgId);

    int deleteteaStatusBatch(List<String> id);
}