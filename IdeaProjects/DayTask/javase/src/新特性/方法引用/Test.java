package 新特性.方法引用;

import java.io.PrintStream;

/**
 * 1、方法引用符：“::”     (产生的主要条件原则：可推导的就是可以省略的。方法引用是Lambda的孪生兄弟)
 *
 * 2、常见引用方式：
 *      （1）引用类方法：即引用类的静态方法，格式为 “类名::静态方法”。
 *              本质：Lambda表达式被类方法替代时，其所有参数都传递给静态方法作为实参
 *
 *      （2）引用对象的实例方法：即引用类中的成员方法，格式为 “对象::成员方法”
 *              本质：Lambda表达式被对象的实例方法替代时，其所有参数都传递给静态方法作出实参
 *
 *      （3）引用类的实例方法：即引用类的成员方法，格式 “类名::成员方法”
 *              本质：Lambda表达式被类的实例方法替代时，第一个参数作为该方法的调用者，后面的参数作为该方法的实参
 *
 *      （4）引用构造器：即引用构造方法，格式 “类名::new”
 *              本质：Lambda表达式被构造器替代时，其所有参数都传递给构造方法作为实参
 */
public class Test {
    public static void main(String[] args) {
        //这两个方法的效果是一样的，那么有没有更简便的方法来实现同样的效果呢？
        a1(s -> System.out.println(s));  //这里实际是拿到参数 s 后，再传递给println方法去处理
        System.out.println("方法引用");

        //可以这样写，实际是把 s 参数传到了System.out下的println方法里面来作为实参。
        //这也是引用类方法的写法
        a1(System.out::println);

        //引用对象的实例方法
        PrintStream ps = new PrintStream(System.out);
        a2(ps::println);

        //引用类的实例方法
        a3(String::substring);

        //引用构造器
        a4(Student::new);
    }

    public static void a1(TestInterface1 t) {
        t.m("方法引用，用于类的静态方法");
    }

    public static void a2(TestInterface1 t) {
        t.m("引用对象的实例方法");
    }

    public static void a3(TestInterface2 t) {
        String s = t.m("  引用类的实例方法", 2, 10);
        System.out.println(s);
    }

    public static void a4(TestInterface3 t) {
        Student s = t.m("张三", "20202449394");
        System.out.println("引用构造器\t" + s.getName());
    }
}
