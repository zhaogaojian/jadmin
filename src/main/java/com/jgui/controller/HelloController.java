package com.jgui.controller;

/**
 * @Author: zhaogaojian
 * @Description:
 * @Date: Created in 2020/1/621:15
 */

import com.jgui.dao.JUserDao;
import com.jgui.domain.JUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class HelloController {
    @Resource
    private JUserDao userDao;
    @RequestMapping("/Hello")
    public String hello() {
        return userDao.selectByPrimaryKey(1).getRealname();
        //return "Hello World11";
    }
}