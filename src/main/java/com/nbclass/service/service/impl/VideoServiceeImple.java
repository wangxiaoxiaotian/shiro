package com.nbclass.service.service.impl;

import com.nbclass.mapper.dao.VideoDao;
import com.nbclass.model.entity.Video;
import com.nbclass.service.service.VideoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VideoServiceeImple implements VideoServices {
    @Autowired
    private VideoDao videoDao;

    @Override
    public List<Video> queryAllByLimit(int offset, int limit) {
        return videoDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Video> queryAll(Video video) {
        return videoDao.queryAll(video);
    }

    @Override
    public Video queryById(String class_id) {
        return videoDao.queryById(class_id);
    }

    @Override
    public Video queryByName(String title) {
        return videoDao.queryByName(title);
    }

    @Override
    public int addVideo(Video video) {
        return videoDao.addVideo(video);
    }

    @Override
    public int updateVideo(Video video) {
        return videoDao.updateVideo(video);
    }

    @Override
    public int delteById(String video_id) {
        return videoDao.delteById(video_id);
    }

    @Override
    public int delteBatch(List<String> video_id) {
        return videoDao.delteBatch(video_id);
    }
}
