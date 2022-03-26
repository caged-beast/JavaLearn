package java_netprog;
//模拟UDP客户端（组播），发送数据

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient_Multicast {
    public static void main(String[] args) throws Exception {
        System.out.println("===========客户端启动============");
        //1.创建发送端的Socket接口
        DatagramSocket socket = new DatagramSocket();//发送端可以不设置端口号，会自动配置一个

        //不断读取用户输入
        while (true) {
            System.out.println("请输入要发送的消息，退出请输入exit");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            //2.创建数据包
            byte[] text = input.getBytes();
//        byte[] text = "I lost Gwen.She was my MJ.".getBytes();
            //224.0.0.0 to 239.255.255.255是组播地址，224.0.0.0保留
            DatagramPacket packet = new DatagramPacket(text, text.length,
                    InetAddress.getByName("224.0.1.1"), 9999);//这里发送到本机的9999端口
            //3.发送数据包
            socket.send(packet);

            if(input.equals("exit")) {
                System.out.println("您已退出!");
                break;
            }
        }

        socket.close();
    }
}
