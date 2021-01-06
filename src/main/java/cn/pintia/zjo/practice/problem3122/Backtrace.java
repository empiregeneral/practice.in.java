package cn.pintia.zjo.practice.problem3122;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Backtrace implements SudokuSolver {
    private int count = 1;
    private Board board;
    private Character[][] boardChars;
    private int n;

    public Backtrace(Cell[][] cells, int n) {
        boardChars = Board.getBoard(cells, n);
        this.n = n;

    }

    @Override
    public boolean solve(Character[][] board, int n) {
        int row = -1;
        int col = -1;
        char startChar = 'A';
        char endChar = 'P';
        boolean isEnd = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j].equals('-')) {
                    row = i;
                    col = j;

                    // We still have some remaining
                    // missing values in Sudoku
                    isEnd = false;
                    break;
                }
            }
            if (!isEnd) {
                break;
            }
        }

        // No empty space left
        if (isEnd) {
            return true;
        }

        for (char ch = startChar; ch < endChar; ch++) {
            if (Board.isValid(board, row, col, ch)) {
                board[row][col] = ch;
                if (solve(board, n)) {
                    return true;
                } else {
                    board[row][col] = '-';
                }
            }
        }
        return false;
    }

    @Override
    public void print(Character[][] board, int n) {
        // We got the answer, just print it
        for (int r = 0; r < n; r++)
        {
            for (int d = 0; d < n; d++)
            {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int)Math.sqrt(n) == 0)
            {
                System.out.print("");
            }
        }
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        solve(this.boardChars, this.n);

        CharSequence[] result = Stream.of(this.boardChars).map(arr -> Arrays.stream(arr).map
                (item -> item.toString()).collect(Collectors.joining())).toArray(String[]::new);

        for (CharSequence charSequence : result) {
            cb.append(charSequence + "\n");
        }

        return 0;
    }
}
