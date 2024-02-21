import java.util.ArrayList;
import java.util.Scanner;


public class 购物方案2 {
    public static ArrayList<Integer> list = new ArrayList<>();   // 创建一个ArrayList对象
    public static int[][] value;
    public static int m;
    public static int count = 0;
    public static String result = "";

    public void dfs(int sum, int step) {
        if(step == m) { //如果已达到最后一个商品
            if(sum == 1000) {   //如果钱正好花完
                for(int i = 0;i < list.size();i++) {
                    result += list.get(i)+" ";  //
                }
                result += "\n";
                count++;
            }
            return;
        } else {
            for(int i = 0;i <= value[step][1];i++) {
                sum += value[step][0] * i;
                list.add(i);
                dfs(sum, step + 1);
                sum -= value[step][0] * i;
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        购物方案2 test = new 购物方案2();
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        value = new int[m][2];
        for(int i = 0;i < m;i++) {
            int a = in.nextInt();
            int num = 1000 / a;
            value[i][0] = a;
            value[i][1] = num;
        }
        test.dfs(0, 0);
        if(count == 0)
            System.out.println("0");
        else
            System.out.println(count+"\n"+result);
    }
}