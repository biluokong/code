package 团队.demo10;

import java.util.ArrayList;
import java.util.Scanner;

public class Practice1 {
    private static String result = String.valueOf(Integer.MAX_VALUE);

    public static void permutation(String x[], int m, int n) {
        if (m == n) {
            String temp = "";
            for (String s : x)
                temp += s;
            if (Integer.valueOf(result) > Integer.valueOf(temp))
                result = temp;
        }
        for (int i = m; i <= n; i++) {  //对[m,n]的数据进行全排列
            String[] t = x.clone();  //全排列前先备份
            //把第i个数据换到最前面
            String temp = x[m];
            x[m] = x[i];
            x[i] = temp;
            permutation(x, m + 1, n);   //然后对[m+1,n]的数据进行全排列
            x = t;  //在[m+1,n]全排列完后，恢复x
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        do {
            list.add(input.nextInt());
        } while (list.get(list.size() - 1) != -10000);
        list.remove(list.size() - 1);
        String[] x = new String[list.size()];
        for (int i = 0; i < list.size(); i++)
            x[i] = String.valueOf(list.get(i));
        permutation(x, 0, x.length - 1);
        System.out.println(result);
    }
}
