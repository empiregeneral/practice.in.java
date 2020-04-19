package cn.pintia.zjo.practice.problem1733;

import java.io.IOException;
import java.nio.CharBuffer;

public class CommonSubsequence implements FindCommonSubsequence, Readable{
    private int count = 1;
    private CharSequence one;
    private CharSequence two;
    private int[][] dp;
    private int row;
    private int column;

    public CommonSubsequence(CharSequence one, CharSequence two) {
        this.one = one;
        this.two = two;
        row = one.length()+1;
        column = two.length()+1;
        dp= new int[row][column];
        initMatrixInZero();
    }

    private void initMatrixInZero() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                dp[i][j] = 0;
            }
        }
    }

    private void dp() {
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (one.charAt(i-1) == two.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = (dp[i-1][j] > dp[i][j-1] ? dp[i-1][j] : dp[i][j-1]);
                }
            }
        }
    }

    @Override
    public Readable getResult() {
        return this;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        dp();
        cb.append("" + dp[row-1][column-1]);
        return 10;
    }
}
