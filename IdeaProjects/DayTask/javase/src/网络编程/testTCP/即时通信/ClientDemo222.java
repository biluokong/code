package 网络编程.testTCP.即时通信;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientDemo222 {
    //创建一个具体List集合储存当前全部在线的socket管道
    public static List<Socket> allOnlineSockets = new ArrayList<>();

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
                allOnlineSockets.add(socket);   //上线完成

                //3、开始创建独立线程处理socket对象
                new ServerReaderThread(socket).start();
            }
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }
}

class ServerReaderThread extends Thread{
    private Socket socket;

    public ServerReaderThread(Socket socket) {
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
            while ((msg = br.readLine()) != null){
                System.out.println(socket.getRemoteSocketAddress() + "发来了：" + msg);
                //6、把消息转发给全部客户端socket管道
                sendMsgToAll(msg);
            }
        } catch (IOException e) {
            System.out.println(socket.getRemoteSocketAddress() + "下线了！！！");
            ClientDemo222.allOnlineSockets.remove(socket);
        }
    }

    private void sendMsgToAll(String msg) throws IOException {
        for (Socket socket : ClientDemo222.allOnlineSockets) {
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println(msg);
            ps.flush();
        }
    }
}