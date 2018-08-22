//package com.lzw.corp.jdk9;
//
///**
// * @author lzw
// * @date 2018/8/22
// **/
//public class TryResources {
//    public static void main(String[] args) throws IOException {
//        System.out.println(readData("test"));
//    }
//    static String readData(String message) throws IOException {
//        Reader inputString = new StringReader(message);
//        BufferedReader br = new BufferedReader(inputString);
//        try (BufferedReader br1 = br) {
//            return br1.readLine();
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        System.out.println(readData("test"));
//    }
//    static String readData(String message) throws IOException {
//        Reader inputString = new StringReader(message);
//        BufferedReader br = new BufferedReader(inputString);
//        try (br) {
//            return br.readLine();
//        }
//    }
//
//
//
//}
