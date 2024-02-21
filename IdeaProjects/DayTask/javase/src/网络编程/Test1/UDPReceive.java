package 网络编程.Test1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceive {
    public static void main(String[] args) throws IOException {
        //1、创建接收端的Socket对象（DatagramSocket）
        DatagramSocket ds = new DatagramSocket(10086);  //根据端口号创建DatagramSocket对象

        //2、创建一个数据包，用于接收数据
        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);

        //3、调用DatagramSocket对象的方法接收对象
        ds.receive(dp);

        //4、解析数据包，并输出
        byte[] data = dp.getData();
        System.out.println(new String(data, 0, dp.getLength()));

        //5、关闭接收器
        ds.close();
    }
}
