package 网络编程.testTCP.线程池优化;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class ClientDemo222 {
    //使用静态变量创建一个线程池对象
    private static final ExecutorService pool = new ThreadPoolExecutor(3, 5, 6, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

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

                //3、开始创建独立线程处理socket对象，并将线程对象放入线程池
                pool.execute(new ServerReaderRunnable(socket));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}