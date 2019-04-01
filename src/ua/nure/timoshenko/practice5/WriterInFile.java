package ua.nure.timoshenko.practice5;

import java.io.IOException;
import java.io.RandomAccessFile;

public class WriterInFile extends Thread {
    private static final int STRING_LENGTH = 20;
    private RandomAccessFile file;
    private int numberString;

    WriterInFile(RandomAccessFile file, int numberString) {
        this.numberString = numberString;
        this.file = file;
    }

    @Override
    public void run() {
        synchronized (file) {
            try {
                file.seek(numberString);
                for (int j = 0; j < numberString; j++) {
                    for (int i = 0; i < STRING_LENGTH; i++) {
                        file.write('0' + j);
                        Thread.sleep(1);
                    }
                    file.write(System.lineSeparator().getBytes("cp1251"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
