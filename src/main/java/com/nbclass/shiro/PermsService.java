package com.nbclass.shiro;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Component;

/**
 * js调用 thymeleaf 实现按钮权限
 * @Component作用类似与controller
 */
@Component("perms")
public class PermsService
{
    public boolean hasPerm(String permission)
    {

        return SecurityUtils.getSubject().isPermitted(permission);
    }
}
