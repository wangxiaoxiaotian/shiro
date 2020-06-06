package com.nbclass.service.service.impl;

import com.nbclass.mapper.dao.ClassDao;
import com.nbclass.model.entity.Classify;
import com.nbclass.service.service.ClassServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassifyServicesImple implements ClassServices {

    @Autowired
    private ClassDao classDao;

    @Override
    public List<Classify> queryAllByLimit(int offset, int limit) {
        return classDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Classify> queryAll(Classify classify) {
        return classDao.queryAll(classify);
    }

    @Override
    public Classify queryById(String class_id) {
        return classDao.queryById(class_id);
    }

    @Override
    public Classify queryByName(String name) {
        return classDao.queryByName(name);
    }

    @Override
    public int addClassify(Classify classify) {
        return classDao.addClassify(classify);
    }

    @Override
    public int updateClassify(Classify classify) {
        return classDao.updateClassify(classify);
    }

    @Override
    public int delteById(String class_id) {
        return classDao.delteById(class_id);
    }

    @Override
    public int delteBatch(List<String> class_id) {
        return classDao.delteBatch(class_id);
    }
}
