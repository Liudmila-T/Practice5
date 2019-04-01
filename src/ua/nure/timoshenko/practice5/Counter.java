package ua.nure.timoshenko.practice5;

public class Counter {
    private static final int MILLIS = 10;
    private  int count1;
    private  int count2;

    public   static void incrementCounter (Counter counter) throws InterruptedException {
        System.out.println((counter.count1 == counter.count2)+" "+(counter.count1+" "+counter.count2));
        counter.count1++;
        Thread.sleep(MILLIS);
        counter.count2++;
    }
    public  static synchronized void incrementCounterSynchronized (Counter counter) throws InterruptedException {
        incrementCounter(counter);
    }
}
