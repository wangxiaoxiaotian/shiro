package com.nbclass.controller.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nbclass.model.entity.Student;
import com.nbclass.service.service.StudentService;
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
 * (Student)表控制层
 *
 * @author 王小甜
 * @since 2019-11-01 15:05:46
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("/list")
    @ResponseBody
    public PageResultVo demo(
        Student student, Integer limit, Integer offset){
            PageHelper.startPage(PageUtil.getPageNo(limit, offset),limit);
            List<Student> userList = studentService.queryAll(student);
            System.out.println(userList);
            PageInfo<Student> pages = new PageInfo<>(userList);
            return ResultUtil.table(userList,pages.getTotal());
    }
    @RequestMapping("/add")
    @ResponseBody
    public ResponseVo add(Student student){
        student.setStu_id(UUIDUtil.getUniqueIdByUUId());
        Student insert = studentService.insert(student);

        if(insert != null){
            return ResultUtil.success("添加用户成功");
        }else {
            return ResultUtil.error("添加用户失败");
        }
    }

    @GetMapping("selectOne")
    public String selectOne(Model model,String stu_id) {
        System.out.println(stu_id);
        Student student = studentService.queryById(stu_id);
        model.addAttribute("student", student);
        return "/student/stuDetail";
    }
    @RequestMapping(value = "delete")
    @ResponseBody
    public ResponseVo deleteUser(Integer id){
        boolean b = studentService.deleteById(id);
        if(b!=true){
            return ResultUtil.error("删除用户失败");
        }else {
            return ResultUtil.success("删除用户成功");
        }
    }
    @PostMapping("/edit")
    @ResponseBody
    public ResponseVo editStu(Student student){
        System.out.println(student.getStu_id());
        int update = studentService.update(student);
        if (update > 0) {
            return ResultUtil.success("编辑学生成功！");
        } else {
            return ResultUtil.error("编辑学生失败");
        }
    }
    @RequestMapping("/batch/delete")
    @ResponseBody
    public ResponseVo batchDeleteUser(String userIdStr) {
        String[] teaIdStrs = userIdStr.split(",");
        List<String> teaIdList = Arrays.asList(teaIdStrs);
        System.out.println(teaIdList);
        int i = studentService.deleteStatusBatch(teaIdList);
        if (i > 0) {
            return ResultUtil.success("删除学生成功");
        } else {
            return ResultUtil.error("删除学生失败");
        }
    }

}