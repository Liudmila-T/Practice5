package ua.nure.timoshenko.practice5;

public class SequentialSearch {
    private int[][] matrix;

    public SequentialSearch(int[][] matrix) {
        this.matrix = matrix.clone();
    }

    public  int[] getMaxValInRows() throws InterruptedException {
        int[] maxRows = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            maxRows[i] = matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] > maxRows[i]) {
                    maxRows[i] = matrix[i][j];
                     Thread.sleep(1);

                }
            }
        }
        return maxRows;
    }
    public  int getMaxVal(int[] maxRows) {
        int maxInMatrix = maxRows[0];

        for (int i = 1; i < maxRows.length; i++) {
            if (maxRows[i] > maxInMatrix) {
                maxInMatrix = maxRows[i];
            }
        }
        return maxInMatrix;
    }


}
