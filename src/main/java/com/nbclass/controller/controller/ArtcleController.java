package com.nbclass.controller.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nbclass.model.entity.Article;
import com.nbclass.model.entity.Classify;
import com.nbclass.service.service.ArticleServices;
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
@RequestMapping("article")
public class ArtcleController {
    @Autowired
    private ArticleServices articleServices;

    @RequestMapping("/list")
    @ResponseBody
    public PageResultVo list(Article article, Integer limit, Integer offset){
        PageHelper.startPage(PageUtil.getPageNo(limit, offset),limit);
        List<Article> articleList = articleServices.queryAll(article);
        PageInfo<Article> pages = new PageInfo<>(articleList);
        return ResultUtil.table(articleList,pages.getTotal());
    }
    @RequestMapping(value = "delete")
    @ResponseBody
    public ResponseVo deleteUser(String article_id){
        int b = articleServices.delteById(article_id);
        if(b>0){
            return ResultUtil.success("删除文章成功");

        }else {
            return ResultUtil.success("删除文章失败");

        }
    }
    @RequestMapping("batch/delete")
    @ResponseBody
    public ResponseVo batchDeletemessage(String artIdStr){
        String[] artIdStrs = artIdStr.split(",");
        List<String> artIdList = Arrays.asList(artIdStrs);
        System.out.println(artIdList);
        int i = articleServices.delteBatch(artIdList);
        if (i > 0) {
            return ResultUtil.success("删除文章成功");
        } else {
            return ResultUtil.error("删除文章失败");
        }
    }
    @GetMapping("selectOne")
    public String selectOne(Model model, String article_id) {
        Article article = articleServices.queryById(article_id);
        model.addAttribute("article",article);
        return "/article/articleDetail";
    }
    @RequestMapping("edit")
    @ResponseBody
    public ResponseVo editMessage(Article article) {
        int update = articleServices.updateArticle(article);
        if (update > 0) {
            return ResultUtil.success("编辑文章成功！");
        } else {
            return ResultUtil.error("编辑文章失败");
        }
    }
    @RequestMapping("/add")
    @ResponseBody
    public ResponseVo add(Article article){
        article.setArticle_id(UUIDUtil.getUniqueIdByUUId());
        article.setCreateTime(new Date());
        article.setGive(0);
        article.setFollow(0);
        int insert = articleServices.addArticle(article);
        if(insert>0){
            return ResultUtil.success("添加文章成功");
        }else {
            return ResultUtil.error("添加文章失败");
        }
    }
}
