package com.bjpowernode.javase.实验八抽象类;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SortTest {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Integer[] score = new Integer[10];
        System.out.println("请输入10个数：");
        for (int i = 0; i < 10; i++) {
            score[i] = input.nextInt();
        }
        input.close();
        Arrays.sort(score, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < score.length; i++) {
            System.out.print(score[i] + " ");
        }
    }
}
