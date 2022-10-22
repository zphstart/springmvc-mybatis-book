package com.zph.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zph.dao.UserDao;
import com.zph.model.User;
import com.zph.service.ExportUser;

/**
 * @auther zph
 * @date 2022/9/18 - 17:40
 */
@Service
public class ExportUserImpl implements ExportUser {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> export() {
        List<User> list = userDao.findAll();
        

        return list;
    }

    private List<List<String>> head() {
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> head0 = new ArrayList<String>();
        head0.add("序号");
        List<String> head1 = new ArrayList<String>();
        head1.add("姓名");
        List<String> head2 = new ArrayList<String>();
        head2.add("密码");
        List<String> head3 = new ArrayList<String>();
        head3.add("联系电话");
        list.add(head0);
        list.add(head1);
        list.add(head2);
        list.add(head3);
        return list;
    }


}
