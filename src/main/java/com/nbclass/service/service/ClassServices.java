package com.nbclass.service.service;

import com.nbclass.model.entity.Classify;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassServices {

    List<Classify> queryAllByLimit( int offset, int limit);

    List<Classify>  queryAll(Classify classify);

    Classify queryById(String class_id);

    Classify queryByName(String name);

    int addClassify(Classify classify);

    int updateClassify(Classify classify);

    int delteById(String class_id);

    int delteBatch(List<String> class_id);
}
