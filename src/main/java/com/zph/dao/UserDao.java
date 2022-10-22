package com.zph.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.zph.model.User;
import com.zph.model.UserDo;
import com.zph.model.UserDto;

/**
 * @auther zph
 * @date 2022/9/11 - 15:17
 */
@Repository
public interface UserDao {

    List<User> findAll();

    int insertUser(User user);

    @Update("UPDATE USER SET NAME=#{username},PASSWORD=#{password} WHERE ID=#{id}")
    int updateUser(User user);

    UserDo find(Integer id);

    UserDto findUserById(Integer id);

    @Select("select * from user where id = #{id}")
    User findOne(Integer id);
}
