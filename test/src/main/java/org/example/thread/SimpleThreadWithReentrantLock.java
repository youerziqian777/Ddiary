package org.example.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description ReentrantLock实现简单多线程
 * @Date 2023/3/4 21:07
 */
public class SimpleThreadWithReentrantLock {
  private static final ReentrantLock lock = new ReentrantLock();

  public static void main(String[] args) {
    Thread thread1 = new Thread(new SimpleThreadWithReentrantLockTask());
    Thread thread2 = new Thread(new SimpleThreadWithReentrantLockTask());

    thread1.start();
    thread2.start();
  }
  static class SimpleThreadWithReentrantLockTask implements Runnable{

    @Override
    public void run() {
      try {
        //获取锁
        lock.lock();
        System.out.println("task is running in thread " + Thread.currentThread().getName());
      } finally {
        //必须要释放锁
        lock.unlock();
      }
    }
  }

}


