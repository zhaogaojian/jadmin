package com.jgui.utils;

import java.util.UUID;

/**
 * @Author: zhaogaojian
 * @Description:
 * @Date: Created in 2020/1/722:50
 */
public class StringUtil {
    public static String GetUUIDString()
    {
       return UUID.randomUUID().toString();
    }

}
