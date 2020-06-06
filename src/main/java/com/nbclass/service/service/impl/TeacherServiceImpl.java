package com.nbclass.service.service.impl;

import com.nbclass.mapper.dao.TeacherDao;
import com.nbclass.model.entity.Teacher;
import com.nbclass.service.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Teacher)表服务实现类
 *
 * @author 王小甜
 * @since 2019-11-01 16:47:09
 */
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherDao teacherDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Teacher queryById(Integer id) {
        return this.teacherDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Teacher> queryAllByLimit(int offset, int limit) {
        return this.teacherDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Teacher teacher) {

        return teacherDao.insert(teacher);
    }

    /**
     * 修改数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Teacher teacher) {
        return teacherDao.update(teacher);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {

        return this.teacherDao.deleteById(id) > 0;
    }

    @Override
    public List<Teacher> queryAll(Teacher teacher) {
        return teacherDao.queryAll(teacher);
    }

    @Override
    public int deleteteaStatusBatch(List<String> id) {
        return teacherDao.deleteteaStatusBatch(id);
    }

    @Override
    public Teacher findByName(String name) {
        return teacherDao.selByName(name);
    }
}