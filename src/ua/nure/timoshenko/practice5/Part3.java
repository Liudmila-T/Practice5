package ua.nure.timoshenko.practice5;

public class Part3 {
    public static final int QUANTITY_THREADS = 3;
    private static final int SLEEP_MILLIS = 1000;

    public static void main(String[] args) {
        Counter counter = new Counter();
        CounterThread[] counterThreads = new CounterThread[QUANTITY_THREADS];
        for (int i = 0; i < counterThreads.length; i++) {
            counterThreads[i] = new CounterThread(counter);
            counterThreads[i].start();
        }
        try {
            Thread.sleep(SLEEP_MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        Counter counter2 = new Counter();
        CounterSynchronizedThread[] counterSynchronized = new CounterSynchronizedThread[QUANTITY_THREADS];
        for (int i = 0; i < counterSynchronized.length; i++) {
            counterSynchronized[i] = new CounterSynchronizedThread(counter2);
            counterSynchronized[i].start();
        }
        try {
            Thread.sleep(SLEEP_MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}


