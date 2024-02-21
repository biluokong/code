package 反射机制.模拟通用框架;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class MybatisUtil {
    /**
     * 保存任意类型的对象
     */
    public static void save(Object obj) {
        try {
            PrintStream ps = new PrintStream(new FileOutputStream("javase/src/反射机制/data.txt", true));
            //1、提取这个对象的全部成员变量：只有反射可以解决
            Class c = obj.getClass();
            ps.println("================" + c.getSimpleName() + "================");

            //2、提取它的全部成员变量，并获取成员变量的数据
            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                ps.println(field.getName() + "=" + (field.get(obj) + ""));
            }
        } catch (FileNotFoundException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
