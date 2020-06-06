package com.nbclass.service.service.impl;

import com.nbclass.mapper.dao.StudentDao;
import com.nbclass.model.entity.Student;
import com.nbclass.service.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Student)表服务实现类
 *
 * @author 王小甜
 * @since 2019-11-01 14:59:50
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Student queryById(String stu_id) {

        return studentDao.queryById(stu_id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Student> queryAllByLimit(int offset, int limit) {
        return this.studentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public Student insert(Student student) {
        this.studentDao.insert(student);
        return student;
    }

    @Override
    public List<Student> queryAll(Student student) {
        return studentDao.queryAll(student);
    }

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Student student) {

        return this.studentDao.update(student);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {

        return this.studentDao.deleteById(id) > 0;
    }

    @Override
    public int deleteStatusBatch(List<String> id) {
        return studentDao.deleteStatusBatch(id);
    }

    @Override
    public boolean login(String name, String password) {
        return studentDao.login(name,password);
    }
}