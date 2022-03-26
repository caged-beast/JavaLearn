package java_netprog;
//InetAddress 提供了对IP地址的操作

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) throws IOException {
        //获取本机地址对象
        InetAddress ip1 = InetAddress.getLocalHost();
        System.out.println(ip1.getHostName());
        System.out.println(ip1.getHostAddress());

        //获取域名IP对象
        InetAddress ip2 = InetAddress.getByName("www.baidu.com");
        System.out.println(ip2.getHostName());
        System.out.println(ip2.getHostAddress());

        //获取公网IP对象
        InetAddress ip3 = InetAddress.getByName("14.215.177.39");
        System.out.println(ip3.getHostName());
        System.out.println(ip3.getHostAddress());

        //判断能否Ping通
        System.out.println(ip3.isReachable(5000));
    }
}
