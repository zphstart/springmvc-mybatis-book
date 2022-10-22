package com.zph.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @auther zph
 * @date 2022/9/18 - 10:41
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDo {
    private Integer id;
    private String username;
    private String password;
    private Integer schoolId;
    private String schoolName;
    private Date createTime;
}
