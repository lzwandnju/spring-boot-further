package com.lzw.corp.jdk8;

/**
 * @author lzw
 * @date 2018/8/22
 **/
@FunctionalInterface
public interface Supplier<T> {
    T get();
}
