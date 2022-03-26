package java_netprog;
//模拟TCP客户端

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import static java_netprog.TCPServer_Forward.allOnlineSockets;

public class TCPClient {
    public static void main(String[] args) throws Exception {
        System.out.println("==========客户端启动===========");
        //1.建立发送方Socket
        Socket socket = new Socket(InetAddress.getLocalHost(),7777);

        //要想实现即时通讯的话，客户端还需要能够读消息，这里为它创建单独的线程
        new ClientReaderThread(socket).start();

        //2.获取字符输出流
        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os);//用高级的打印流包装低级的字符输出流
        //3.发送消息
//        ps.println("I am SpiderMan");
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("请输入要发送的消息，退出请输入exit");
            String input = sc.nextLine();
            ps.println(input);
            ps.flush();
            if(input.equals("exit"))
            {
                System.out.println("退出成功!");
                break;
            }
        }
    }
}

class ClientReaderThread extends Thread{//和普通的服务端读消息差不多
    private Socket socket;
    public ClientReaderThread(Socket s){//接收一个TCP连接Socket
        this.socket = s;
    }
    @Override
    public void run() {

        //3.获取字节输入流
        InputStream is = null;
        try {
            is = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //用高级的缓冲字符输入流包装低级的字节输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        //4.接收数据
        while(true) {
            String text = null;
            try {
                text = br.readLine();
                if(!text.equals("exit")) {
                    if (text != null) {
                        System.out.println("接收到来自" + socket.getRemoteSocketAddress() + "的消息：" +
                                text);
                    }
                }
            } catch (IOException e) {
                System.out.println("你被踢出群聊");
                break;
            }
        }
    }
}


