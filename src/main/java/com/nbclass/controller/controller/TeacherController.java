package com.nbclass.controller.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nbclass.model.User;
import com.nbclass.model.entity.Student;
import com.nbclass.model.entity.Teacher;
import com.nbclass.service.service.TeacherService;
import com.nbclass.util.CoreConst;
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
import java.util.List;

/**
 * (Teacher)表控制层
 *
 * @author 王小甜
 * @since 2019-11-01 16:49:13
 */
@Controller
@RequestMapping("teacher")
public class TeacherController {
    /**
     * 服务对象
     */
    @Resource
    private TeacherService teacherService;

    /**用户列表数据*/
    @PostMapping("/list")
    @ResponseBody
    public PageResultVo loadUsers(Teacher teacher, Integer limit, Integer offset){
        PageHelper.startPage(PageUtil.getPageNo(limit, offset),limit);
        List<Teacher> userList = teacherService.queryAll(teacher);
        PageInfo<Teacher> pages = new PageInfo<>(userList);
        return ResultUtil.table(userList,pages.getTotal());
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public String selectOne(Model model, Integer id) {
        Teacher teacher = teacherService.queryById(id);
        model.addAttribute("teacher",teacher);
        return "/teacher/teaDetail";
    }
    @RequestMapping(value = "delete")
    @ResponseBody
    public ResponseVo deleteUser(Integer id){
        boolean b = teacherService.deleteById(id);
        if(b!=true){
            return ResultUtil.error("删除用户失败");
        }else {
            return ResultUtil.success("删除用户成功");
        }
    }
    @RequestMapping("/batch/delete")
    @ResponseBody
    public ResponseVo batchDeleteUser(String teaIdStr) {
        String[] teaIdStrs = teaIdStr.split(",");
        List<String> teaIdList = Arrays.asList(teaIdStrs);
        System.out.println(teaIdList);
        int i = teacherService.deleteteaStatusBatch(teaIdList);
        if (i > 0) {
            return ResultUtil.success("删除老师成功");
        } else {
            return ResultUtil.error("删除老师失败");
        }
    }

    @RequestMapping("/add")
    @ResponseBody
    public ResponseVo add(Teacher teacher,String confirmPassword){
        Teacher byName = teacherService.findByName(teacher.getName());
        if (null != byName) {
            return ResultUtil.error("用户名已存在");
        }
        String password = teacher.getPassword();
        if (confirmPassword != null && password != null) {
            if (!confirmPassword.equals(password)) {
                return ResultUtil.error("两次密码不一致");
            }
        }
        teacher.setTea_id(UUIDUtil.getUniqueIdByUUId());
        teacher.setStatus(CoreConst.STATUS_VALID);
        int insert = teacherService.insert(teacher);
        if(insert>0){
            return ResultUtil.success("添加老师成功");
        }else {
            return ResultUtil.error("添加老师失败");
        }
    }
    @RequestMapping("edit")
    @ResponseBody
    public ResponseVo editTea(Teacher teacher) {
        int update = teacherService.update(teacher);
        if (update > 0) {
            return ResultUtil.success("编辑老师成功！");
        } else {
            return ResultUtil.error("编辑老师失败");
        }
    }

}