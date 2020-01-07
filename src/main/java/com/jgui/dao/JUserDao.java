package com.jgui.dao;

import com.jgui.domain.JUser;

public interface JUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(JUser record);

    int insertSelective(JUser record);

    JUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JUser record);

    int updateByPrimaryKey(JUser record);
}