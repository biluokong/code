package 常用框架.日志框架;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 快速搭建Logback，记录程序执行的情况到控制台和文件中
 */
public class Test {
    //创建logback日志对象
    public static final Logger LOGGER = LoggerFactory.getLogger("Test.class");

    public static void main(String[] args) {
        try {
            LOGGER.debug("main方法开始执行了~~~");
            LOGGER.info("我要开始做除法");
            int a = 10;
            int b = 0;
            LOGGER.trace("a=" + a);
            LOGGER.trace("b=" + b);
            System.out.println(a/b);
        } catch (Exception e) {
            LOGGER.error("功能出现异常：" + e);
        }
    }
}
