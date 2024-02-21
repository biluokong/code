package 网络编程.testUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class ClientDemo11 {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端启动----------");
        //1、创建发送端对象，发送端自己随机分配一个端口
        DatagramSocket socket = new DatagramSocket();

        //2、创建数据包对象，封装数据
        Scanner input = new Scanner(System.in);
        String s = "";
        while (!"exit".equals(s)) {
            System.out.println("请输入要传输的文字：");
            s = input.nextLine();
            byte[] bytes = s.getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 8000);

            //3、发送数据
            socket.send(packet);
        }

        //4、关闭管道
        socket.close();
    }
}
