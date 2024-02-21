package 新特性.Stream流;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1、R collect(Collector collect)：把流中的数据收集到集合中
 *
 * 2、工具类Collectors提供了具体的收集方式：
 *      public static <T> Collector toList()：把元素收集到List集合中
 *      public static <T> Collector toSet()：把元素收集到Set集合中
 *      public static Collector toMap(Function keyMapper, Function valueMapper)：把元素收集到Map集合中
 */
public class Stream流的收集操作 {
    public static void main(String[] args) {
        String str = "张三，王五，李四，张无忌，张三丰，李四";
        Stream<String> stream = Stream.of(str.split("，"));

        //将姓张的收集到集合中并输出
        for (String s : stream.filter(s -> s.startsWith("张")).collect(Collectors.toList())) {
            System.out.print(s + " ");
        }
    }
}
