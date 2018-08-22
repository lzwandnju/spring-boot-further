package com.lzw.corp.jdk8;

/**
 * @author lzw
 * @date 2018/8/22
 **/
public interface FourWheeler {
    default void print(){
        System.out.println("我是一辆四轮车!");
    }
}