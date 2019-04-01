package ua.nure.timoshenko.practice5;

public class Part4 {
    private int[][] matrix;
    private ParallelSearch[] parallelSearches;
    private SequentialSearch sequentialSearch;

    public Part4(int[][] matrix) {
        this.matrix = matrix.clone();
        parallelSearches = new ParallelSearch[matrix.length];
        sequentialSearch = new SequentialSearch(matrix);
    }

    public static void main(String[] args) throws InterruptedException {
        String s = Util.readFile("part4.txt", "Cp1251");
        int[][] arr = Util.toArray(s);
        Part4 part4 = new Part4(arr);

        long timeParallelStart = System.currentTimeMillis();
        System.out.println(part4.findMaxValWithParallelSearch());
        System.out.println(System.currentTimeMillis() - timeParallelStart);

        long timeSequentialStart = System.currentTimeMillis();
        System.out.println(part4.findMaxValWithSequentialSearch());
        System.out.println(System.currentTimeMillis() - timeSequentialStart);
    }


    public int findMaxValWithParallelSearch() {
        int[] maxRows = new int[matrix.length];
        for (int i = 0; i < maxRows.length; i++) {
            parallelSearches[i] = new ParallelSearch(matrix[i]);
            parallelSearches[i].start();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }

            maxRows[i] = parallelSearches[i].getMaxRows();
        }
        int maxValInMatrix = maxRows[0];
        for (int i = 1; i < maxRows.length; i++) {
            if (maxValInMatrix < maxRows[i]) {
                maxValInMatrix = maxRows[i];

            }
        }
        return maxValInMatrix;
    }

    public int findMaxValWithSequentialSearch() throws InterruptedException {
        return sequentialSearch.getMaxVal(sequentialSearch.getMaxValInRows());
    }
}

