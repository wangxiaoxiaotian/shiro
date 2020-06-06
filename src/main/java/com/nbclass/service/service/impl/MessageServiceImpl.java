package com.nbclass.service.service.impl;

import com.nbclass.mapper.dao.MessageDao;
import com.nbclass.model.entity.Message;
import com.nbclass.service.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Message)表服务实现类
 *
 * @author 王小甜
 * @since 2019-11-01 19:20:19
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {



    @Resource
    private MessageDao messageDao;

    @Override
    public List<Message> queryType(Message message) {
        return messageDao.queryType(message);
    }
    @Override
    public List<Message> queryAll(Message message) {
        return messageDao.queryAll(message);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param msgId 主键
     * @return 实例对象
     */
    @Override
    public Message queryById(String msgId) {

        return this.messageDao.queryById(msgId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Message> queryAllByLimit(int offset, int limit) {
        return this.messageDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Message message) {
        return messageDao.insert(message);
    }

    /**
     * 修改数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    @Override
    public int  update(Message message) {

        return messageDao.update(message);
    }

    /**
     * 通过主键删除数据
     *
     * @param msgId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String msgId) {

        return this.messageDao.deleteById(msgId) > 0;
    }

    @Override
    public int deleteteaStatusBatch(List<String> id) {
        return messageDao.deleteteaStatusBatch(id);
    }
}