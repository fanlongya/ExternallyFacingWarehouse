package com.fan.demo2021_11_3;

public class TestMain {
    public static void main(String[] args) {
//        System.out.println("aaa");
        MyClassLoader myClassLoader=new MyClassLoader();
        try {
            Class myDemo1 = myClassLoader.findClass("MyDemo1");
            myDemo1.getName();
            try {
                MyDemo1 a = (MyDemo1)myDemo1.newInstance();
                a.demo();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
