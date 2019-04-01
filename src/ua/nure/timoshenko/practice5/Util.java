package ua.nure.timoshenko.practice5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;


public final class Util {

    private static final String EOL = System.lineSeparator();
    private static final String SPACE = " ";

    private Util() {
        super();
    }

    public static String readFile(String path, String charSet) {
        StringBuilder result = new StringBuilder();
        String s;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), charSet))) {
            while ((s = br.readLine()) != null) {
                result.append(s).append(EOL);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void writeFile(String text, String name, String charSet) {
        try (BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name, false),charSet))) {
            bw.write(text);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String arrayToString(int[] array)  {
        StringBuilder result = new StringBuilder();
        if (array.length != 0) {
            for (int i = 0; i < array.length - 1; i++) {
                result.append(array[i]).append(SPACE);
            }
            result.append(EOL);
               }
        return result.toString();
    }


    public static int[][] toArray(String input) {
        String[] arrayRows = input.split(EOL);

        String[][] elements = new String[arrayRows.length][];
        int[][] matrix = new int[elements.length][];
        for (int i = 0; i < arrayRows.length; i++) {
            elements[i] = arrayRows[i].split(" ");
            matrix[i] = new int[elements[i].length];
            for (int j = 0; j < elements[i].length; j++) {
                matrix[i][j] = Integer.parseInt(elements[i][j]);

            }
        }
        return matrix;
    }
}