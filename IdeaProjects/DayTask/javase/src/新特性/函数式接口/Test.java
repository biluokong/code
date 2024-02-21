package 新特性.函数式接口;

/**
 * 1、函数式接口的定义：有且仅有一个抽象方法的接口
 *
 * 2、检测一个接口是否是函数式接口的方法：在接口上加上注解：@FunctionalInterface。若编译失败，则不是。
 */
@FunctionalInterface
public interface Test {
    void m();
}
