package 网络编程.BS架构模拟;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class BSServerDemo {
    private static ExecutorService pool = new ThreadPoolExecutor(3, 5, 6, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2),
            Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8080);
            while (true) {
                Socket socket = ss.accept();
                pool.execute(new ServerReaderRunnable(socket));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class ServerReaderRunnable implements Runnable {
    private Socket socket;

    public ServerReaderRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //浏览器已与本线程建立了Socket管道
            //响应消息给浏览器
            PrintStream ps = new PrintStream(socket.getOutputStream());
            //必须响应HTTP协议格式的数据，否则浏览器不识别
            ps.println("HTTP/1.1 200 OK");  //协议类型和版本、响应成功的状态码
            ps.println("Content-Type:text/html;charset=UTF-8"); //响应的数据类型、文本/网页
            ps.println();   //必须发送一个空行
            ps.println("<h2>hello，BS架构</h2");
            ps.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
