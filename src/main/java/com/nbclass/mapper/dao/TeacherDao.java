package com.nbclass.mapper.dao;

import com.nbclass.model.entity.Teacher;
import com.nbclass.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Teacher)表数据库访问层
 *
 * @author 王小甜
 * @since 2019-11-01 16:44:37
 */
public interface TeacherDao extends MyMapper<Teacher> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Teacher queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Teacher> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param teacher 实例对象
     * @return 对象列表
     */
    List<Teacher> queryAll(Teacher teacher);



    /**
     * 修改数据
     *
     * @param teacher 实例对象
     * @return 影响行数
     */
    int update(Teacher teacher);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    int deleteteaStatusBatch(List<String> id);

    Teacher selByName(String name);

}