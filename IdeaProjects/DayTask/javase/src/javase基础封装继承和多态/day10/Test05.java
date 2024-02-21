package javase基础封装继承和多态.day10;
/*一个四位数，恰好等于去掉它的首位数字之后所剩的三位数的3倍，这个
        四位数是多少？*/
public class Test05 {
    public static void main(String[] args) {
        for (int i = 1000; i < 10000; i++) {
            int singleDigit = i % 10;
            int tensPlace = i / 10 % 10;
            int hundreds = i / 100 %10;
            if ((hundreds * 100 + tensPlace * 10 + singleDigit) * 3 == i) {
                System.out.println("这个四位数为：" + i);
                break;
            }
        }
    }
}
