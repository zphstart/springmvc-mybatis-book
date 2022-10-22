package com.zph.model;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @auther zph
 * @date 2022/9/25 - 18:56
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserLog {
    private Integer id;
    private String username;
    private String password;
    private Date date;
}
