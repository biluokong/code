package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    private SayImpl say = new SayImpl();

    public Say getSayProxy() {
        Object o = Proxy.newProxyInstance(say.getClass().getClassLoader(), say.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("sayHello")) {
                    System.out.println("proxy --> hello");
                } else if (method.getName().equals("sayBuy")) {
                    System.out.println("proxy --> buy");
                } else if (method.getName().equals("sayGood")) {
                    System.out.println("proxy --> good");
                }
                return null;
            }
        });
        return (Say) o;
    }
}
