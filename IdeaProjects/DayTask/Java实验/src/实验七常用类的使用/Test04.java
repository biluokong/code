package 实验七常用类的使用;

import java.util.Scanner;

public class Test04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个八进制数字串（在整型数据范围内）：");
        //将输入的字符串以八进制转换为整型数据
        int num = Integer.parseInt(input.nextLine(), 8);
        //将整型数据转换为二进制并输出
        System.out.println("其转换为二进制数是：" + Integer.toBinaryString(num));
        //将整型数据输出
        System.out.println("其转换为十进制数是：" + num);
        //将整型数据转换为十六进制并输出
        System.out.println("其转换为十六进制数是：" + Integer.toHexString(num));
    }
}
