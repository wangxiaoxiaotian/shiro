package com.nbclass.service.service;

import com.nbclass.model.entity.Student;
import java.util.List;

/**
 * (Student)表服务接口
 *
 * @author 王小甜
 * @since 2019-11-01 14:59:50
 */
public interface StudentService {

    List<Student> queryAll(Student teacher);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Student queryById(String stu_id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Student> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    Student insert(Student student);

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    int update(Student student);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    int deleteStatusBatch(List<String> id);

    boolean login(String name,String password);
}