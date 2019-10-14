package com.baizhi.yunsys.dao;

import com.baizhi.yunsys.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public interface UserDao {
   void saveUser(User user);
   User queryUserByNameAndPassword(User user);
    List<User> queryUserByPage(
            @Param("begin") Integer begin,
            @Param("pageSize") Integer pageSize,
            @Param("column") String column,
            @Param("value")Object value
    );
    Integer queryUserCount(
            @Param("column") String column,
            @Param("value")Object value
    );
    User queryUserById(@Param("id") Integer id);

    void deleteByUserIds(@Param("id")Integer[] id);

    void updateUser(User user);
}
