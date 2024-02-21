package 注解.模拟JUnit框架;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMyTest {
    @MyTest
    public void test1() {
        System.out.println("============Test1==========");
    }

    public void test2() {
        System.out.println("============Test2==========");
    }

    @MyTest
    public void test3() {
        System.out.println("============Test3==========");
    }

    /**
     * 启动菜单，只有被MyTest注解注解了的方法才被调用
     * @param args
     */
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        TestMyTest t = new TestMyTest();
        Class c = TestMyTest.class;
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyTest.class)) {
                method.invoke(t);
            }
        }
    }
}
