package com.lzw.corp.jdk9;

/**
 * @author lzw
 * @date 2018/8/22
 **/
//java9之前的代码
//public class Diamond {
//    public static void main(String[] args) {
//        Handler<Integer> intHandler = new Handler<Integer>(1) {
//            @Override
//            public void handle() {
//                System.out.println(content);
//            }
//        };
//        intHandler.handle();
//        Handler<? extends Number> intHandler1 = new Handler<Number>(2) {
//            @Override
//            public void handle() {
//                System.out.println(content);
//            }
//        };
//        intHandler1.handle();
//        Handler<?> handler = new Handler<Object>("test") {
//            @Override
//            public void handle() {
//                System.out.println(content);
//            }
//        };
//        handler.handle();
//    }
//}
//abstract class Handler<T> {
//    public T content;
//
//    public Handler(T content) {
//        this.content = content;
//    }
//
//    abstract void handle();
//}

public class Diamond {
    public static void main(String[] args) {
        Handler<Integer> intHandler = new Handler<>(1) {
            @Override
            public void handle() {
                System.out.println(content);
            }
        };
        intHandler.handle();
        Handler<? extends Number> intHandler1 = new Handler<>(2) {
            @Override
            public void handle() {
                System.out.println(content);
            }
        };
        intHandler1.handle();
        Handler<?> handler = new Handler<>("test") {
            @Override
            public void handle() {
                System.out.println(content);
            }
        };

        handler.handle();
    }
}

