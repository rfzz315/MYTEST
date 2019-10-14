package com.baizhi.yunsys.entity;

import java.io.Serializable;
import  java.util.*;

public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer sex;
    private String password;
    private String birthDay;
    private String photo;

    public User() {
        super();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", password='" + password + '\'' +
                ", birthDay=" + birthDay +
                ", photo='" + photo + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getSex() {
        return sex;
    }

    public String getPassword() {
        return password;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getPhoto() {
        return photo;
    }

    public User(Integer id, String name, Integer sex, String password, String birthDay, String photo) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.password = password;
        this.birthDay = birthDay;
        this.photo = photo;
    }
}
