package ua.nure.timoshenko.practice5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;


public class Part5 {

    private static final int QUANTITY_THREADS = 10;
    private Thread[] threads;
    private static final String FILENAME = "part5.txt";
    private RandomAccessFile raf;

    public Part5() {
        threads = new WriterInFile[QUANTITY_THREADS];

        try {
            raf = new RandomAccessFile(FILENAME, "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new WriterInFile(raf, QUANTITY_THREADS);

        }
    }


    private void waitAllThreads() throws InterruptedException {
        for (int i = 0; i < threads.length; i++) {
            while (threads[i].isAlive()) {
                Thread.sleep(1);
            }
        }
    }

    public void startThreads() throws InterruptedException {

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        waitAllThreads();
    }

    public void stopThreads() {

        for (int i = 0; i < threads.length; i++) {
            threads[i].interrupt();
        }
        try {
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile() {
        File file = new File(FILENAME);
        try {
            if (file.exists()) {
                Files.delete(file.toPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Part5.deleteFile();
        Part5 p5 = new Part5();
        try {
            p5.startThreads();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        p5.stopThreads();
        System.out.println(Util.readFile(FILENAME, "cp1251"));

    }

}
