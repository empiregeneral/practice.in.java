package cn.pintia.zjo.practice.problem1002;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 */
public class Solution implements Readable{
    private int count = 1;
    private final char[][] board;
    private int answer = 0;
    private final char empty = '.';
    private final char block = 'X';

    private final char pos = 'O';

    private boolean isDebug = false;

    public Solution(List<char[]> input) {
        board = input.toArray(new char[input.size()][]);
        solve(0, 0);
    }

    public Solution(List<char[]> input, boolean isDebug) {
        isDebug = isDebug;
        board = input.toArray(new char[input.size()][]);
        solve(0, 0);
    }

    private void solve(int k, int count) {
        int x;
        int y;

        debugInfo(board);
        if (k == board.length * board.length) {
            answer = (answer > count) ? answer : count;
            debugInfo(board);
        } else {
            x = k / board.length;
            y = k % board.length;
            if ((board[x][y] == empty) && canPos(board, x, y)) {
                board[x][y] = pos;
                solve(k + 1, count+1);
                board[x][y] = empty;
            }
            debugInfo(board);
            solve(k+1, count);
        }
    }

    private boolean canPos(char[][] board, int r, int c) {

        if (board[r][c] == block) {
            return false;
        }

        for ( int col = c - 1; col >= 0; col--) {
            if (board[r][col] == block) {
                break;
            }
            if (board[r][col] == pos) {
                return false;
            }
        }

        for ( int row = r -1; row >= 0;  row--) {
            if (board[row][c] == block) {
                break;
            }
            if (board[row][c] == pos) {
                return false;
            }
        }

        return true;
    }

    private void debugInfo(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println();
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
