import java.util.Scanner;

/**
 * 从键盘输入俩个正整数N,M，1≦N≦17。
 * 找出所有的1～N位整数里，满足回文条件，且整数各数位数字之和等于M的整数，输出这些回文数的个数。
 * 例：N=3，M=8时，符合上述条件的回文数有6个
 * 8      44     161     242      323      404
 * 例：N=4，M=10时，符合上述条件的回文数有11个
 */
public class 回文整数 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入N和M（1≦N≦17）：");
        // 获得从键盘输入的M和N
        int N = input.nextInt();
        int M = input.nextInt();
        input.close();
        int count = 0;  // 回文数的个数
        Long num = new Long(-1);    // 一个整数

        // 用穷举法获得回文数的个数
        while (num.toString().length() <= N) {  // 回文数的位数不超过N
            num++;
            int sum = 0;    // 回文数的数字之和
            StringBuilder sb = new StringBuilder(num.toString());   // 将回文数转换为字符串
            //获得回文数的数字之和
            for (int i = 0; i < sb.length(); i++) {
                sum += sb.charAt(i) - '0';
            }
            // 判断该数是否是回文数以及它的数字之和是否等于M，如果是，则count加1
            if (sb.toString().equals(sb.reverse().toString()) && sum == M) {
                count++;
            }
        }
        System.out.println("符合条件的回文数有：" + count);
    }
}
