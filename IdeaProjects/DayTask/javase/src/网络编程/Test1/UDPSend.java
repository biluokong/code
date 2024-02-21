package 网络编程.Test1;

import java.io.IOException;
import java.net.*;

public class UDPSend {
    public static void main(String[] args) throws IOException {
        //1、创建发送端的Socket对象（DatagramSocket）
        DatagramSocket ds = new DatagramSocket();

        //2、创建数据，并把数据打包
        //DatagramPacket (byte[] buf, int length, InetAddress address, int port)
        //构造一个数据报包，用于将长度为 length的数据包发送到指定主机上的指定端口号
        byte[] buf = "hello,UPD".getBytes();
        InetAddress address = InetAddress.getByName("biluo");
        int port = 10086;
        DatagramPacket dp = new DatagramPacket(buf, buf.length, address, port);

        //3、调用DatagramSocket对象的方法发送数据
        ds.send(dp);

        //4、关闭发送端
        ds.close();
    }
}
