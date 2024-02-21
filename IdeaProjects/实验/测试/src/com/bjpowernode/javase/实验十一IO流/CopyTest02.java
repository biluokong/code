package com.bjpowernode.javase.实验十一IO流;

import java.io.*;
import java.util.Scanner;

//用BufferedInputStream/BufferedOutputStream
public class CopyTest02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入你要复制的文件名(包含路径，斜杆只支持‘\\’)：");
        String str1 = input.nextLine();
        System.out.println("请输入你要复制的位置(路径最后的斜杆不用加)：");
        String str2 = input.nextLine();
        BufferedInputStream fis = null;
        BufferedOutputStream fos = null;
        try {
            fis = new BufferedInputStream(new FileInputStream(str1));
            int temp = str1.lastIndexOf('\\');
            StringBuffer str3 = new StringBuffer(str1);
            str3.delete(0, temp);
            fos = new BufferedOutputStream(new FileOutputStream(str2 + new String(str3)));
            byte[] bytes = new byte[1024 * 1024];
            int readCount = 0;
            while ((readCount = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, readCount);
            }
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            input.close();
        }
    }
}
