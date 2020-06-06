package com.nbclass.controller.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nbclass.model.entity.Classify;
import com.nbclass.model.entity.Message;
import com.nbclass.service.service.ClassServices;
import com.nbclass.service.service.MessageService;
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
@RequestMapping("/classify")
public class ClassifyController {

    /**
     */
    @Autowired
    private ClassServices classServices;

    @RequestMapping("/list")
    @ResponseBody
    public PageResultVo list(Classify classify, Integer limit, Integer offset){
        PageHelper.startPage(PageUtil.getPageNo(limit, offset),limit);
        List<Classify> classList = classServices.queryAll(classify);
        PageInfo<Classify> pages = new PageInfo<>(classList);
        return ResultUtil.table(classList,pages.getTotal());
    }
    @RequestMapping(value = "delete")
    @ResponseBody
    public ResponseVo deleteUser(String class_id){
        int b = classServices.delteById(class_id);
        if(b>0){
            return ResultUtil.success("删除分类成功");

        }else {
            return ResultUtil.success("删除分类失败");

        }
    }
    @RequestMapping("/add")
    @ResponseBody
    public ResponseVo add(Classify classify){
        classify.setClass_id(UUIDUtil.getUniqueIdByUUId());
        int insert = classServices.addClassify(classify);
        if(insert>0){
            return ResultUtil.success("添加分类成功");
        }else {
            return ResultUtil.error("添加分类失败");
        }
    }
    @RequestMapping("edit")
    @ResponseBody
    public ResponseVo editMessage(Classify classify) {
        int update = classServices.updateClassify(classify);
        if (update > 0) {
            return ResultUtil.success("编辑信息成功！");
        } else {
            return ResultUtil.error("编辑信息失败");
        }
    }

    @GetMapping("selectOne")
    public String selectOne(Model model, String class_id) {
        Classify classify = classServices.queryById(class_id);
        model.addAttribute("classify",classify);
        return "/classify/classifyDetail";
    }

    @RequestMapping("batch/delete")
    @ResponseBody
    public ResponseVo batchDeletemessage(String classIdStr){
        String[] classIdStrs = classIdStr.split(",");
        List<String> classIdList = Arrays.asList(classIdStrs);
        System.out.println(classIdList);
        int i = classServices.delteBatch(classIdList);
        if (i > 0) {
            return ResultUtil.success("删除老师成功");
        } else {
            return ResultUtil.error("删除老师失败");
        }
    }

}
