package java_netprog;
//带转发功能的即时通讯

import java.io.*;
import java.net.Socket;

import static java_netprog.TCPServer_Forward.allOnlineSockets;

public class ServerRunnable_Forward implements Runnable{
    private Socket socket;
    public ServerRunnable_Forward(Socket s){//接收一个TCP连接Socket
        this.socket = s;
    }
    @Override
    public void run() {
        System.out.println(socket.getRemoteSocketAddress()+"上线了");

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
                        //对接收到的数据进行全体转发
                        for(Socket s:allOnlineSockets){
                            OutputStream os = s.getOutputStream();
                            PrintStream ps = new PrintStream(os);
                            ps.println(text);
                            ps.flush();
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println(socket.getRemoteSocketAddress()+"下线了");
                allOnlineSockets.remove(socket);
                break;
            }
        }
    }
}
