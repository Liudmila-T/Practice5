package ua.nure.timoshenko.practice5;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class Part2 {
    private static final int DELAY = 3000;
    private static final InputStream STD_IN = System.in;

    public static void main(String[] args) {
        // create the mock input
        MyInputStream mockIn = new MyInputStream(DELAY);
        // set the mock input
        System.setIn(mockIn);
        // start the thread for delayed output
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    Spam.main(null);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                // nothing to do
            }
        };
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();

        }
        // restore the standard input
        System.setIn(STD_IN);

    }
}



