package org.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description 简单线程池
 * 这里是总共有10个任务，每次有3个线程进行处理
 * 结果会发现打印出来的任务是乱序的，这是因为线程本身最开始是按顺序执行的，不过有的线程执行早，有的线程执行晚，所以导致执行结果乱序
 * @Date 2023/3/4 18:41
 **/
public class SimpleThreadWithThreadPool {
  public static void main(String[] args) {
    //创建一个大小为3的线程池
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    //创建10个认为给线程池处理
    for(int i = 0;i<=10;i++){
      Runnable task = new SimpleThreadWithThreadPootTask(i);
      executorService.execute(task);
    }
    //关闭线程池
    executorService.shutdown();
  }
}
class SimpleThreadWithThreadPootTask implements Runnable{
  private int taskId;
  public SimpleThreadWithThreadPootTask(int taskId){
    this.taskId = taskId;
  }

  @Override
  public void run() {
    System.out.println("task " + taskId + " is running in threadpoot - " + Thread.currentThread().getName());
  }
}
