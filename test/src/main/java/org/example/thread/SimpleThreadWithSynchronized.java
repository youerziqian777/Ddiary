package org.example.thread;
/**
 * @Description 简单多线程  synchronized
 * @Date 2023/3/2 13:47
 */
public class SimpleThreadWithSynchronized {
  private int count = 0;

  synchronized void methoed() {
    count++;
  }

  public static void main(String[] args) throws InterruptedException {
    SimpleThreadWithSynchronized test = new SimpleThreadWithSynchronized();
    Thread thread1 =
        new Thread(
            () -> {
              for (int j = 0; j <= 10; j++) {
                test.methoed();
              }
            });

    Thread thread2 =
        new Thread(
            () -> {
              for (int j = 0; j <= 10; j++) {
                test.methoed();
              }
            });

    thread1.start();
    thread2.start();

    thread1.join();
    thread2.join();
    System.out.println("结果: " + test.count);
  }
}
