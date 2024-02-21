package 团队.demo5;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Scanner;

public class practice2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入矩阵的行和列：");
        int m = input.nextInt(), n = input.nextInt();
        System.out.printf("请输入%d个元素：\n", m * n);
        int[][] arr = new int[m][n];
        IdentityHashMap<Integer, Integer> temps = new IdentityHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = input.nextInt();
                if (arr[i][j] == 0)
                    temps.put(new Integer(i), j);
            }
        }
        for (Integer i : temps.keySet()) {
            if (temps.get(i) != -1){
                for (int j = 0; j < arr[i].length; j++)
                    arr[i][j] = 0;
                for (int k = 0; k < arr.length; k++)
                    arr[k][temps.get(i)] = 0;
            }
        }
        System.out.println("输出结果为：");
        for (int[] ar : arr) {
            for (int i : ar) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
