package 模式.单例模式;

/**
 * 单例类
 */
public class SingleInstance {
    /**
     * 定义一个静态变量的此对象，与类一起只加载一次
     */
    public static SingleInstance instance = new SingleInstance();

    /**
     * 私有化构造器
     */
    private SingleInstance(){}
}
