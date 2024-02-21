package 网络编程;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
    public static void main(String[] args) throws IOException {
        //1、获取本机地址对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost.getHostName());
        System.out.println(localHost.getHostAddress());

        //2、获取域名ip对象
        InetAddress baidu = InetAddress.getByName("www.baidu.com");
        System.out.println(baidu.getHostName());
        System.out.println(baidu.getHostAddress());

        //3、获取公网ip对象
        InetAddress baidu2 = InetAddress.getByName("14.215.177.38");
        System.out.println(baidu.getHostName());
        System.out.println(baidu.getHostAddress());

        //4、判断是否能通：ping 5s之前测试是否可通
        System.out.println(baidu.isReachable(5000));
    }
}
