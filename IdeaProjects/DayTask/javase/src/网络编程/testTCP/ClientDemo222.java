package 网络编程.testTCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientDemo222 {
    public static void main(String[] args) {
        System.out.println("===服务端启动成功===");
        //1、注册端口
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(7777);

            while (true) {
                //2、每接收到一个客户端的Socket管道，就交给一个独立的子线程负责读取消息
                Socket socket = serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress() + "上线了！");

                //3、开始创建独立线程处理socket
                new ServerReaderThread(socket).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}