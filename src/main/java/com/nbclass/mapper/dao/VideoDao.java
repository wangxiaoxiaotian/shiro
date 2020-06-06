package com.nbclass.mapper.dao;

import com.nbclass.model.entity.Video;
import com.nbclass.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoDao  extends MyMapper<Video> {

    List<Video> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<Video>  queryAll(Video video);

    Video queryById(String class_id);

    Video queryByName(@Param("title") String title);

    int addVideo(Video video);

    int updateVideo(Video video);

    int delteById(String video_id);

    int delteBatch(List<String> video_id);
}
