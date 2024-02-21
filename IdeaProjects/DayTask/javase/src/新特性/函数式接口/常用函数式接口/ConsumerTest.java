package 新特性.函数式接口.常用函数式接口;

import java.util.function.Consumer;

/**
 * Consumer<T>的方法：
 *      void accept(T t)：对给定的参数执行此操作
 *      default Consumer<T> andThen(Consumer after)：返回一个组合的Consumer，依次执行此操作，然后执行after操作
 *      （它是消费型接口）
 */
public class ConsumerTest {
    public static void main(String[] args) {
        operatorString("张三", System.out::println);

        operatorString("张三", s -> System.out.println(new StringBuilder(s).reverse()));

        operatorString("张三", System.out::println, s -> System.out.println(new StringBuilder(s).reverse()));


    }

    //消费同一个字符串两次
    private static void operatorString(String name, Consumer<String> con1, Consumer<String> con2) {
        //这样写代码重复了
        //con1.accept(name);
        //con2.accept(name);

        //还可以这样写
        con1.andThen(con2).accept(name);
    }

    //消费一个字符串
    private static void operatorString(String name, Consumer<String> con) {
        con.accept(name);
    }
}
