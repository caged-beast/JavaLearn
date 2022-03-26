package java_netprog;
//模拟UDP服务端，接收数据

import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        System.out.println("===========服务端启动============");
        //1.创建接收端Socket接口
//        DatagramSocket socket = new DatagramSocket(8888);//在8888端口接收
//        DatagramSocket socket = new DatagramSocket(9999);//在9999端口接收

        //想要接收组播消息要创建MulticastSocket对象
        MulticastSocket socket = new MulticastSocket(9999);
        //创建组播组并加入
        InetAddress group = InetAddress.getByName("224.0.1.1");
        socket.joinGroup(group);

        //2.创建数据包对象来存放接收到的数据
        byte[] text = new byte[1024 * 64];//UDP每个数据包64KB
        DatagramPacket packet = new DatagramPacket(text,text.length);
        //3.不断接收数据包
        while (true) {
            socket.receive(packet);
            String recText = new String(text,0,packet.getLength());
            if(!recText.equals("exit")) {
                System.out.println("收到："+ recText);//收到多少数据就输出多少
                System.out.println("发送人：" + packet.getSocketAddress());
            }
        }

//        socket.close();//服务端不关闭
    }
}
