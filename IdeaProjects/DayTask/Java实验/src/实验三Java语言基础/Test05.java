package 实验三Java语言基础;

import java.util.Scanner;

/**
 * 一个球从x米（x从键盘录入）高度自由落下，每次落地后反跳回原高度的一半；再落下
 * 求它在第10次落地时，共经过多少米？第10次反弹多高？
 */
public class Test05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);   //创建一个扫描仪
        System.out.println("请输入球的初始高度：");
        double x = input.nextDouble();  //从键盘的输入获得一个double类型的数
        input.close();  //关闭扫描仪
        double hSum = x;    //总高度
        double h = 0;   //第十次反弹的高度
        for (int i = 0; i < 9; i++) {
            x /= 2;     //反弹高度是原来的一半
            hSum += 2 * x;      //反弹和落下各一次，所以是二倍
        }
        h = x / 2;
        System.out.println("共经过" + hSum + "米，" + "第十次反弹" + h + "米");
    }
}
