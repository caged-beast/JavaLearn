package java_netprog;
//模拟TCP服务端，通过（线程池）多线程实现维持多个TCP连接

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class TCPServer_ThreadPool {
    private static ExecutorService pool = new ThreadPoolExecutor(2,4,6, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
            );//创建一个线程池

    public static void main(String[] args) throws Exception {
        System.out.println("==========多线程服务端启动===========");
        //1.建立接收方Socket
        ServerSocket sSocket = new ServerSocket(7777);
        //2.在指定端口监听，建立连接
        while(true){
            Socket socket = sSocket.accept();
            //为每个TCP连接创建一个线程任务，交给线程池
            ServerRunnable task = new  ServerRunnable(socket);
            pool.execute(task);
        }


    }
}
