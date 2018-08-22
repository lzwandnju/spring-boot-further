package com.lzw.corp.jdk9;

/**
 * @author lzw
 * @date 2018/8/22
 **/
abstract class Handler<T> {
    public T content;

    public Handler(T content) {
        this.content = content;
    }

    abstract void handle();
}