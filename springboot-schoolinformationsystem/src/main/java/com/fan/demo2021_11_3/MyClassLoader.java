package com.fan.demo2021_11_3;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class MyClassLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try{
            String classPathName="F://test";
//            String classPathName="F://javacode//ExternallyFacingWarehouse//test1-myClassLoader//src//demo2021_11_3";
            File file=new File(classPathName,name+".class");
            FileInputStream fileInputStream=new FileInputStream(file);
            int size=0;
            ByteArrayOutputStream out=new ByteArrayOutputStream();
            while ((size=fileInputStream.read())!=-1){
                out.write(size);
            }
            byte[] data=out.toByteArray();
            return defineClass("com.fan.demo2021_11_3."+name , data ,0 , data.length);
        }catch (Exception e){
            e.printStackTrace();
        }
        return super.findClass(name);
    }
}
