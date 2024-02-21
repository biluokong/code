package 网络编程.testTCP;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * 一发一收
 */
public class ClientDemo1 {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            //1、创建Socket通信管道请求服务器的连接
            socket = new Socket("127.0.0.1", 7777);

            //2、从socket通信管道中得到一个字节输出流：方法获得的是低级流，为提高效率，用高级流
            OutputStream os = socket.getOutputStream();

            //3、把低级的字节流对象包装成打印流
            PrintStream ps = new PrintStream(os);

            //4、发送消息
            ps.println("我是TCP的客户端，我已与你对接，并发出邀请：约吗？");
            ps.flush();

            //5、关闭资源：不用使用
            //因为客户端关闭了管道，服务端也会关闭(双向的)，且可能在客户端消息传输的过程中就把管道关闭了，造成数据丢失
            //socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
