package com.baizhi.yunsys.service;

import com.baizhi.yunsys.dao.UserDao;
import com.baizhi.yunsys.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.PrivateKey;
import java.util.Date;
import java.util.List;

public interface IUserService{
    void saveUser(User user);
    User queryUserByNameAndPassword(User user);
    /***
     *
     * @param pageNow
     * @param pageSize
     * @param column 模糊查询列
     * @param value  模糊值
     * @return
     */
    List<User> queryUserByPage(Integer pageNow, Integer pageSize,
                               String column, Object value);
    Integer queryUserCount(String column, Object value);
    User queryUserById(Integer id);
    void deleteByUserIds(Integer[] ids);
    void updateUser(User user);
}
