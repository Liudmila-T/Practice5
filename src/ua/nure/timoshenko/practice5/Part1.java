package ua.nure.timoshenko.practice5;

public class Part1 {

    private static final int MILLIS = 2100;

    public static void main(String[] args) {
        try {
            Thread thread1 = new MyThread();
            thread1.start();
            thread1.join();

            Thread thread2 = new Thread(new MyRunnable());
            thread2.start();
            thread2.join();
            Thread.sleep(MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

    }
}

