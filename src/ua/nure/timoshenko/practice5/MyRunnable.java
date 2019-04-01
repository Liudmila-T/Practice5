package ua.nure.timoshenko.practice5;

class MyRunnable implements Runnable {

    @Override
    public void run() {
        new MyThread().start();
    }
}
