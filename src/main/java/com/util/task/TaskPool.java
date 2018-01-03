/**    
 * 文件名：TaskPool.java    
 *    
 * 版本信息：    
 * 日期：2015-2-5    
 * Copyright jacky Corporation 2015     
 * 版权所有    
 *    
 */
package com.util.task;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/** 
 * @title TaskPool
 * @description 执行线程池
 * @author ziQi 
 * @version 上午10:43:22 
 * @create_date 2016-9-20上午10:43:22
 * @copyright (c) jacky
 */  
public class TaskPool{

    private ThreadPoolExecutor threadPool;

    public static TaskPool taskPool = new TaskPool();
       
    /**    
     * 创建一个新的实例 TaskPool.    
     * ThreadPoolExecutor(int corePoolSize,  
                              int maximumPoolSize,  
                              long keepAliveTime,  
                              TimeUnit unit,  
                              BlockingQueue<Runnable> workQueue,  
                              ThreadFactory threadFactory,  
                              RejectedExecutionHandler handler)
        参数名           作用
        corePoolSize    核心线程池大小
        maximumPoolSize 最大线程池大小
        keepAliveTime   线程池中超过corePoolSize数目的空闲线程最大存活时间；可以allowCoreThreadTimeOut(true)使得核心线程有效时间
        TimeUnit    keepAliveTime时间单位
        workQueue   阻塞任务队列
        threadFactory   新建线程工厂
        RejectedExecutionHandler    当提交任务数超过maxmumPoolSize+workQueue之和时，任务会交给RejectedExecutionHandler来处理
        
        1.当线程池小于corePoolSize时，新提交任务将创建一个新线程执行任务，即使此时线程池中存在空闲线程。 
        2.当线程池达到corePoolSize时，新提交任务将被放入workQueue中，等待线程池中任务调度执行 
        3.当workQueue已满，且maximumPoolSize>corePoolSize时，新提交任务会创建新线程执行任务 
        4.当提交任务数超过maximumPoolSize时，新提交任务由RejectedExecutionHandler处理 
        5.当线程池中超过corePoolSize线程，空闲时间达到keepAliveTime时，关闭空闲线程 
        6.当设置allowCoreThreadTimeOut(true)时，线程池中corePoolSize线程空闲时间达到keepAliveTime也将关闭 
     */
    public TaskPool(){
        // 构造一个线程池
        threadPool = new ThreadPoolExecutor(20, 60, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(20),new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    /**
     * 往线程池中添加一个任务，并执行
     * 
     * @param task
     *            任务
     */
    public void addTask( ITask task ){
        try{
            // 产生一个任务，并将其加入到线程池
            threadPool.execute(task);
        }catch( Exception e ){
            e.printStackTrace();
        }
    }

    public static TaskPool getInstance(){
        return taskPool;
    }

}
