package com.zph.dao;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import com.zph.model.UserLog;

/**
 * @auther zph
 * @date 2022/9/25 - 19:01
 */
@Repository
public interface UserLogDao {

    @Insert("INSERT INTO user_log VALUES(#{id},#{username},#{password},#{date})")
    int save(UserLog userLog);

}
