package 动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        //1、创建一个实现了接口的对象
        Star ls = new Star("李四");
        ls.dance();
        ls.sing();
        //2、获得该对象的代理对象
//        Skill proxy = StarAgentProxy.getProxy(ls);
        Skill proxy = (Skill) Proxy.newProxyInstance(ls.getClass().getClassLoader(),
                ls.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("收首付款...");
                        //method：正在调用的方法对象；args：这个方法的参数
                        Object rs = method.invoke(ls, args);
                        System.out.println("收尾款，把" + ls.getName() + "接回来了~~");
                        return rs;
                    }
                });
        proxy.sing();
    }
}

class StarAgentProxy {
    /**
     * 设计一个方法来返回一个Star对象的代理对象
     */
    public static Skill getProxy(Star star) {
        return (Skill) Proxy.newProxyInstance(star.getClass().getClassLoader(),
                star.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("收首付款...");
                        //method：正在调用的方法对象；args：这个方法的参数
                        Object rs = method.invoke(star, args);
                        System.out.println("收尾款，把" + star.getName() + "接回来了~~");
                        return rs;
                    }
                });
    }
}

class Star implements Skill{
    private String name;

    public Star(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void dance() {
        System.out.println(name + "开始跳舞，跳得很棒~~");
    }

    @Override
    public void sing() {
        System.out.println(name + "开始唱歌，唱得很好听~~");
    }
}

interface Skill {
    void dance();
    void sing();
}


