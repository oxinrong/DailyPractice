package java_base.concurrency;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ActiveObjectDemo {
    private ExecutorService exec = Executors.newSingleThreadExecutor();
    private Random random = new Random(47);

    private void pause(int factor) {
        try {
            TimeUnit.MILLISECONDS.sleep(100 + random.nextInt(factor));
        } catch (InterruptedException e) {
            System.out.println("Sleep() interrupted!!!");
        }
    }

    public Future<Integer> calculateInt(final int x, final int y) {
        return exec.submit(new Callable<Integer>() {
            @Override
            public Integer call() {
                System.out.println("starting " + x + " + " + y);
                pause(500);
                return x + y;
            }
        });
    }

    public Future<Float> calculateFloat(final float x, final float y) {
        return exec.submit(new Callable<Float>() {
            @Override
            public Float call() {
                System.out.println("starting " + x + " + " + y);
                pause(2000);
                return x + y;
            }
        });
    }

    public void shutdown() {
        exec.shutdown();
    }

    public static void main(String[] args) {
        ActiveObjectDemo activeObjectDemo = new ActiveObjectDemo();
        List<Future<?>> results = new CopyOnWriteArrayList<>();

        for (float f = 0.0f; f < 1.0f; f += 0.2f)
            results.add(activeObjectDemo.calculateFloat(f, f));
        for (int i = 0; i < 5; i++) {
            results.add(activeObjectDemo.calculateInt(i, i));
        }

        System.out.println("All asynch calls made");

        while (results.size() > 0) {
            for (Future<?> f : results) {
                if (f.isDone()) {
                    try {
                        System.out.println(f.get());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    results.remove(f);
                }
            }
        }
        activeObjectDemo.shutdown();
    }
}
