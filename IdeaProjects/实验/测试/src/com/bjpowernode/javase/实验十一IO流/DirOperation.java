package com.bjpowernode.javase.实验十一IO流;

import java.io.File;
import java.io.IOException;
public class DirOperation {
    public static void main(String[] args) throws IOException {
        //在D盘下创建一个文件为HelloWorld.txt文件
        File file=new File("D:","HelloWorld.txt");
        boolean isCreate;
        try {
            isCreate = file.createNewFile();
            if (isCreate) {
                System.out.println("创建文件成功！");
            }else {
                System.out.println("创建文件失败！文件已经存在");
            }
        } catch (IOException e) {
            System.out.println("创建文件失败！");
        }
        // 判断是文件还是目录，
        if (file.isFile()) {
            System.out.println("这是一个文件");
        } else {
            System.out.println("这是一个目录");
        }
        //再创建一个目录out
        File file2=new File("D:/out");
        file2.mkdirs();
        File file3=new File("D:/out","sample.txt");
        file3.createNewFile();
        //HelloWorld.txt移动到Out目录下
        if (file.renameTo(new File(file2.getPath()+ "/"+file.getName()))){				System.out.println("文件移动成功！");
        } else {
            System.out.println("文件移动失败");
        }
        //遍历Out目录下的文件
        String[] arr=file2.list();
        for (String string : arr) {
            System.out.println(string);
        }
    }
}
