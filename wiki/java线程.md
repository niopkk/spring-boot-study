##### java Thread

###### 新建一个线程

```java
Thread thread = new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.printf("新建一个线程");
    }
});
thread.start();//启动线程
```

##### 线程中断

```java
public void interrupt() //中断线程
public boolean isInterrupted() //判断是否被中断
public static boolean interrupted() //判断是否被中断，并清除中断状态
```

Thread.interrupt():方法是一个实例方法，它通知目标线程中断，也就是设置线程中断标志位。中断标志位表示当前线程已经被中断。

Thread.isInterrupted():方法也是一个实例方法，判断当前线程是否被中断(通过检查中断标志位)。

Thread.interrupted():是一个静态方法,可以判断当前线程的中断状态,但同时会清除当前线程的中断标志位。

```java
//中断线程案例
public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //通过判断isInterrupted()中断标志位来确定终止线程。
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Interrupt");
                        break;
                    }
                    Thread.yield();//释放当前线程，和所有就绪的线程重新开始竞争cup。
                }
            }
        });

        t1.start();

        Thread.sleep(2000);

        t1.interrupt();//设置中断标志位，只是设置中断标志位并不能将线程中断，需要在线程里面进行判断后终止

    }
```

Thread.sleep():让当前线程休息若干时间,它会抛出一个InterruptedException中断异常,InterruptedException不是运行时异常,程序必须捕获并处理它,当线程在sleep()休眠时,如果被中断,这个异常就会产生。

⚠️  **Thread.sleep()方法由于中断而抛出异常，此时，它会清除中断标记，如果不加处理，那么在下一次循环开始时，就无法捕获这个中断，故在异常处理中，再次设置中断标记位**。

```java
public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                //通过判断isInterrupted()中断标志位来确定终止线程。
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Interrupt");
                    break;
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    //设置中断标志位，因为try catch 会将中断标志位重制，
                    // 导致Thread.currentThread().isInterrupted()判断一直为false，不能正常终止线程。
                    Thread.currentThread().interrupt();
                }
                Thread.yield();//释放当前线程，和所有就绪的线程重新开始竞争cup。
            }
        }
    });
    t1.start();
    Thread.sleep(2000);
    t1.interrupt();//设置中断标志位，只是设置中断标志位并不能将线程中断，需要在线程里面进行判断后终止
}
```

##### 等待(wait)和通知(notify)

当在一个对象实例上调用wait()方法后，当前线程就会在这个对象上等待。这是什么意思呢？比如，在线程A中，调用了obj.wait()方法，那么线程A就会停止继续执行，转为等待状态。等待到何时结束呢？线程A会一直等到其他线程调用了obj.notify()方法为止。这时，object对象俨然成了多个线程之间的有效通信手段。

**Object.wait()方法并不能随便调用。它必须包含在对应的synchronzied语句中，无论是wait()方法或者notify()方法都需要首先获得目标对象的一个监视器**

```java
final static Object object = new Object();

public static class T1 extends Thread {
    @Override
    public void run() {

        synchronized (object) {
            System.out.println(System.currentTimeMillis() + ":T1 start!");
            try {
                System.out.println(System.currentTimeMillis() + ":T1 wait for object");
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + ":T1 end!");
        }
    }
}

public static class T2 extends Thread {
    @Override
    public void run() {

        synchronized (object) {
            System.out.println(System.currentTimeMillis() + ":T2 start! notify on thread");
            object.notify();
            System.out.println(System.currentTimeMillis() + ":T2 end!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

public static void main(String[] args) throws InterruptedException {
    Thread t1 = new T1();
    Thread t2 = new T2();
    t1.start();
    t2.start();
}
```

##### volatile和java内存模型(JMM)

Java内存模型都是围绕着原子性、有序性和可见性展开的.

当用volatile声明一个变量的时候，变量修改后应用程序范围内的所有线程都能够“看到”这个改动。
volatile只能保证内存的可见行，不能保存原子性.

##### java.util.concurrent.locks.ReentrantLock

简单例子

```java
public class ReenterLock implements Runnable {
    ReentrantLock lock = new ReentrantLock();
    private static int i = 0;
    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            lock.lock();//加锁
            try {
                i++;
            } finally {
                lock.unlock();//解锁
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ReenterLock reenterLock = new ReenterLock();
        Thread t1 = new Thread(reenterLock);
        Thread t2 = new Thread(reenterLock);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);


    }
}
```

