package 网络编程.testUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 多发多收
 */
public class ClientDemo22 {
    public static void main(String[] args) throws Exception {
        System.out.println("服务端启动-------");
        //1,创建接收端对象，注册端口
        DatagramSocket socket = new DatagramSocket(8000);

        //2、创建数据包对象，接收数据
        byte[] bytes = new byte[1024 * 64];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);

        while (true) {
            //3、接收数据
            socket.receive(packet);

            //4、处理接收；有多少收多少，多收会多‘\0'
            int length = packet.getLength();
            System.out.println("收到了来自：" + packet.getAddress() + "，端口号是：" + packet.getPort() + "的信息：" + new String(bytes, 0, length));
        }
    }
}
