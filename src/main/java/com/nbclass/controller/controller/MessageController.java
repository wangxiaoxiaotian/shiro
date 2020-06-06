package com.nbclass.controller.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nbclass.model.entity.Message;
import com.nbclass.service.service.MessageService;
import com.nbclass.util.PageUtil;
import com.nbclass.util.ResultUtil;
import com.nbclass.util.UUIDUtil;
import com.nbclass.vo.base.PageResultVo;
import com.nbclass.vo.base.ResponseVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * (Message)表控制层
 *
 * @author 王小甜
 * @since 2019-11-01 20:12:31
 */
@Controller
@RequestMapping("news")
public class MessageController {

    /**
     * 服务对象
     */
    @Resource
    private MessageService messageService;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("/list")
    @ResponseBody
    public PageResultVo list( Message message, Integer limit, Integer offset){
        PageHelper.startPage(PageUtil.getPageNo(limit, offset),limit);
        List<Message> userList = messageService.queryAll(message);
        System.out.println(userList);
        PageInfo<Message> pages = new PageInfo<>(userList);
        return ResultUtil.table(userList,pages.getTotal());
    }

    @GetMapping("selectOne")
    public String selectOne(Model model,String msg_id) {
        Message message = messageService.queryById(msg_id);
        model.addAttribute("message",message);
        return "/message/messageDetail";
    }
    @RequestMapping(value = "/delete")
    @ResponseBody
    public ResponseVo deleteMsg(String msg_id){
        System.out.println(msg_id+"helloworl wangxiatotian ");
        boolean b = messageService.deleteById(msg_id);
        if(b!=true){
            return ResultUtil.error("删除信息失败");
        }else {
            return ResultUtil.success("删除信息成功");
        }
    }
    @RequestMapping("batch/delete")
    @ResponseBody
    public ResponseVo batchDeletemessage(String messageStr){
        System.out.println(messageStr);
        String[] teaIdStrs = messageStr.split(",");
        List<String> meIdList = Arrays.asList(teaIdStrs);
        System.out.println(meIdList);
        int i = messageService.deleteteaStatusBatch(meIdList);
        if (i > 0) {
            return ResultUtil.success("删除老师成功");
        } else {
            return ResultUtil.error("删除老师失败");
        }
    }
    @RequestMapping("/add")
    @ResponseBody
    public ResponseVo add(Message message){
        message.setMsg_id(UUIDUtil.getUniqueIdByUUId());
        message.setCreateTime(new Date());
        message.setUpdateTime(new Date());
        int insert = messageService.insert(message);
        if(insert>0){
            return ResultUtil.success("添加信息成功");
        }else {
            return ResultUtil.error("添加信息失败");
        }
    }
    @RequestMapping("edit")
    @ResponseBody
    public ResponseVo editMessage(Message message) {
        int update = messageService.update(message);

        if (update > 0) {
                return ResultUtil.success("编辑信息成功！");
        } else {
                return ResultUtil.error("编辑信息失败");
        }

    }



}