package 网络编程.testTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientDemo2 {
    public static void main(String[] args) {
        try {
            System.out.println("===服务端启动成功===");
            //1、注册端口
            ServerSocket serverSocket = new ServerSocket(7777);
            
            //2、必须调用accept方法，等待接收客户端的Socket连接请求，建立Socket通信管道
            Socket socket = serverSocket.accept();

            //3、从socket通信管道中得到一个字节输入流
            InputStream is = socket.getInputStream();

            //4、把字节输入流包装成缓冲字符输入流进行消息的接收
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            //5、按照行读取消息
            String msg = "";
            //这里读取一行信息，一定要是一行，所以发送的消息需要以换行符结尾，或者用println
            //并且不能用while，因为客户端只发送了一行
            if ((msg = br.readLine()) != null)
                System.out.println(socket.getRemoteSocketAddress() + "说了：" + msg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
