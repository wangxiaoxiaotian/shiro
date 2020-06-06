package com.nbclass.controller.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nbclass.model.entity.Message;
import com.nbclass.model.entity.Video;
import com.nbclass.service.service.VideoServices;
import com.nbclass.util.PageUtil;
import com.nbclass.util.ResultUtil;
import com.nbclass.util.UUIDUtil;
import com.nbclass.vo.base.PageResultVo;
import com.nbclass.vo.base.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("video")
public class VideoController {

    @Autowired
    private VideoServices videoServices;


    @RequestMapping("/list")
    @ResponseBody
    public PageResultVo list(Video video, Integer limit, Integer offset){
        PageHelper.startPage(PageUtil.getPageNo(limit, offset),limit);
        List<Video> userList = videoServices.queryAll(video);
        System.out.println(userList);
        PageInfo<Video> pages = new PageInfo<>(userList);
        return ResultUtil.table(userList,pages.getTotal());
    }
    @GetMapping("selectOne")
    public String selectOne(Model model, String video_id) {
        Video video = videoServices.queryById(video_id);
        model.addAttribute("video",video);
        return "/video/videoDetail";
    }
    @RequestMapping("edit")
    @ResponseBody
    public ResponseVo editMessage(Video video) {
        int i = videoServices.updateVideo(video);

        if (i > 0) {
            return ResultUtil.success("编辑视频成功！");
        } else {
            return ResultUtil.error("编辑视频失败");
        }

    }
    @RequestMapping(value = "/delete")
    @ResponseBody
    public ResponseVo deleteMsg(String video_id){
        System.out.println(video_id);
        int i = videoServices.delteById(video_id);
        if(i>0){
            return ResultUtil.success("删除信息成功");
        }else {
            return ResultUtil.error("删除信息失败");
        }
    }
    @RequestMapping("batch/delete")
    @ResponseBody
    public ResponseVo batchDeletemessage(String video_id){
        String[] videoIdStrs = video_id.split(",");
        List<String> viIdList = Arrays.asList(videoIdStrs);
        System.out.println(viIdList);
        int i = videoServices.delteBatch(viIdList);
        if (i > 0) {
            return ResultUtil.success("删除老师成功");
        } else {
            return ResultUtil.error("删除老师失败");
        }
    }
    @RequestMapping("/add")
    @ResponseBody
    public ResponseVo add(Video video){
        video.setVideo_id(UUIDUtil.getUniqueIdByUUId());
        video.setGive(0);
        video.setFollow(0);
        int insert = videoServices.addVideo(video);
        if(insert>0){
            return ResultUtil.success("添加信息成功");
        }else {
            return ResultUtil.error("添加信息失败");
        }
    }


}
