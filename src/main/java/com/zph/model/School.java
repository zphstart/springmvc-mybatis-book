package com.zph.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @auther zph
 * @date 2022/9/18 - 10:31
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class School {
    private int id;
    private String name;
    private Date createDate;
}
