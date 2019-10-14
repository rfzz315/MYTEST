package com.baizhi.yunsys.controller;

import com.baizhi.yunsys.service.IUserService;
import com.baizhi.yunsys.service.IUserServiceImpl;
import com.baizhi.yunsys.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baizhi.yunsys.entity.User;
import java.io.IOException;
import java.util.*;


@Controller
@RequestMapping(value = "/formUserManager")
public class UserController {
    private static final Logger LOGGER= LoggerFactory.getLogger(UserController.class);
@Autowired
private IUserService userService;


@PostMapping(value = "/registerUser")
@ResponseBody
    public void registerUser(User user){
        LOGGER.debug(user.toString());
        userService.saveUser(user);
    }

    @PostMapping(value = "/addUser")
    @ResponseBody
    public void addUser(User user) throws IOException {
        LOGGER.debug(user.toString());
        userService.saveUser(user);

    }

    @GetMapping(value = "/queryUserById")
    @ResponseBody
    public User queryUserById(@RequestParam(value = "id") Integer id){
        //从数据库中查询
       // return userService.queryUserById(id);
        LOGGER.debug(id+"");
        return userService.queryUserById(id);
    }
    @GetMapping(value = "/queryUserByPage")
    @ResponseBody
    public List<User> queryUserByPage(@RequestParam(value = "page",defaultValue = "1") Integer pageNow,
                                      @RequestParam(value = "rows",defaultValue = "10") Integer pageSize,
                                      @RequestParam(value = "column",required = false) String column,
                                      @RequestParam(value = "value",required = false) String value){
    LOGGER.debug(pageNow+" ,"+pageSize+" ,"+column+","+value);
    return userService.queryUserByPage(pageNow,pageSize,column,value);
    }
    @GetMapping(value = "/queryUserCount") //查询总记录数
    public Integer queryUserCount(@RequestParam(value = "column",required = false) String column,
                                  @RequestParam(value = "value",required = false) String value){
        LOGGER.debug(column+","+value);
        return userService.queryUserCount(column,value);
    }

    @DeleteMapping(value = "/delteUserByIds")
    @ResponseBody
    public void delteUserByIds(@RequestParam(value = "ids") Integer[] ids){
        LOGGER.debug(ids.toString());
        userService.deleteByUserIds(ids);
    }

    @PutMapping(value = "/updateUser")
    @ResponseBody
    public void updateUser(User user){
        LOGGER.debug(user.toString());
        //更新用户信息
        userService.updateUser(user);
    }

    @PostMapping(value = "/userLogin")
    @ResponseBody
    public User userLogin(User user){
        LOGGER.debug(user.toString());
        return  userService.queryUserByNameAndPassword(user);

    }
}
