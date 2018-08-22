package com.lzw.corp.jdk8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lzw
 * @date 2018/8/22
 **/
public class Reference {
    public static void main(String args[]){
        List names = new ArrayList();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);
    }
}
