package com.lzw.corp.jdk8;

/**
 * @author lzw
 * @date 2018/8/22
 **/

public interface Vehicle {
    default void print(){
        System.out.println("我是一辆车!");
    }

    static void blowHorn(){
        System.out.println("按喇叭!!!");
    }
}

