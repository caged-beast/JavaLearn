package java_netprog;
//模拟TCP服务端

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        System.out.println("==========服务端启动===========");
        //1.建立接收方Socket
        ServerSocket sSocket = new ServerSocket(7777);
        //2.在指定端口监听，建立连接
        Socket socket = sSocket.accept();
        //3.获取字节输入流
        InputStream is = socket.getInputStream();
        //用高级的缓冲字符输入流包装低级的字节输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        //4.接收数据
        while(true) {
            String text = br.readLine();
            if(!text.equals("exit")) {
                if (text != null)
                    System.out.println("接收到来自" + socket.getInetAddress() + "的消息：" +
                            text);
            }
        }

    }
}
