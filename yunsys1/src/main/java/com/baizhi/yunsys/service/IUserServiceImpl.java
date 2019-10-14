package com.baizhi.yunsys.service;

import com.baizhi.yunsys.entity.User;
import com.baizhi.yunsys.dao.UserDao;
import com.baizhi.yunsys.exceptions.UserNameAndPasswordException;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.Name;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
@Transactional
public class IUserServiceImpl implements IUserService{
    String uuid = UUID.randomUUID().toString().replaceAll("-","");
    @Autowired
    private UserDao userDao;
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
        System.out.println("saveUser  OK");
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User queryUserByNameAndPassword(User user) {

    System.out.println("queryUserByNameAndPassword  ?");
        User user1=userDao.queryUserByNameAndPassword(user);
        if(user1==null){
            throw new UserNameAndPasswordException("用户名或者密码不正确！");
        }
        System.out.println(user1);
        return user1;

    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<User> queryUserByPage(Integer pageNow, Integer pageSize, String column, Object value) {

        Integer begin;
        begin=(pageNow-1)*pageSize;
        List<User> list=userDao.queryUserByPage(begin,pageSize,column,value);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Integer queryUserCount(String column, Object value) {
        Integer i = userDao.queryUserCount(column,value);
        return i;
    }

    @Override
    public User queryUserById(Integer id) {
        User user=userDao.queryUserById(id);
        return user;
    }

    @Override
    public void deleteByUserIds(Integer[] ids) {
        userDao.deleteByUserIds(ids);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
