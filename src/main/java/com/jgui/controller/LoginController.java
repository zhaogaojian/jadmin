package com.jgui.controller;

import com.jgui.dao.JUserDao;
import com.jgui.domain.JUser;
import com.jgui.utils.StringUtil;
import com.jgui.utils.TokenUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhaogaojian
 * @Description:
 * @Date: Created in 2020/1/722:38
 */
@RestController
public class LoginController {
    @Resource
    private JUserDao userDao;
    @GetMapping("/login")
    public Map<String,Object> login(@RequestParam String username, @RequestParam String password) {

        if("zhangsan".equals(username) && "123".equals(password)){
            JUser user=new JUser();
            user.setUsername("zhangsan");
            user.setRealname("张三");
            Map<String,Object> map = new HashMap<>();
            //生成token
            String token = TokenUtil.sign(user);
            String refreshToken = StringUtil.GetUUIDString();
            if(token != ""){
                map.put("code", "10000");
                map.put("message", "认证成功");
                map.put("token", token);
                map.put("refreshtoken", refreshToken);
                return map;
            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code", "10001");
        map.put("message", "认证失败");
        map.put("token", "");
        map.put("refreshtoken", "");
        return map;
    }
}
