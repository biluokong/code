package 实验三Java语言基础;

/**
 * 输出1000以内的水仙花数
 */
public class Test01 {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            int a = i % 100 % 10;   //获得i的个位数
            int b = i % 100 / 10;   //获得i的十位数
            int c = i / 100;    //获得i的百位数
            if (a*a*a + b*b*b + c*c*c == i) {       //判断i的个位、十位和百位数的三次方之和是否等于i
                System.out.println(i + " ");    //输出
            }
        }
    }
}
