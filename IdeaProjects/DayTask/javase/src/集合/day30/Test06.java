package 集合.day30;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*定义一个泛型为String类型的List集合，统计该集合中每个字符
（注意，不是字符串）出现的次数。例如：集合中有”abc”、”bcd”两个元素，
程序最终输出结果为：“a = 1,b = 2,c = 2,d = 1”。*/
public class Test06 {
    public static void main(String[] args) {
        List<String> str = new ArrayList<>();
        int[] count = new int[50];
        char[] type = new char[50];
        int j, n = 0;
        input(str);
        for (String s : str) {
            for (int i = 0; i < s.length(); i++) {
                char t = s.charAt(i);
                for (j = 0; j < n; j++) {
                    if (t == type[j]) {
                        count[j]++;
                        break;
                    }
                }
                if (j == n) {
                    count[n]++;
                    type[n++] = t;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(type[i] + " = " + count[i]);
        }
    }

    public static void input(List<String> str) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入你想输入字符串的数量：");
        int n = input.nextInt();
        System.out.println("请输入字符串（以回车符作为一个字符串的结束标志）：");
        for (int i = 0; i < n; i++) {
            str.add(input.next());
        }
        input.close();
    }

}
