package 新特性.接口组成更新;

/**
 * 接口的组成
 *      1、常量：默认修饰 public static final
 *
 *      2、抽象方法：默认修饰 public abstract
 *
 *      3、默认方法(Java 8)：
 *          （1）定义格式：public(默认修饰) default 返回值类型 方法名(参数列表) {可以有方法体}
 *          （2）作用：此方法可以不用强制被重写，它不是抽象方法；可以有方法体。（如果要重写，则重写时要去掉default关键字）
 *          （3）意义：可以在重写方法时减少重写的方法，提供代码的简洁度和可读性。
 *
 *      4、静态方法(Java8)：
 *          （1）定义格式：public(默认修饰) static 返回值类型 方法名(参数列表) {可以有方法体}
 *          （2）注意：接口中的静态方法只能通过接口名调用（不能用具体对象和其实现类，因为接口是多实现，可能出现多个接口中的静态方法重名）
 *
 *      5、私有方法(Java9)：
 *          （1）定义格式：private (static) 返回值类型 方法名(参数列表) {可以有方法体}
 *          （2）
 */
public class Test {
    public static void main(String[] args) {
        A a = new A() {
            @Override
            public void m1() {
                System.out.println("接口中的普通方法");
            }
        };

        a.m1();
        a.m2();
        //a.m3();   //报错，无法调用
        A.m3();
    }
}

interface A {
    void m1();

    default void m2() {
        System.out.println("接口的默认方法");
        m4();   //成员方法可以调用类中的其它成员方法和静态方法
        m5();
    }

    static void m3() {
        System.out.println("接口的公有静态方法");
        m5();   //静态方法中调用不了成员方法：m4()，但能调用私有静态方法：m5()
    }

    private void m4() {
        System.out.println("接口的私有方法");
    }

    private static void m5() {
        System.out.println("接口的私有静态方法");
    }
}
