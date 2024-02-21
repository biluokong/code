package com.bjpowernode.javase.实验十一IO流;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 * @author
 * @function 测试2种输入流方式的性能
 */
public class InputTest {
    public static void main(String[] args) throws IOException {
        InputTest inputTest = new InputTest();
        inputTest.testScanner();
        inputTest.testBufferReader();
    }
    public void testScanner(){
        Scanner sc = new Scanner(System.in);
        //返回自1970年1月1日0时起经过的毫秒数
        String str=sc.nextLine();
        long start = System.currentTimeMillis();
        System.out.println(str);
        while(str.length()!=0){
            str=sc.nextLine();
            System.out.println(str);
        }
        long end = System.currentTimeMillis();
        System.out.println("testScanner:"+(end - start) + "ms");
    }

    public void testBufferReader() throws IOException{
        InputStreamReader inStream=
                new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(inStream);
        String str = bf.readLine();
        long start = System.currentTimeMillis();
        System.out.println(str);
        while(str.length()!=0){
            str = bf.readLine();
            System.out.println(str);
        }
        long end = System.currentTimeMillis();
        System.out.println("testBufferReader:"+(end - start) + "ms");
    }
}
