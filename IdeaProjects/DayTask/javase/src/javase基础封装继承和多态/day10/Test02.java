package javase基础封装继承和多态.day10;
/*题目：猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，
        还不过瘾，又多吃了一个。第二天早上又将剩下的桃子吃掉一半，又多吃了
        一个。以后每天早上都吃了前一天剩下的一半零一个。到第10天早上
        想再吃时，只剩下一个桃子了。求第一天共摘了多少*/
public class Test02 {
    public static void main(String[] args) {
        int sum = 1;
        //方法一:逆向推导（解方程）
        /*for (int i = 1; i < 10; i++) {
            sum = (sum + 1) * 2;
        }*/
        //方法二：枚举遍历
        int day = 0;
        for (sum = 0; ; sum++) {
            int temp = sum;
            for (day = 1; day < 10; day++) {
                if (temp % 2 != 0) {
                    break;
                }
                temp -= temp / 2 + 1;
            }
            if (day == 10 && temp == 1) {
                break;
            }
        }
        System.out.println("摘了" + sum + "个桃");
    }
}
