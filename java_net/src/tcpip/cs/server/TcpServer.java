package tcpip.cs.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lgl
 * @Description: TCP通信的服务器端: 接收客户端的请求,读取客户端发送的数据,给客户端回写数据
 * 表示服务器的类:
 *      java.net.ServerSocket: 该类实现服务器套接字。
 * 构造方法:
 *      ServerSocket​(int port) 创建绑定到指定端口的服务器套接字。
 * 服务器端必须明确一件事情,必须知道是哪个客户端请求的服务器
 * 可以使用accept方法获取到请求的客户端对象Socket
 * 成员方法:
 *      Socket accept() 侦听对此套接字的连接并接受它。
 *
 * @date 2020/3/30 8:06 下午
 */
public class TcpServer {
    public static void main(String[] args) {
        try (
                //1. 创建服务器 ServerSocket 对象和系统要指定的端口号
                ServerSocket server = new ServerSocket(8888);
                //2. 使用 ServerSocket 对象中的方法 accept ,获取到请求的客户端对象Socket
                Socket socket = server.accept();
        ) {
            //3. 使用 Socket 对象中的 getInputStream() 方法获取网络字节输入流 InputStream 对象
            InputStream is = socket.getInputStream();
            //4. 使用网络字节输入流 InputStream 对象中的方法 read ,读取客户端发送的数据
            byte[] bytes = new byte[1024];
            int len = is.read(bytes);
            System.out.println(new String(bytes, 0, len));
            //5. 使用 Socket 对象中的方法 getOutputStream() 获取网络字节输出流 OutputStream 对象
            OutputStream os = socket.getOutputStream();
            //6. 使用网络字节输出流OutputStream对象中的方法write,给客户端回写数据
            os.write("收到谢谢".getBytes());
            //7. 释放资源
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
