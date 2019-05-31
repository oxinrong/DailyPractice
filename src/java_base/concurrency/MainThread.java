package java_base.concurrency;

public class MainThread {
    public static void main(String[] args) {
        LiftOff launch = new LiftOff(18);
        launch.run();
    }
}
