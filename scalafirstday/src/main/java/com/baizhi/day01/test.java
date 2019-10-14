package com.baizhi.day01;

public class test {
    public static void main(String[] args) {
        Greet gt=(String name) -> "hello +"+name;
        
        String rs=gt.sayHello("lushi");
        System.out.println(rs);
    }
}
