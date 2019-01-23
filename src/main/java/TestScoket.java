import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestScoket {
    public static void main(String[] args) {
        // 创建ServerSocket，监听端口号：12345
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(22);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 创建用于管理客户端的收发数据的子线程类

        System.out.println("服务器开启啦");

        // 监听端口号：12345
        // 等待客户连接 accept()
        while (true) {
            // 开始接收客户端的连接
            try {
                Socket socket = ss.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("有新客户连接~");
           // clientThread.addClient(socket);
        }
    }

}

