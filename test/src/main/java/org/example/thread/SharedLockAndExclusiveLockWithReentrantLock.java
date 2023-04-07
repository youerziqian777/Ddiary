package org.example.thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description 通过RenentrantLock实现排他锁、共享锁
 * 这里实现了两个共享锁，里面都改了数据，但是这是不正确的用法
 * 共享锁正确的用法应该只读不写
 * @Date 2023/3/11 0:43
 */
public class SharedLockAndExclusiveLockWithReentrantLock {
  private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
  private static int data = 0;

  //共享锁1
  private static class SharedLockTask1 implements Runnable {

    @Override
    public void run() {
      try {
        lock.readLock().lock(); // 获取读锁
        data++;
        System.out.println(Thread.currentThread().getName() + "read1 data: " + data);
      } finally {
        lock.readLock().unlock(); // 释放读锁
      }
    }
  }
  //共享锁2
  private static class SharedLockTask2 implements Runnable {

    @Override
    public void run() {
      try {
        lock.readLock().lock(); // 获取读锁
        data++;
        System.out.println(Thread.currentThread().getName() + "read2 data: " + data);
      } finally {
        lock.readLock().unlock(); // 释放读锁
      }
    }
  }

  //排它锁
  private static class ExclusiveLockTask implements Runnable {
    @Override
    public void run() {
      try {
        lock.writeLock().lock(); // 获取写锁
        data++;
        System.out.println(Thread.currentThread().getName() + "write data: " + data);
      } finally {
        lock.writeLock().unlock(); // 释放写锁
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    Thread threadRead1 = new Thread(new SharedLockTask1());
    Thread threadRead2 = new Thread(new SharedLockTask2());
    Thread threadWrite = new Thread(new ExclusiveLockTask());
    threadRead1.start();
    threadRead2.start();
    threadWrite.start();

    threadRead1.join();
    threadRead2.join();
    threadWrite.join();

    System.out.println("最终结果data：" + data);
  }
}
