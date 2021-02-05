package org.poj.problem2676;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Administrator
 */
public class Backtrace implements SudokuSolver {
    private int count = 1;
    private Board board;
    private Byte[][] boardBytes;
    private int n;

    public Backtrace(Cell[][] cells, int n) {
        boardBytes = Board.getBoard(cells, n);
        this.n = n;
        solve(this.boardBytes, this.n);
    }


    @Override
    public boolean solve(Byte[][] board, int n) {
        int row = -1;
        int col = -1;
        boolean isEnd = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
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
        if (isEnd)
        {
            return true;
        }

        // Else for each-row backtrack
        for (byte num = 1; num <= n; num++)
        {
            if (Board.isValid(board, row, col, num))
            {
                board[row][col] = num;
                if (solve(board, n))
                {

                    return true;
                }
                else
                {
                    // replace it
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    @Override
    public void print(Byte[][] board, int n) {
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
        // System.out.println(solve(this.boardBytes, this.n));
        // print(this.boardBytes, this.n);


        CharSequence[] result = Stream.of(this.boardBytes).map(arr -> Arrays.stream(arr).
                map(item ->  item.toString()).
                collect(Collectors.joining())).toArray(String[]::new);

        for (CharSequence charSequence: result) {
            cb.append(charSequence+"\n");
        }

        return 10;
    }
}
