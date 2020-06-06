package com.nbclass.service.service;

import com.nbclass.model.entity.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoServices {

    List<Video> queryAllByLimit(int offset,  int limit);

    List<Video>  queryAll(Video video);

    Video queryById(String class_id);

    Video queryByName( String title);

    int addVideo(Video video);

    int updateVideo(Video video);

    int delteById(String video_id);

    int delteBatch(List<String> video_id);
}
