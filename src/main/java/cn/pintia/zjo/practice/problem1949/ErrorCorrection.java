package cn.pintia.zjo.practice.problem1949;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Arrays;

public class ErrorCorrection implements Readable{
    private int count = 1;
    private int[] sumOfRows;
    private int[] sumOfColumns;
    private int[][] matrix;
    private int correctRow = 0;
    private int correctCol = 0;

    public ErrorCorrection(int[][] matrix) {
        this.matrix = matrix;
        sumOfRows = new int[matrix.length];
        sumOfColumns = new int[matrix.length];
        initArray(sumOfRows, 0);
        initArray(sumOfColumns, 0);
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                sumOfRows[row] += matrix[row][column];
                sumOfColumns[column] += matrix[row][column];
            }
        }
    }

    private boolean checkIfEven(int num) {
        return ((num & 1) == 0) ? true : false;
    }

    private void initArray(int[] arr, int val) {
        // Assert.notNull(arr);
        Arrays.fill(arr, val);
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }
        int cr = 0;
        int cc = 0;

        for (int k = 0; k < matrix.length; k++) {
            if (!checkIfEven(sumOfRows[k])) {
                correctRow++;
                if (correctRow == 1) {
                    cr = k + 1;
                }
            }
            if (!checkIfEven(sumOfColumns[k])) {
                correctCol++;
                if (correctCol == 1) {
                    cc = k + 1;
                }
            }
        }

        if (correctCol == 0 && correctRow == 0) {
            cb.append("OK\n");
        } else if (correctCol == 1 && correctRow == 1) {
            cb.append(String.format("Change bit (%d,%d)\n", new Object[]{cr, cc}));
        } else {
            cb.append("Corrupt\n");
        }


        return 10;
    }
}
