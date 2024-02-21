package 网络编程.Test1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        //根据主机名获取IneAddress对象
        //InetAddress address = InetAddress.getByName("biluo");

        //根据主机的IP地址获取IneAddress对象
        InetAddress address = InetAddress.getByName("169.254.113.104");

        //通过IneAddress对象获取主机名和主机Ip地址
        System.out.println("主机名：" + address.getHostName());
        System.out.println("ip地址：" + address.getHostAddress());
    }
}