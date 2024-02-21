package 新特性.函数式接口.常用函数式接口;

import java.util.function.Predicate;

/**
 * predicate<T>的常用4个方法：
 *      boolean test(T t)：对给定的参数进行判断，返回一个布尔值
 *      default Predicate<T> negate()：返回一个逻辑的否定，对应逻辑非
 *      default Predicate<T> and(Predicate other)：返回一个组合判断，对应短路与
 *      default Predicate<T> or(Predicate other)：返回一个组合判断，对应短路或
 *      （此接口通常用于判断参数是否满足指定的条件）
 */
public class PredicateTest {
    public static void main(String[] args) {
        //普通判断
        System.out.println(checkString1("hello", s -> s.length() > 8));

        //普通判断加上逻辑非
        System.out.println(checkString2("hello", s -> s.length() > 8));

        //短路与判断
        System.out.println(checkString3("hello", s -> s.length() > 3, s -> s.length() < 5));

        //短路或判断
        System.out.println(checkString4("hello", s -> s.length() > 3, s -> s.length() < 5));
    }

    private static boolean checkString1(String s, Predicate<String> pre) {
        return pre.test(s);
    }

    private static boolean checkString2(String s, Predicate<String> pre) {
        return pre.negate().test(s);
    }

    private static boolean checkString3(String s, Predicate<String> p1, Predicate<String> p2) {
        return p1.and(p2).test(s);
    }

    private static boolean checkString4(String s, Predicate<String> p1, Predicate<String> p2) {
        return p1.or(p2).test(s);
    }
}
