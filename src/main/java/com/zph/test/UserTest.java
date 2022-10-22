package com.zph.test;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zph.dao.UserDao;
import com.zph.model.User;
import com.zph.model.UserDo;
import com.zph.model.UserDto;

/**
 * @auther zph
 * @date 2022/9/11 - 16:16
 */
public class UserTest extends BaseJunit4Test{

    @Resource
    private UserDao userDao;

    @Resource
    private SqlSessionFactoryBean sqlSessionFactoryBean;

    @Test
    public void testFindAll(){
        List<User> list = userDao.findAll();
        System.out.println(list);
    }

    @Test
    public void testInsert(){
        User user = new User(null, "王五", "123456");
        int num = userDao.insertUser(user);
        System.out.println(user);
    }

    @Test
    public void testUpdate(){
        User user = new User(5, "zhaosi", "23432");
        int num = userDao.updateUser(user);
        System.out.println(userDao.findAll());
    }

    @Test
    public void testFind(){
        UserDo user = userDao.find(1);
        System.out.println(user);
    }

    @Test
    public void testFindUser(){
        UserDto user = userDao.findUserById(1);
        System.out.println(user);
    }
    @Test
    public void testPageHelper(){
        PageHelper.startPage(0, 3);
        List<User> users = userDao.findAll();
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        System.err.println(userPageInfo);
    }

    @Test
    public void testSqlSession() throws Exception {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        UserDao userDao1 = sqlSession.getMapper(UserDao.class);
        userDao.findOne(1);
//        sqlSession.commit();
        userDao1.findOne(1);
    }
}
