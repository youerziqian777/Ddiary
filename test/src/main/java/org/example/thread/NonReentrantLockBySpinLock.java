package org.example.thread;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description 实现自旋锁，是不可重入锁的一种
 * 这里也是第一次上锁的时候，没有释放锁就一直阻塞第二次获得锁
 * @Date 2023/3/11 11:54
 */
public class NonReentrantLockBySpinLock {
	//存储当前持有锁的线程引用
	private AtomicReference<Thread> owner = new AtomicReference<>();

	//上锁
	public void lock(){
		Thread current = Thread.currentThread();
		//不断尝试将线程引用设置到AtomicReference对象中，直到成功为止
		while(!owner.compareAndSet(null,current)){

		}
	}

	//解锁
	public void unlock(){
		Thread current = Thread.currentThread();
		//不断尝试将AtomicReference对象中的线程引用设置为null，表示释放锁
		owner.compareAndSet(current,null);
	}

  public static void main(String[] args) {
	  NonReentrantLockBySpinLock lock = new NonReentrantLockBySpinLock();
	  Thread thread1 = new Thread(new Runnable() {
		  @Override
		  public void run() {
			  lock.lock();
			  System.out.println("第一次上锁");
			  lock.lock();
			  System.out.println("第二次上锁");
			  lock.unlock();
			  System.out.println("解锁");
		  }
	  });
	  thread1.start();
  }
}
