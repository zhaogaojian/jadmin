package com.jgui.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * j_user
 * @author 
 */
@Data
public class JUser implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String realname;

    private Byte sex;

    private LocalDateTime createtime;

    private String createby;

    private LocalDateTime updatetime;

    private String updateby;

    private static final long serialVersionUID = 1L;
}