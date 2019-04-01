package ua.nure.timoshenko.practice5;


public class ParallelSearch extends Thread {
    private int[] rows;
    private int maxRows;

    public ParallelSearch(int[] rows) {
        this.rows = rows.clone();
        maxRows = rows[0];
    }

    public int getMaxRows() {
        return maxRows;
    }

    @Override
    public void run() {
        for (int i = 1; i < rows.length; i++) {
            if (rows[i] > maxRows) {
                maxRows = rows[i];
            }
        }
    }

}


