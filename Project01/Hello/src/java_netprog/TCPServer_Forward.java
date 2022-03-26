package java_netprog;
//该TCP服务器对接收到的消息进行转发

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.*;

public class TCPServer_Forward {
    //创建一个线程池
    private static ExecutorService pool = new ThreadPoolExecutor(2,4,6, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
    );
    //创建一个容器存放所有的Socket
    public static ArrayList<Socket> allOnlineSockets = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.out.println("==========多线程（可转发）服务端启动===========");
        //1.建立接收方Socket
        ServerSocket sSocket = new ServerSocket(7777);
        //2.在指定端口监听，建立连接
        while(true){
            Socket socket = sSocket.accept();
            allOnlineSockets.add(socket);//上线
            //为每个TCP连接创建一个线程任务，交给线程池
            ServerRunnable task = new  ServerRunnable(socket);
            pool.execute(task);
        }


    }
}

