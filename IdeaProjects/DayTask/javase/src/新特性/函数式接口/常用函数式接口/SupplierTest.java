package 新特性.函数式接口.常用函数式接口;

import java.util.function.Supplier;

/**
 * Supplier<T>：包含一个无参的方法 T get()
 *  （它被称为生产型接口，可以指定接口的泛型，从而通过get方法得到该类型的数据）
 */
public class SupplierTest {
    public static void main(String[] args) {
        String s = getString(() -> "张三");
        System.out.println(s);
    }

    private static String getString(Supplier<String> sup) {
        return sup.get();
    }
}
