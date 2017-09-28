>
根据案例引出线程的创建和启动:
并发的干一件事情（企图并发） 读数据库的过程中去写磁盘的一些东西（模拟）

![](http://oo31b5ljj.bkt.clouddn.com/%E4%BC%81%E5%9B%BE%E5%B9%B6%E5%8F%913.png)
- 为了显得慢一点让它休眠(Thread.sleep)一下，sleep后面会详细说，这里可以暂时理解为线程进入 block 状态。

- 想要的效果是让这两个方法同时去执行。

![](http://oo31b5ljj.bkt.clouddn.com/%E4%BC%81%E5%9B%BE%E5%B9%B6%E5%8F%91%E8%BF%90%E8%A1%8C.png)

- 大家可以看到它并没有交替的去执行而是等readFromDataBase()方法执行完后writeDataToFile()方法才执行,这就导致了程序只能一件事情一件事情的去处理，不能同时处理。

- 再比如有两块要执行的代码逻辑单元，它同样也是一步一步的顺序去执行，并不会是交替(同时)的去执行。
```java
public static void main(String[] args) {

for(int i = 0; i<=1000; i++) {
System.out.println("Task 1=>" + i);
}

for(int j = 0; j<=1000; j++) {
System.out.println("Task 2=>" + j);
}
}
```

- 运行效果
![](http://oo31b5ljj.bkt.clouddn.com/%E4%BC%81%E5%9B%BE%E5%B9%B6%E5%8F%912.png)

- 只有等i全部输出完后才会去执行j的东西那么怎样才能同时去运行呢? 我们先来看些Java对多线程的支持
![](http://oo31b5ljj.bkt.clouddn.com/JDK%E6%96%87%E6%A1%A3-Thread.png)

- 根据Java官方文档可以看出刚才写的程序，其实有意无意的已经创建了一个线程，这个线程是main线程。

- 如何去验证“当虚拟机启动的时，通常有一个非守护线程呢”?

- 先让这个程序休眠的时间长一点打开jconsole工具看一看
![](http://oo31b5ljj.bkt.clouddn.com/main%E7%BA%BF%E7%A8%8B.png)
- JVM创建一个main线程，也就是说整个Application有一个main函数,它就是根据main函数创建一个main线程，然后这个mian函数被调用，调用的时候会开辟一个线程，这个线程的名字就叫main,也就是说JVM启动的时候创建了一个守护线程和非守护线程。
![](http://oo31b5ljj.bkt.clouddn.com/JVM-%E7%BA%BF%E7%A8%8B.png)

- 那么怎么创建一个线程让readFromDataBase()方法执行完后writeDataToFile()方法是并发\并行去执行的？

- 根据官方文档说，有`两种方式创建一个线程`，第一种方式是声明一个clss他是Thread的子类，这种方式需要覆盖run方法，这个实例一但启动然后他就是一个线程。

- 这里我写了一个内部类 然后重写run方法，然后把要执行的代码逻辑单元放进去：
```java
public static void main(String[] args) {
Thread t = new Thread("READ-Thread"){
@Override
public void run() {
for(int i = 0; i<=1000; i++) {
System.out.println("Task 1=>" + i);
}
}
};
}
```

- 这时候Thread只是Java的一个实例而已，他和任何Java的实例都一模一样，并不代表他是个线程，只有把他启动之后才会是一个线程，而且这个启动是立即返回的，他不是一个block 方法。
```java
public static void main(String[] args) {
// 内部类
Thread t = new Thread(){
@Override
public void run() {
for(int i = 0; i<=1000; i++) {
System.out.println("Task 1=>" + i);
}
}
};
t.start()
for(int j = 0; j<=1000; j++) {
System.out.println("Task 2=>" + j);
}
}
```


- 现在就有两个线程了一个是t，一个是main函数执行的。

- 运行效果
![](http://oo31b5ljj.bkt.clouddn.com/%E4%BA%A4%E6%9B%BF%E6%95%88%E6%9E%9C.png)

- 现在我们回过头来看看前面提到的，读数据库的过程中将数据写入文件：
```java
public static void main(String[] args) {
// 匿名内部类
// READ-Thread 为线程名称
new Thread("READ-Thread"){
@Override
public void run() {
readFromDataBase();
}
}.start();

new Thread("WRITE-Thread"){
@Override
public void run() {
writeDataToFile();
}
}.start();
}
```

- 运行效果

![](http://oo31b5ljj.bkt.clouddn.com/%E5%B9%B6%E5%8F%91%E5%AE%8C%E6%88%90.png)

- 这时候就有交替(`由CPU去切换执行权`)的情况了，但是线程有比较头疼的地方，这个执行顺序会引发一些安全的一些问题。
- 创建线程的方式这里根据内部类和匿名内部类的方式去做的，大家也可以去写一个Thread的子类，然后复写里面的run方法然后再去调用:
```java
public class MyThread extends Thread {
@Override
public void run() {
for(int i = 0; i<=1000; i++) {
System.out.println("Task 1=>" + i);
}
}
}
public static void main(String[] args) {
MyThread thread = new MyThread();
thread.start();
}
```

- 第二种实现接口的方法以后再说