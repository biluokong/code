package 操作系统;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] statements = new String[2];
        String[] W = new String[2];
        ArrayList<String>[] R = new ArrayList[2];
        System.out.println("请输入两条赋值语句(一行一条)：");
        for (int i = 0; i < 2; i++) {
            statements[i] = input.nextLine();
            statements[i] = statements[i].substring(0, statements[i].length() - 1); //去掉分号
            String[] split = statements[i].split(":=");
            W[i] = split[0];
            R[i] = new ArrayList<String>();
            R[i].addAll(List.of(split[1].split("[+\\-*/]")));
            for (int j = 0; j < R[i].size(); j++)
                if (R[i].get(j).matches("^\\d"))    //去掉以数字开头的字符串
                    R[i].remove(j);
        }
        for (int i = 0; i < 2; i++) {
            for (String r : R[1 - i]) {
                if (W[i].equals(r)) {
                    System.out.print(false);
                    return;
                }
            }
        }
        if (W[0].equals(W[1]))
            System.out.print(false);
        System.out.print(true);
    }
}
