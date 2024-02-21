package 集合;

/**
 * 1、可变参数接收的数据实际保存在一个数组中
 *
 * 2、注意事项：
 *  ● 可变参数只能放形参最后面
 *  ● 一个形参列表中可变参数只能一个（因为可变参数只能放形参最后面）
 */
public class 可变参数 {
    public static void main(String[] args) {
        sum();
        sum(1, 2);
        sum(new int[]{1, 2, 3, 4, 5});
    }

    public static void sum(int... nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        System.out.println(sum);
    }
}
