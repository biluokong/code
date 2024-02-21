package 实验七常用类的使用;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = input.nextLine();  //获得输入的字符串
        input.close();
        
        char[] type = new char[50]; //定义用来获得不同字符的字符数组
        int[] count = new int[50];  //定义用来获得不同字符的个数数组
        int j = 0, m = 0;   //j用来记录不同字符在数组中的位置，m用来记录不同字符的个数
        //在当前字符串的长度中，获得不同字符的个数和不同字符的类型
        for (int i = 0; i < str.length(); i++) {
            //判断当前字符是否已经在数组中。如果不在，则将其加入数组中；如果在，则将其个数加1
            for (j = 0; j < m; j++) {
                if (str.charAt(i) == type[j]) {
                    count[j]++;
                    break;
                }
            }
            //如果j等于m，说明当前字符在数组中没有找到相同的字符，则将该新类型的字符放入数组中
            if (j == m) {
                count[m]++; //将该新类型的字符的个数设置为1
                type[m++] = str.charAt(i);  //将该新类型的字符放入数组中
            }
        }

        //输出不同的字符和其个数
        System.out.println("总共有" + j + "种不同的字符：");
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                System.out.println(type[i] + "字符：" + count[i] + "个");
            }
        }
    }
}
