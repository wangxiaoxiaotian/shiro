package com.nbclass.mapper.dao;

import com.nbclass.model.entity.Classify;
import com.nbclass.model.entity.Message;
import com.nbclass.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassDao extends MyMapper<Classify> {

    List<Classify> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<Classify>  queryAll(Classify classify);

    Classify queryById(String class_id);

    Classify queryByName(@Param("name") String name);

    int addClassify(Classify classify);

    int updateClassify(Classify classify);

    int delteById(String class_id);

    int delteBatch(List<String> class_id);

}
