package cn.pintia.zjo.practice.problem1002;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.List;

/**
 * @author Administrator
 */
public class Solution implements Readable{
    private int count = 1;
    private final char[][] board;
    private int answer;
    private final char empty = '.';

    public Solution(List<char[]> input) {
        board = input.toArray(new char[input.size()][]);
        answer = 0;
        solve(0, 0);
    }

    private void solve(int k, int count) {
        int x;
        int y;

        if (k == board.length * board.length) {
            if (count > answer) {
                answer = count;
                return;
            }
        } else {
            x = k / board.length;
            y = k % board.length;
            if (board[x][y] ==  empty && canPos(board, x, y)) {
                board[x][y] = 'O';
                solve(k+1, count+1);
                board[x][y] = '.';
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


        cb.append(answer + "\n");

        return 10;
    }
}
