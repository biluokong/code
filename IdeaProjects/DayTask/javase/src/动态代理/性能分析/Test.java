package 动态代理.性能分析;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        UserService userService = ProxyUtil.getProxy(new UserServiceIml());
        System.out.println(userService.getClass());
        System.out.println(userService.login("admin", "1234"));
        System.out.println(userService.selectUsers());
        userService.deleteUsers();
    }
}

class ProxyUtil {
    /**
     * 获得一个可以统计方法性能的代理对象
     * @param obj
     * @return
     * @param <T>
     */
    public static <T> T getProxy(T obj) {

        return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        long starTime = System.currentTimeMillis();
                        Object rs = method.invoke(obj, args);
                        long endTime = System.currentTimeMillis();
                        System.out.println(method.getName() + "方法耗时：" + (endTime - starTime) / 1000.0 + "秒");
                        return rs;
                    }
                });
    }
}

class UserServiceIml implements UserService {

    @Override
    public String login(String loginName, String password) {
        String rs = "登录名或密码错误";
        if ("adim".equals(loginName) && "1234".equals(password)) {
            rs = "登录成功";
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    @Override
    public void deleteUsers() {
        try {
            System.out.println("您正在输出用户数据中....");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String selectUsers() {
        String rs = "查询了10000个用户数据~~~";
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }
}

interface UserService {
    String login(String loginName, String password);
    void deleteUsers();
    String selectUsers();
}
