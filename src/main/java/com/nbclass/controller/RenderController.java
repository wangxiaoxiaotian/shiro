package com.nbclass.controller;

import com.nbclass.exception.ZbException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * RenderController
 */
@Controller
public class RenderController {

    /*工作台*/
    @GetMapping("/workdest")
    public String workdest(){
        return "index/workdest";
    }

    /**用户列表入口*/
    @GetMapping("/users")
    public String userList(){

        return "user/list";
    }

    /*角色列表入口*/
    @GetMapping("/roles")
    public String roleList() {
        return "role/list";
    }

    /*权限列表入口*/
    @GetMapping("/permissions")
    public String permissionList(){
        return "permission/list";
    }

    /*在线用户入口*/
    @GetMapping("/online/users")
    public String onlineUsers(){
        return "onlineUsers/list";
    }
    /**
     *  学生列表入口
     * @return
     */
    @GetMapping("/student")
    public String students(){
        return "student/list";
    }

    @GetMapping("/teacher")
    public String teachers(){

        return "teacher/list";
    }

    @GetMapping("/news")
    public String message(){
        return "message/list";
    }

    /**
     * 分类入口
     * @return
     */
    @GetMapping("/classify")
    public String classify(){
        return "classify/list";
    }
    /**
     * 视频信息入口
     * @return
     */
    @GetMapping("/video")
    public String video(){

        return "video/list";
    }
    /**
     *
     * @return
     */
    @GetMapping("/article")
    public String article(){

        return "article/list";
    }

}
