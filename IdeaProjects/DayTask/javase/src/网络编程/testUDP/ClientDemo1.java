package 网络编程.testUDP;

import java.io.IOException;
import java.net.*;

/**
 * 发送端：单发单
 */
public class ClientDemo1 {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端启动----------");
        //1、创建发送端对象，发送端自己随机分配一个端口
        DatagramSocket socket = new DatagramSocket();

        //2、创建数据包对象，封装数据
        byte[] bytes = "我是一个快乐的咸鱼，你原意吃吗？".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 8888);

        //3、发送数据
        socket.send(packet);

        //4、关闭管道
        socket.close();
    }
}
