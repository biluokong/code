package 网络编程.testTCP.线程池优化;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 多发多收：实现多个客户端发送消息给服务端（实现服务端可以同时处理多个客户端）
 *  并使用线程池优化
 */
public class ClientDemo111 {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            //1、创建Socket通信管道请求服务器的连接
            socket = new Socket("127.0.0.1", 7777);

            //2、从socket通信管道中得到一个字节输出流：方法获得的是低级流，为提高效率，用高级流
            OutputStream os = socket.getOutputStream();

            //3、把低级的字节流对象包装成打印流
            PrintStream ps = new PrintStream(os);

            Scanner sc = new Scanner(System.in);
            //4、发送消息
            while (true) {
                System.out.println("请说：");
                String msg = sc.nextLine();
                ps.println(msg);
                ps.flush();
            }
            //5、关闭资源：不用使用
            //因为客户端关闭了管道，服务端也会关闭(双向的)，且可能在客户端消息传输的过程中就把管道关闭了，造成数据丢失
            //socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
