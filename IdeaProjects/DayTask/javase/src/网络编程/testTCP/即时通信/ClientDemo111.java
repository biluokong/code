package 网络编程.testTCP.即时通信;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 多发多收：实现多个客户端发送消息给服务端（实现服务端可以同时处理多个客户端）
 *  并使用线程池优化
 */
public class ClientDemo111 {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        //1、创建Socket通信管道请求服务器的连接
        socket = new Socket("127.0.0.1", 7777);

        //2、创建一个独立线程负责接收客户端的消息（有服务端转发过来的）
        new ClientReaderThread(socket).start();

        //3、从socket通信管道中得到一个字节输出流：方法获得的是低级流，为提高效率，用高级流
        OutputStream os = socket.getOutputStream();

        //4、把低级的字节流对象包装成打印流
        PrintStream ps = new PrintStream(os);

        Scanner sc = new Scanner(System.in);
        //5、发送消息
        while (true) {
            System.out.println("请说：");
            String msg = sc.nextLine();
            ps.println(msg);
            ps.flush();
        }
        //6、关闭资源：不用使用
        //因为客户端关闭了管道，服务端也会关闭(双向的)，且可能在客户端消息传输的过程中就把管道关闭了，造成数据丢失
        //socket.close();
    }
}

class ClientReaderThread extends Thread{
    private Socket socket;

    public ClientReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //3、从socket通信管道中得到一个字节输入流
            InputStream is = socket.getInputStream();

            //4、把字节输入流包装成缓冲字符输入流进行消息的接收
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            //5、按照行读取消息
            String msg = "";
            while ((msg = br.readLine()) != null)
                System.out.println("收到了：" + msg);
        } catch (IOException e) {
            System.out.println("服务器端把你踢出去了！！！");
        }
    }
}
