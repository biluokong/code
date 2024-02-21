package 注解;

import org.junit.Test;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 完成注解的解析
 */
public class ParseAnnotations {
    @Test
    public void parseClass() throws NoSuchMethodException {
        //1、先得到类对象，再得到方法对象
        Class c = BookStore.class;
        Method m = c.getDeclaredMethod("test");
        //2、判断此类上面是否有这个注解
        if (c.isAnnotationPresent(TestBook.class)) {
            //3、获取该注解对象
            TestBook book = (TestBook) c.getDeclaredAnnotation(TestBook.class);
            System.out.println(book.value() + " " + book.price() + " " + Arrays.toString(book.author()));
        }
        if (m.isAnnotationPresent(TestBook.class)) {
            //3、获取该注解对象
            TestBook b = m.getDeclaredAnnotation(TestBook.class);
            System.out.println(b.value() + " " + b.price() + " " + Arrays.toString(b.author()));
        }
    }
}

@TestBook(value = "《你好，世界》" , price = 9.2, author = "花猫")
class BookStore {
    @TestBook(value = "《你好，JAVA》" , price = 9.9, author = "小白")
    public void test() {

    }
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface TestBook {
    String value();
    double price() default 100;
    String[] author();
}

