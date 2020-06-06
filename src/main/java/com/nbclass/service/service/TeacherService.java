package com.nbclass.service.service;

import com.nbclass.model.entity.Teacher;

import java.util.List;

/**
 * (Teacher)表服务接口
 *
 * @author 王小甜
 * @since 2019-11-01 16:47:09
 */
public interface TeacherService {

    List<Teacher> queryAll(Teacher teacher);
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Teacher queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Teacher> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    int insert(Teacher teacher);

    /**
     * 修改数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    int update(Teacher teacher);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    int deleteteaStatusBatch(List<String> id);

    Teacher findByName(String name);
}