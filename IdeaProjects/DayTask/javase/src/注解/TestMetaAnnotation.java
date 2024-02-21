package 注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@MyTest   //报错，只能注解方法
public class TestMetaAnnotation {
    @MyTest
    public static void main(String[] args) {

    }
}

@Target(ElementType.METHOD)   //元注解，设置该注解可以使用的位置
@Retention(RetentionPolicy.RUNTIME) //一直活在
@interface MyTest {

}
