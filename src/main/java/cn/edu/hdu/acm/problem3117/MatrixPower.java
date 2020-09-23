package cn.edu.hdu.acm.problem3117;

import java.util.Arrays;

/**
 * @author Administrator
 * @Description 通过矩阵幂运算求出
 */
public class MatrixPower {
    // 4位数 mod 10000
    private final int mod = 10000;

    private int N;
    private Matrix m;
    private Matrix result;

    private static class Matrix {
        int row = 2;
        int col = 2;
        int[][] m = new int[row][col];
        public Matrix() {
            for (int r = 0; r < row; r++) {
                Arrays.fill(m[r], 0);
            }
            cellMatrix(m);
        }

        public Matrix(int[][] m) {
            this.m = m;
        }

        private void cellMatrix(int[][] m) {
            for (int i = 0; i < m.length; i++) {
                m[i][i] = 1;
            }
        }

        @Override
        public String toString() {
            return "Matrix{" +
                    "row=" + row +
                    ", col=" + col +
                    ", m=" + Arrays.deepToString(m) +
                    '}';
        }
    }

    public MatrixPower(int N) {
        this.N = N;
        m = new Matrix();
        this.result = matrixPow(this.N);
    }

    private Matrix mul(Matrix A, Matrix B) {
        Matrix ans = new Matrix();
        final int matrixScale = 2;
        int tmp;
        for (int i = 0; i < matrixScale; i++) {
            for (int j = 0; j < matrixScale; j++) {
                tmp = 0;
                for (int k = 0; k < matrixScale; k++) {
                    tmp += A.m[i][k] % mod * B.m[k][j] % mod;
                }
                ans.m[i][j] = tmp % mod;
            }
        }

        return ans;
    }

    private Matrix matrixPow(int N) {
        Matrix ans = new Matrix();
        Matrix matrix = new Matrix(new int[][]{{1, 1}, {1, 0}});
        int pow = N - 1;
        while (pow > 0) {
            if ((pow & 1) == 1) {
                ans = mul(ans, matrix);
            }

            matrix = mul(matrix, matrix);
            pow >>= 1;
        }

        return ans;
    }

    public static CharSequence tailForFibNum(int N) {
        MatrixPower matrixPower = new MatrixPower(N);
        return String.format("%04d", matrixPower.result.m[0][0]);
    }

    public static void main(String[] args) {
        MatrixPower matrixPower = new MatrixPower(15000);
        System.out.println(matrixPower.result.toString());
    }



}
