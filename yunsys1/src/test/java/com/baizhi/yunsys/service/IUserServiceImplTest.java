package com.baizhi.yunsys.service;

import com.baizhi.yunsys.YunsysApplication;
import com.baizhi.yunsys.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest(classes = YunsysApplication.class)
@RunWith(SpringRunner.class)
public class IUserServiceImplTest {
    @Autowired
     private  IUserService iUserService;
    @Test
    public void saveUser() {

       // User zs = iUserService.queryUserByNameAndPassword();
        //System.out.println(zs);


    }
}