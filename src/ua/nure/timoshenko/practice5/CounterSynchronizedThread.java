package ua.nure.timoshenko.practice5;

import static ua.nure.timoshenko.practice5.Counter.incrementCounterSynchronized;

class CounterSynchronizedThread extends Thread {
    private Counter counter;

    public CounterSynchronizedThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        int i = 0;
        try {
            while (i < Part3.QUANTITY_THREADS) {
                incrementCounterSynchronized(counter);
                i++;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
