package com.baizhi.yunsys.test;

import com.baizhi.yunsys.YunsysApplication;
import com.baizhi.yunsys.entity.User;
import com.baizhi.yunsys.service.IUserService;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@SpringBootTest(classes = YunsysApplication.class)
@RunWith(SpringRunner.class)


public class IUserServiceImplTest {
    @Autowired
    private IUserService iUserService;
    @Test
            public void queryUserByNameAndPassword(){
        User user=new User(123,"ls",0,"123456","1852-8-8","/asdas");
        iUserService.saveUser(user);
  //User zs = iUserService.queryUserByNameAndPassword("zs", "123456");
      //  System.out.println(zs);
    }
    @Test
    public void queryUserByPage(){
        List<User> list1 = iUserService.queryUserByPage(1,5,"sex",0);
        System.out.println(list1);
    }
    @Test
    public void queryUserCount(){
        Integer i = iUserService.queryUserCount("name","ls");
        System.out.println(i);
    }
    @Test
    public void queryUserById(){
        User user = iUserService.queryUserById(123);
        System.out.println(user);
    }
    @Test
    public void deleteByUserIds(){
        Integer [] ids = {123,256};
        iUserService.deleteByUserIds(ids);
       //System.out.println(user);
    }
    @Test
    public void updateUser(){

      //  iUserService.updateUser(123457,"sd",1,"789456","1995-2-3","/5aa");
        //System.out.println(user);
    }
}