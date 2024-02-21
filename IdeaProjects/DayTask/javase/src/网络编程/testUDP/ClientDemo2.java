package 网络编程.testUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 接收端：要先启动
 */
public class ClientDemo2 {
    public static void main(String[] args) throws Exception {
        System.out.println("服务端启动-------");
        //1,创建接收端对象，注册端口
        DatagramSocket socket = new DatagramSocket(8888);

        //2、创建数据包对象，接收数据
        byte[] bytes = new byte[1024 * 64];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);

        //3、接收数据：有多少收多少，多收会多‘\0'
        socket.receive(packet);

        //4、处理接收
        int length = packet.getLength();
        System.out.println(new String(bytes, 0, length));

        //获取发送端的ip和端口
        System.out.println(packet.getAddress() + "，" + packet.getPort());

        //5、关闭管道
        socket.close();
    }
}
