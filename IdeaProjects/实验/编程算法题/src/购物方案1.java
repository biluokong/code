import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * 公司发了某商店的购物券1000元，限定只能购买店中的m种商品。每种商品的价格分别为：n1,n2,…;要求程序列出所有的正好能消费完该购物券的不同购物方法。
 *    程序输入：
 *    第一行是一个整数m，代表可购买的商品的种类数。
 * 接下来是m个整数，每个1行，分别代表着m种商品的单价。
 * 程序输出：
 * 第一行是一个整数，表示共有多少种方案
 * 第二行开始，每种方案占1行，表示每种商品购买的数量，中间用空格分隔。
 * 测试输入：
 * 2
 * 200
 * 300
 * 预期输出：
 * 2
 * 2 2
 * 5 0
 *
 * 测试输入：
 * 2
 * 500
 * 800
 * 预期输出：
 * 1
 * 2 0
 */
public class 购物方案1 {
    static int[] temp;	// 保存每次的结果,用来比较与下次的结果是否相同
    static List<int[]> lis = new ArrayList<int[]>();
    public static void print(){
        for(int[] x:lis){
            for(int y:x){
                System.out.print(y+"  ");
            }
            System.out.println();
        }
    }
    // 上次记录的结果,和当前这次记录比较是否相同
    public static boolean compare(int[] t){
        if(temp==null) return false;
        for(int i=0;i<t.length;i++){
            if(temp[i]!=t[i]) return false;
        }
        return true;
    }
    // 检测符合条件的组合
    public static boolean check(int[] n,int[] t){
        int sum = 0;
        for(int i=0;i<n.length;i++){
            sum += t[i]*n[i];
        }
        if(sum==1000){
            return true;
        }
        return false;
    }
    public static void f(int[] n,int[] b,int[] t,int count){
        if(count>=b.length) return;
        for(int i=0;i<=b[count];i++){
            t[count] = i;	// 保存当前i的值
            f(n,b,t,count+1);	// 迭代
            if(!compare(t)){	// 去重
                if(check(n,t)){	// 检测符合条件的组合 将数组添加到lis列表
                    lis.add(Arrays.copyOf(t, t.length));
                }
            }// 用temp记录结果,下次比较是否相同用(去重)
            temp = Arrays.copyOf(t, t.length);
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("输入商品的种类数");
        int num = scan.nextInt();
        int[] n = new int[num];	// 保存商品价格
        int[] b = new int[num];	// 保存每个商品最多有几个
        for(int i=0;i<num;i++){
            n[i] = scan.nextInt();	// 输入每个商品价格
            b[i] = 1000/n[i];	// 记录每商品的个数
        }
        f(n,b,new int[num],0);
        if(lis.size()==0){	// 没有元素
            System.out.println(0);
        }else{
            System.out.println(lis.size());	// 元素个数
            print();	// 输出结果
        }
    }
}