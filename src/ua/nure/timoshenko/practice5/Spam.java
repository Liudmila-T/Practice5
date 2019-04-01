package ua.nure.timoshenko.practice5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Spam {
    private static final int TIME_1 = 2000;
    private static final int TIME_2 = 4000;
    private static final int TIME_3 = 500;
    private int[] times;
    private String[] message;
    private Thread[] threads;


    public Spam(int[] times, String[] names) {
        this.times = times.clone();
        this.message = names.clone();
        this.threads = new Thread[times.length];
    }


    public void start() {
        for (int i = 0; i < times.length; i++) {
            threads[i] = new MyTreadPart2(times[i], message[i]);
            threads[i].start();

        }

    }

    public void stop() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }


    public static void main(String[] args) throws UnsupportedEncodingException {
        String[] messages = new String[]{"@@@", "bbbbbbb", "ccccc"};
        int[] times = new int[]{TIME_1, TIME_2, TIME_3};
        Spam p = new Spam(times, messages);
        p.start();
        BufferedReader in = new BufferedReader(new InputStreamReader((System.in), "Cp1251"));
        try {
          String s = in.readLine();
            System.out.println(s);
            p.stop();

    } catch(IOException e) {
        e.printStackTrace();
    }


}

public static class MyTreadPart2 extends Thread {
    private int time;
    private String name;

    public MyTreadPart2(int time, String name) {
        this.time = time;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(name);

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
}
