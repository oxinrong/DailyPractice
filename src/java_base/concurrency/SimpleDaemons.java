package java_base.concurrency;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);

            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                Thread daemon = new Thread(new SimpleDaemons());
                daemon.setDaemon(true);
                daemon.start();
            }
            System.out.println("All daemon started");
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }
}
