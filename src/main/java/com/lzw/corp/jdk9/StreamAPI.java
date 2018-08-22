//package com.lzw.corp.jdk9;
//
//import java.util.stream.IntStream;
//import java.util.stream.Stream;
//
///**
// * @author lzw
// * @date 2018/8/22
// **/
//public class StreamAPI {
//    public static void main(String[] args) {
//        Stream.of("a","b","c","","e","f").takeWhile(s->!s.isEmpty())
//                .forEach(System.out::print);
//    }ß
//    public static void main1(String[] args) {
//        IntStream.iterate(3, x -> x < 10, x -> x+ 3).forEach(System.out::println);
//    }
//    public static void main2(String[] args) {
//        Stream.of("a","b","c","","e","f").dropWhile(s-> !s.isEmpty())
//                .forEach(System.out::print);
//    }
//    public static void main3(String[] args) {
//        long count = Stream.ofNullable(100).count();
//        System.out.println(count);
//
//        count = Stream.ofNullable(null).count();
//        System.out.println(count);
//    }
//}
