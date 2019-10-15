package java_base.concurrency;

public class SingletonDemo {


}

/*
    饿汉式：空间换时间
    实际开发用
 */
class Singleton1 {
    private static Singleton1 singleton1 = new Singleton1();
    private Singleton1() {}

    public static Singleton1 getInstance() {
        return singleton1;
    }
}


/*
    懒汉式：时间换空间，多线程情况下可能会创建多个对象
    面试用
 */
class Singleton2 {
    private Singleton2() {}
    private static Singleton2 singleton2;

    public static Singleton2 getInstance() {
        if (singleton2 == null)
            singleton2 = new Singleton2();
        return singleton2;
    }
}

/*
    线程安全的懒汉式
    内层的检查保证对象在并发时不会重复创建 和！对象尚未初始化完成，
    外层检查避免每一次获取对象都对资源进行加锁，影响性能，
    所以才会有了并发情况下的线程安全的懒汉单例，即 Double Check Lock;
    而 volatile 在此是禁止指令重排的作用，保证先初始化，再把对象引用赋值给 instance 变量。
 */

class Singleton22 {
    private Singleton22() {}
    private volatile static Singleton22 singleton22;
    // 双重锁
    public static Singleton22 getInstance() {
        if (singleton22 == null) {
            synchronized (Singleton22.class) {
                if (singleton22 != null) {
                    singleton22 = new Singleton22();
                }
            }
        }

        return singleton22;
    }
}


// 第三种
class Singleton3 {
    private Singleton3() {}
    // 直接利用类访问
    public static final Singleton3 singleton = new Singleton3();
}


// 静态内部类
final class Singleton {

    private Singleton() {
        //
    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}