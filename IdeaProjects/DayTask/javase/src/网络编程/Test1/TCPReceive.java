package 网络编程.Test1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPReceive {
    public static void main(String[] args) throws IOException {
        //1、创建服务器端的Socket对象（ServerSocket）
        ServerSocket receiver = new ServerSocket(10024);

        //2、获取输入流，读数据，输出
        Socket accept = receiver.accept();  //监听要连接的此套接字并接受它
        InputStream is = accept.getInputStream();
        byte[] fus = new byte[1024];
        int len = is.read(fus);
        System.out.println(new String(fus, 0, len));

        //3、释放资源
        receiver.close();
        is.close();
    }
}
