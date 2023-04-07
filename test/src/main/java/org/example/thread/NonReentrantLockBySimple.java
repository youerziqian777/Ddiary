package org.example.thread;

/**
 * @Description 通过普通的方式实现不可重入锁
 * 这里第一次获取到锁后，再次上锁，线程1一直在等待，无法再次获取锁，也无法释放锁，这就是不可重入锁的死锁
 * @Date 2023/3/11 11:32
 */
public class NonReentrantLockBySimple {
  private boolean isLocked = false;

  public synchronized void lock() throws InterruptedException {
    while (isLocked) {
      wait();
    }
    isLocked = true;
  }

  public synchronized void unlock() {
    isLocked = false;
    notify();
  }

  public static void main(String[] args) {
    NonReentrantLockBySimple nonReentrantLockBySimple = new NonReentrantLockBySimple();
    Thread thread1 =
        new Thread(
            () -> {
              try {
                nonReentrantLockBySimple.lock();
                System.out.println("第一次上锁");
                nonReentrantLockBySimple.lock();
                System.out.println("第二次上锁");
                nonReentrantLockBySimple.unlock();
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
            });
    thread1.start();
  }
}
