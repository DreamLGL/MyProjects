package tcpip.cs.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author lgl
 * @Description: TCP通信客户端: 向服务器发送链接请求,给服务器发送数据,读取服务器会写的数据
 * 表示客户端的类:
 *      java.net.Socket: 该类实现客户端套接字（也称为“套接字”）。 套接字是两台机器之间通信的端点。
 *      套接字: 包含了IP地址和端口号的网络单位
 *
 * 构造方法:
 *      Socket​(String host, int port) 创建流套接字并将其连接到指定主机上的指定端口号。
 *
 * 成员方法:
 *      OutputStream getOutputStream() 返回此套接字的输出流。
 *      InputStream	getInputStream() 返回此套接字的输入流。
 *      void close() 关闭此套接字。
 * @date 2020/3/30 7:50 下午
 */
public class TcpClient {
    public static void main(String[] args) {
        try (
                //1.创建一个客户端对象Socket,构造方法绑定服务器的IP地址和端口号
                Socket socket = new Socket("127.0.0.1", 8888);
        ) {
            //2.使用Socket对象中的方法getOutputStream()获取网络字节输出流OutputStream对象
            OutputStream os = socket.getOutputStream();
            //3.使用网络字节输出流OutputStream对象中的方法write,给服务器发送数据
            os.write("你好服务器".getBytes());

            //4.使用Socket对象中的方法getInputStream()获取网络字节输入流InputStream对象
            InputStream is = socket.getInputStream();

            //5.使用网络字节输入流InputStream对象中的方法read,读取服务器回写的数据
            byte[] bytes = new byte[1024];
            int len = is.read(bytes);
            System.out.println(new String(bytes, 0, len));

            //6.释放资源(Socket)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
