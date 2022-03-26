package java_netprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerRunnable implements Runnable{
    private Socket socket;
    public ServerRunnable(Socket s){//接收一个TCP连接Socket
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
                    if (text != null)
                        System.out.println("接收到来自" + socket.getRemoteSocketAddress() + "的消息：" +
                                text);
                }
            } catch (IOException e) {
                System.out.println(socket.getRemoteSocketAddress()+"下线了");
                break;
            }
        }
    }
}
