package cn.pintia.zjo.practice.problem1002;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.List;

/**
 * @author Administrator
 */
public class Solution implements Readable{
    private int count = 1;
    private char[][] board;
    private int answer = 0;
    private final char empty = '.';

    public Solution(List<char[]> input) {
        board = input.toArray(new char[input.size()][]);

    }

    private void solve(int k, int count) {
        int r;
        int c;

        if (k == board.length * board.length) {
            if (count > answer) {
                answer = count;
                return;
            }
        } else {
            r = k / board.length;
            c = k % board.length;
            if (board[r][c] == empty && canPos(board, r, c)) {
                board[r][c] = 'O';  // 放置碉堡
                solve(k+1, count+1); // 下一个位置
                board[r][c] = '.';  // 回溯
            }
            solve(k+1, count);
        }
    }

    private boolean canPos(char[][] board, int r, int c) {

        // 判断每列是否能放置碉堡
        for (int row = 0; row < r; row++) {
            if (board[row][c] == 'O') {
                return false;
            }

            if (board[row][c] == 'X') {
                break;
            }
        }

        // 判断每行是否能放置碉堡
        for (int col = 0; col < c; col++) {
            if (board[r][col] == 'O') {
                return false;
            }

            if (board[r][col] == 'X') {
                break;
            }
        }

        return true;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        solve(0, answer);
        cb.append(answer + "\n");

        return 10;
    }
}
