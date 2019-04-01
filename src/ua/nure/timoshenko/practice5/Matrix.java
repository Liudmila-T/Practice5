package ua.nure.timoshenko.practice5;

import java.security.SecureRandom;
import java.util.Random;

import static ua.nure.timoshenko.practice5.Util.*;

public class Matrix {
    private static final int START_RANDOM = 100;
    private static final int END_RANDOM = 999;
    private static final int SIZE_M = 4;
    private static final int SIZE_N = 5;
    private int m;
    private int n;
    private int[][] deepArray;

    public Matrix(int m, int n) {
        this.m = m;
        this.n = n;
        this.deepArray = new int[m][n];
    }

    private void addNumbers() {
        Random random = new SecureRandom();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int randomInt = START_RANDOM + random.nextInt(END_RANDOM - START_RANDOM);
                deepArray[i][j] = randomInt;
            }
        }
    }

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        Matrix matrixObj = new Matrix(SIZE_M, SIZE_N);
        matrixObj.addNumbers();
        for (int[] matr : matrixObj.deepArray) {
            result.append(arrayToString(matr));
        }
        writeFile(result.toString(), "part4.txt", "Cp1251");
    }
}

