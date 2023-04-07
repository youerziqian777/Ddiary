package org.example.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 使用AtomicInteger来实现乐观锁
 * AtomicInteger可以对一个int值进行原子操作，原子操作是指不会被其他线程干扰
 * @Date 2023/3/10 23:21
 */
public class OptimisticLockWithAtomicInteger {
  private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();

  public static void main(String[] args) throws InterruptedException {
    Thread thread1 =
        new Thread(
            () -> {
              int currentValue = ATOMIC_INTEGER.get();
              try {
                Thread.sleep(1000);
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
              // 尝试更新为新值
              boolean success = ATOMIC_INTEGER.compareAndSet(currentValue, currentValue + 1);
			  System.out.println("线程1：" + success);
            });
    Thread thread2 =
        new Thread(
            () -> {
              int currentValue = ATOMIC_INTEGER.get();
              // 尝试更新为新值
              boolean success = ATOMIC_INTEGER.compareAndSet(currentValue, currentValue + 1);
				System.out.println("线程2：" + success);
            });
    thread1.start();
    thread2.start();
    thread1.join();
    thread2.join();
    System.out.println("最终结果：" + ATOMIC_INTEGER.get());
  }
}
