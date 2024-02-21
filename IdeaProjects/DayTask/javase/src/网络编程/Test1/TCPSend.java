package 网络编程.Test1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPSend {
    public static void main(String[] args) throws IOException {
        //1、创建客户端的Socket对象（Socket）
        //Socket sender = new Socket(InetAddress.getByName("biluo"), 10024);    //通过IneAddress和端口号创建
        Socket sender = new Socket("biluo", 10024); //通过主机名/IP地址和端口号创建Socket对象

        //2、获取输出流，写数据
        OutputStream os = sender.getOutputStream();
        os.write("hello，TCP".getBytes());
        os.flush();

        //3、释放资源
        sender.close();
        os.close();
    }
}
