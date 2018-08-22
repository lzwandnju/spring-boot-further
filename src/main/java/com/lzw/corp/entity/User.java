package com.lzw.corp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


/**
 * 演示如何铜鼓builder来优雅的构建对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //rerquired
    private final String name;
    //rerquired
    private final String sex;
    //rerquired
    private final Date date;
    //rerquired
    private final String email;
    // optional
    private final int height;
    // optional
    private final String edu;
    // optional
    private final String nickName;
    // optional
    private final int weight;
    // optional
    private final String addr;

    /**
     * 私有构造器，因此Person对象的创建必须依赖于Builder
     * @param builder
     */
    private User(Builder builder) {
        this.name = builder.name;
        this.sex = builder.sex;
        this.date = builder.date;
        this.email = builder.email;
        this.height = builder.height;
        this.edu = builder.edu;
        this.nickName = builder.nickName;
        this.weight = builder.weight;
        this.addr = builder.addr;
    }

    public static class Builder{
        // required，使用final修饰
        private final String name;
        // required，使用final修饰
        private final String sex;
        // required，使用final修饰
        private final Date date;
        // required，使用final修饰
        private final String email;

        // optional，不使用final修饰
        private int height;
        // optional，不使用final修饰
        private String edu;
        // optional，不使用final修饰
        private String nickName;
        // optional，不使用final修饰
        private int weight;
        // optional，不使用final修饰
        private String addr;

        public Builder(String name, String sex, Date date, String email) {
            this.name = name;
            this.sex = sex;
            this.date = date;
            this.email = email;
        }

        // 返回Builder对象本身，链式调用
        public Builder height(int height){
            this.height = height;
            return this;
        }

        // 返回Builder对象本身，链式调用
        public Builder edu(String edu){
            this.edu = edu;
            return this;
        }

        // 返回Builder对象本身，链式调用
        public Builder nickName(String nickName){
            this.nickName = nickName;
            return this;
        }

        // 返回Builder对象本身，链式调用
        public Builder weight(int weight){
            this.weight = weight;
            return this;
        }

        // 返回Builder对象本身，链式调用
        public Builder addr(String addr){
            this.addr = addr;
            return this;
        }

        // 通过Builder构建所需Person对象，并且每次都产生新的Person对象
        public User build(){
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", date=" + date +
                ", email='" + email + '\'' +
                ", height=" + height +
                ", edu='" + edu + '\'' +
                ", nickName='" + nickName + '\'' +
                ", weight=" + weight +
                ", addr='" + addr + '\'' +
                '}';
    }
}