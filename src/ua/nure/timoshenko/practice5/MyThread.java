package ua.nure.timoshenko.practice5;

class MyThread extends Thread {

    private static final int ALL_TIMES = 2000;
    private static final int PERIOD = 500;

    @Override
    public void run() {
        long timeStart = System.currentTimeMillis();
        while (System.currentTimeMillis() - timeStart <= ALL_TIMES) {
            try {
                Thread.sleep(PERIOD);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName());
        }

    }
}
