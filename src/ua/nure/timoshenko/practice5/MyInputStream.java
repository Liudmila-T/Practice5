package ua.nure.timoshenko.practice5;

import java.io.InputStream;

public class MyInputStream extends InputStream {
    private static final int QUANTITY_ELEMENTS = 2;
    private long millis;
    private boolean isFirstCall = true;
    private int current;
    private byte[] bytes = new byte[QUANTITY_ELEMENTS];

    public MyInputStream(long millis) {
        super();
        this.millis = millis;
    }

    @Override
    public int read() {
        try {
            if (isFirstCall) {
                Thread.sleep(millis);
            }
                isFirstCall = false;

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return -1;
        }
        if (current < bytes.length) {
            return bytes[current++];
        }
        return -1;
    }

}
