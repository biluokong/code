package 实验八异常处理;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionSample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[5];
        int n, sum = 0;
        float average;
        //可能出现输入类型不匹配异常
        try {
            n = sc.nextInt();
            //可能出现数组下标越界异常
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                sum += a[i];
            }
            //获得输入数据的平均值并输出
            average = (float) sum / n;
            System.out.println(average);

            //若抛出了输入类型不匹配异常，就将其捕捉
        } catch (InputMismatchException e) {
            System.out.println("输入了不匹配的数据类型！");
            //若抛出了数组下标越界异常，就将其捕捉
        } catch (IndexOutOfBoundsException e) {
            System.out.println("数组下标越界引用！");
        } finally {
            System.out.println("程序运行结束");
        }
    }
}
