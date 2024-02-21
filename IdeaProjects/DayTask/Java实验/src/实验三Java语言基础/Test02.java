package 实验三Java语言基础;

/**
 * 两位数13和62具有很有趣的性质：把它们个位数字和十位数字对调，其乘积不变， 即13*62＝31*26。
 * 输入所有有这种性质的两位数对（个位与十位相同的不在此列，如11、22，重复出现的不在此列，如 13*62与62*13）
 */
public class Test02 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 10; i < 100; i++) {
            int a = i % 10 * 10 + i / 10;   //将i的个位和十位互换
            for (int j = i + 1; j < 100; j++) {     //从i+1开始，从而防止一对数重复输出
                int b = j % 10 * 10 + j / 10;   //将j的个位和十位互换
                if (i * j == a * b && j % 10 != j / 10) {   //判断是否有此性质，并且不能包含个位和十位数相同的数
                    System.out.print(i + "和" + j + " ");    //输出数对
                    count++;    //计数
                    if (count % 10 == 0) {  //用来分隔，以防一行输出太多
                        System.out.println();
                    }
                }
            }
        }
        System.out.println("\n总共有" + count + "对");
    }
}
