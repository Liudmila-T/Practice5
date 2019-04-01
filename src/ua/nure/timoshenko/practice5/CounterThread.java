package ua.nure.timoshenko.practice5;


import static ua.nure.timoshenko.practice5.Counter.incrementCounter;

class CounterThread extends Thread {
    private Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        int i = 0;
        try {
            while (i < Part3.QUANTITY_THREADS) {
                incrementCounter(counter);
                i++;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
