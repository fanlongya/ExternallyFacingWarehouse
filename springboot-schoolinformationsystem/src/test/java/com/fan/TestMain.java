package com.fan;

import java.io.*;
import java.util.Arrays;

public class TestMain {
    public static void me(File file){
        String name=file.getName();
        if(name.contains(".tar")){
//            file.delete();
            me1(file);
            return;
        }
        if(file.isFile()){
            return;
        }
        File[] files=file.listFiles();
        for (int i = 0; i < files.length; i++) {
            File file1 = files[i];
            me(file1);
        }
    }
    public static void me1(File file){
        if(file.isFile()){
            file.delete();
        }else{
            File[] files=file.listFiles();
            for (int i = 0; i < files.length; i++) {
                File file1 = files[i];
                me(file1);
            }
            file.delete();
        }
    }
    public static void main(String[] args) {
//        File file=new File("F:\\\\javacode\\\\wai");
//        me(file);

//        method("F:\\javacode\\wai");

        String filePath="F:\\demo\\eladmin8.19";
        String PostFix=".tar";
        String copyPath="F:\\test"+"\\";
        TestMain.addPostfix(filePath, PostFix, copyPath);
    }
    private static String prefix="F:\\test\\";
    private static String postfix=".tar";

    /**
     * 为文件夹内的文件删除后缀
     * @param path 要删除后缀的路径
     * @param addPostFix 删除的后缀
     * @param copyPath 复制到的路径
     */
    public static void addPostfix(String path, String addPostFix, String copyPath){
        File file=new File(path);
        File file1=null;
        String name1=null;
        String name=file.getName();
        if(name.contains(addPostFix)){
            name1=name.substring(0,name.lastIndexOf("."));
        }else{
            name1=name;
        }
        System.out.println(name1);
        file1=new File(copyPath+name1);
        if(!file1.exists()){
            file1.mkdirs();
        }
        mar(file,file1);
    }
    public static void mar(File file,File file1){
        String name=file.getName();
        String file1Path=file1.getAbsolutePath();
        if(file.isFile()){
           cloneFile(file,file1);
           return;
        }
        File[] files=file.listFiles();
        for (int i = 0; i < files.length; i++) {
            File file2 = files[i];
            String na=file2.getName();
            String na1=null;
            if(na.contains(".tar")){
                na1=na.substring(0,na.lastIndexOf("."));
            }else{
                na1=na;
            }
            if(file2.isFile()){
                System.out.println(file2.getAbsoluteFile()+"是一个文件。");
                File file3=new File(file1Path+"\\"+na1);
                System.out.println(file1Path+"\\"+na1);
                cloneFile(file2,file3);
//                continue;
            }else{
                System.out.println(file2.getAbsoluteFile()+"是一个文件夹。");
                File file3=new File(file1Path+"\\"+na1);
                System.out.println(file1Path+"\\"+na1);
                if(!file3.exists()){
                    file3.mkdirs();
                }
                System.out.println(file3.exists()+"--"+file3.isFile());
                mar(file2,file3);
            }
        }
    }
    public static void method(String path){
        System.out.println(prefix+"------"+postfix);
        File file=new File(path);
        String name=file.getName();
        File file1=null;
        System.out.println(file.isFile());
        if(file.isFile()){
           file1= new File(prefix+name+postfix);
        }else {
            file1=new File(prefix+name);
        }
        if(!file.isFile()){
            if(file1.exists()) {
                file1.mkdir();
            }
        }
        String filePath1=file.getAbsolutePath();
        String filePath2=file1.getAbsolutePath();
        System.out.println(filePath1+"----"+filePath2);
        method1(file,file1);
//        try {
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static void method1(File file,File file1){
        System.out.println(file.getAbsoluteFile()+"------"+file1.getAbsolutePath());
        if(file.isFile()){
            cloneFile(file,file1);
            return ;
        }
        if (!file1.exists()){
            file1.mkdir();
        }
        File[] files=file.listFiles();
        String file1Name = file1.getAbsolutePath();
        for(int i=0;i<files.length;i++){
            String temp=files[i].getName();
            if(files[i].isFile()){
                File file2=new File(file1Name+"\\"+temp+postfix);
                method1(files[i],file2);
            }else{
                File file2=new File(file1Name+"\\"+temp);
                if(!file2.exists()) {
                    file2.mkdir();
                }
                method1(files[i],file2);
            }
        }
    }

    public static void cloneFile(File file,File file1){
        try {
            InputStream inputStream=new FileInputStream(file);
            OutputStream outputStream=new FileOutputStream(file1);
            byte[] bytes=new byte[1024];
            int count=inputStream.read(bytes);
            while (count!=-1){
                outputStream.write(bytes,0,count);
                count=inputStream.read(bytes);
            }
            inputStream.close();
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(!file1.exists()){
            file1.mkdir();
        }
    }

}
