package java_base.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {
    private IntGenerator intGenerator;
    private final int id;

    public EvenChecker(IntGenerator g, int ident) {
        intGenerator = g;
        id = ident;
    }

    @Override
    public void run() {
        while ( !intGenerator.isCanceled() ) {
            int val = intGenerator.next();
            if ( val % 2 != 0 ) {
                System.out.println( val + "not even !");
                intGenerator.cancel();
            }
        }
    }

    public static void test ( IntGenerator gp, int count ) {
        System.out.println("Press ctrl + c to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(gp, i));
        }
        exec.shutdown();
    }

    public static void test (IntGenerator gp) {
        test(gp, 10);
    }
}
