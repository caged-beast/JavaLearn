package java_thread;
//使用线程池，处理Callable任务

import java.util.concurrent.*;

public class ThreadPoolTest2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1.创建线程池对象
//        public ThreadPoolExecutor(
        //        int corePoolSize, //核心线程数
        //        int maximumPoolSize, //最大线程数量
        //        long keepAliveTime, //临时线程的最大存活时间
        //        TimeUnit unit, //存活时间的单位
        //        BlockingQueue<Runnable> workQueue, //工作队列
        //        ThreadFactory threadFactory, //线程工厂，负责创建线程,Executors.defaultThreadFactory()表示默认创建方法
        //        RejectedExecutionHandler handler //当线程数最大且工作队列已满，对新的任务执行什么策略，new ThreadPoolExecutor.AbortPolicy()表示抛出异常
//        )
        ExecutorService tpool = new ThreadPoolExecutor(3,5,20,
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(6),Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        //2.把任务对象交给线程池
//        Future<Integer> ft = tpool.submit(new MyCallable1((100));//submit()返回FutureTask对象
//        Integer sum = ft.get();
        System.out.println(tpool.submit(new MyCallable1((100))).get());
        System.out.println(tpool.submit(new MyCallable1((200))).get());
        System.out.println(tpool.submit(new MyCallable1((300))).get());
        System.out.println(tpool.submit(new MyCallable1((400))).get());
        System.out.println(tpool.submit(new MyCallable1((500))).get());
    }
}

