package 新特性.Stream流;

import java.util.ArrayList;

/**
 * 有一个需求，把一个集合中字符串以“张”开头的放在一个新集合，再把其中长度为3的元素储存到一个新集合中并遍历
 *
 * Stream真正的函数式编程风格引入到了java中
 *      1、使用方式
 *          （1）生成流：通过数据源生成流
 *          （2）中间操作：一个流后面可以跟随多个中间操作。目的是打开流并做出某种程度的数据过滤/映射，然后返回一个新的流
 *          （3）终结操作：一个流只能有一个终结操作。当这个操作被执行后，流就被使用完了，无法再被操作。
 */
public class Test {
    public static void main(String[] args) {
        //方法—：
        String s = "张三，王五，李四，张无忌，张三丰";
        ArrayList<String> list = new ArrayList<>();
        for (String s1 : s.split("，")) {
            list.add(s1);
        }

        ArrayList<String> zhangList = new ArrayList<>();
        for (String s1 : list) {
            if (s1.startsWith("张"))
                zhangList.add(s1);
        }

        ArrayList<String> threeList = new ArrayList<>();
        for (String s1 : zhangList) {
            if (s1.length() == 3)
                threeList.add(s1);
        }

        for (String s1 : threeList) {
            System.out.print(s1 + " ");
        }
        System.out.println("\n----------------");

        //方法二：
        list.stream().filter(s1 -> s1.startsWith("张")).filter(s1 -> s1.length() == 3).forEach(System.out::println);
    }
}
