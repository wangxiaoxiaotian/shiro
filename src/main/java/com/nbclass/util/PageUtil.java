package com.nbclass.util;
/**
 * PageUtil 主要是分页
 */
public class PageUtil {
    //分页算法
    public static Integer getPageNo(Integer limit,Integer offset){

        return offset==0 ? 1 : offset / limit + 1;
    }
}
