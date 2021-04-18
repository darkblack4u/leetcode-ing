> # 多线程

**35.并行和并发有什么区别？**
```
并发：是指多个线程任务在同一个CPU上快速地轮换执行，由于切换的速度非常快，给人的感觉就是这些线程任务是在同时进行的，但其实并发只是一种逻辑上的同时进行；
并行：是指多个线程任务在不同CPU上同时进行，是真正意义上的同时执行。
```
36.线程和进程的区别？

37.守护线程是什么？

38.创建线程有哪几种方式？

39.说一下 runnable 和 callable 有什么区别？

**40.线程有哪些状态？**
```
1.新建状态(New)：
当用new操作符创建一个线程时， 例如new Thread(r)，线程还没有开始运行，此时线程处在新建状态。当一个线程处于新生状态时，程序还没有开始运行线程中的代码。
2.就绪状态(Runnable)：
一个新创建的线程并不自动开始运行，要执行线程，必须调用线程的start()方法。当线程对象调用start()方法即启动了线程，start()方法创建线程运行的系统资源，并调度线程运行run()方法。当start()方法返回后，线程就处于就绪状态。
处于就绪状态的线程并不一定立即运行run()方法，线程还必须同其他线程竞争CPU时间，只有获得CPU时间才可以运行线程。因为在单CPU的计算机系统中，不可能同时运行多个线程，一个时刻仅有一个线程处于运行状态。因此此时可能有多个线程处于就绪状态。对多个处于就绪状态的线程是由Java运行时系统的线程调度程序(thread scheduler)来调度的。

3.运行状态(Running)
当线程获得CPU时间后，它才进入运行状态，真正开始执行run()方法.
4. 阻塞状态(Blocked)
阻塞状态是指线程因为某种原因放弃了cpu 使用权，也即让出了cpu timeslice，暂时停止运行。直到线程进入可运行(runnable)状态，才有机会再次获得cpu timeslice 转到运行(running)状态。阻塞的情况分三种：

等待阻塞：运行(running)的线程执行o.wait()方法，JVM会把该线程放入等待队列(waitting queue)中。

同步阻塞：运行(running)的线程在获取对象的同步锁时，若该同步锁被别的线程占用，则JVM会把该线程放入锁池(lock pool)中。

其他阻塞：运行(running)的线程执行Thread.sleep(long ms)或t.join()方法，或者发出了I/O请求时，JVM会把该线程置为阻塞状态。当sleep()状态超时、
join()等待线程终止或者超时、或者I/O处理完毕时，线程重新转入可运行(runnable)状态。

5. 死亡状态(Dead)
有两个原因会导致线程死亡：

run方法正常退出而自然死亡，

一个未捕获的异常终止了run方法而使线程猝死。

为了确定线程在当前是否存活着（就是要么是可运行的，要么是被阻塞了），需要使用isAlive方法。如果是可运行或被阻塞，这个方法返回true； 如果线程仍旧是new状态且不是可运行的， 或者线程死亡了，则返回false.
```
**41.sleep() 和 wait() 有什么区别？**
```
sleep()和wait()都是线程暂停执行的方法。

1、这两个方法来自不同的类分别是Thread和Object，sleep方法属于Thread类中的静态方法，wait属于Object的成员方法。
2、sleep()是线程类（Thread）的方法，不涉及线程通信，调用时会暂停此线程指定的时间，但监控依然保持，不会释放对象锁，到时间自动恢复；wait()是Object的方法，用于线程间的通信，调用时会放弃对象锁，进入等待队列，待调用notify()/notifyAll()唤醒指定的线程或者所有线程，才进入对象锁定池准备获得对象锁进入运行状态。
3、wait，notify和notifyAll只能在同步控制方法或者同步控制块里面使用，而sleep可以在任何地方使用（使用范围）。
4、sleep()方法必须捕获异常InterruptedException，而wait()\notify()以及notifyAll()不需要捕获异常。
```

42.notify()和 notifyAll()有什么区别？

**43.线程的 run()和 start()有什么区别？**
```
调用 start() 方法是用来启动线程的，轮到该线程执行时，会自动调用 run()；直接调用 run() 方法，无法达到启动多线程的目的，相当于主线程线性执行 Thread 对象的 run() 方法。
一个线程对线的 start() 方法只能调用一次，多次调用会抛出 java.lang.IllegalThreadStateException 异常；run() 方法没有限制。
```
44.创建线程池有哪几种方式？

**45.线程池都有哪些状态？**
```
RUNNING：线程池一旦被创建，就处于 RUNNING 状态，任务数为 0，能够接收新任务，对已排队的任务进行处理。
SHUTDOWN：不接收新任务，但能处理已排队的任务。调用线程池的 shutdown() 方法，线程池由 RUNNING 转变为 SHUTDOWN 状态。
STOP：不接收新任务，不处理已排队的任务，并且会中断正在处理的任务。调用线程池的 shutdownNow() 方法，线程池由(RUNNING 或 SHUTDOWN ) 转变为 STOP 状态。
TIDYING：
    SHUTDOWN 状态下，任务数为 0， 其他所有任务已终止，线程池会变为 TIDYING 状态，会执行 terminated() 方法。线程池中的 terminated() 方法是空实现，可以重写该方法进行相应的处理。
    线程池在 SHUTDOWN 状态，任务队列为空且执行中任务为空，线程池就会由 SHUTDOWN 转变为 TIDYING 状态。
    线程池在 STOP 状态，线程池中执行中任务为空时，就会由 STOP 转变为 TIDYING 状态。
TERMINATED：线程池彻底终止。线程池在 TIDYING 状态执行完 terminated() 方法就会由 TIDYING 转变为 TERMINATED 状态。
```

46.线程池中 submit()和 execute()方法有什么区别？

47.在 java 程序中怎么保证多线程的运行安全？

48.多线程锁的升级原理是什么？

49.什么是死锁？

50.怎么防止死锁？

51.ThreadLocal 是什么？有哪些使用场景？

52.说一下 synchronized 底层实现原理？

53.synchronized 和 volatile 的区别是什么？

54.synchronized 和 Lock 有什么区别？

55.synchronized 和 ReentrantLock 区别是什么？

56.说一下 atomic 的原理？