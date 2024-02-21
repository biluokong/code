package 新特性.函数式接口.常用函数式接口;

import java.util.function.Function;

/**
 * Function<T,R>的常用方法：
 *      R apply(T t)：将此函数应用于给定的参数
 *      default<V> Function andThen(Function after)：返回一个组合函数，首先将函数应用于输入，再将after函数应用于结果
 *      （该接口通常用于对参数进行处理、转换，然后返回一个新值）
 */
public class FunctionTest {
    public static void main(String[] args) {
        convert("100", s -> Integer.parseInt(s));

        convert("300", s -> Integer.parseInt(s), s -> String.valueOf(s + 100));
    }

    //把一个字符串转换为整型后加上一个数，在转换为字符串
    private static void convert(String s, Function<String, Integer> f1, Function<Integer, String> f2) {
        System.out.println(f1.andThen(f2).apply(s));
    }

    //把一个字符串转换为整型数据后输出
    private static void convert(String s, Function<String,Integer> f) {
        System.out.println(f.apply(s));
    }
}
