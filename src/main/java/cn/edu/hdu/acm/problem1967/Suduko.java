package cn.edu.hdu.acm.problem1967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Suduko {
    static int N = 9;
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        byte[][] src = new byte[N][N];

        for (int col = 0; col < N; col++) {
            String line = stdin.readLine();
            for (int row = 0; row < N; row++) {
               src[col][row] = Byte.parseByte(""+line.charAt(row));
            }
        }

        //Suduko.print(src, N);

        if (solveSudoku(src, N)) {
            print(src, N);
        }

        stdin.close();
    }

    public static boolean solveSudoku(
            byte[][] board, int n)
    {
        int row = -1;
        int col = -1;
        boolean isEnd = true;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] == 0)
                {
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

        System.out.println("Row: " + row + " Column: " + col);
        // Else for each-row backtrack
        for (int num = 1; num <= n; num++)
        {
            if (isSafe(board, row, col, num))
            {
                board[row][col] = (byte)num;
                if (solveSudoku(board, n))
                {
                    System.out.println("Row: " + row + " Column: " + col + " Num " + num);
//                    print(board, n);
//                    System.out.println();
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

    public static boolean isSafe(byte[][] board,
                                 int row, int col,
                                 int num) {

        // Row has the unique (row-clash)
        for (int d = 0; d < board.length; d++)
        {

            // Check if the number we are trying to
            // place is already present in
            // that row, return false;
            if (board[row][d] == num) {
                return false;
            }
        }

        // Column has the unique numbers (column-clash)
        for (int r = 0; r < board.length; r++)
        {

            // Check if the number
            // we are trying to
            // place is already present in
            // that column, return false;
            if (board[r][col] == num)
            {
                return false;
            }
        }

        // Corresponding square has
        // unique number (box-clash)

        int sqrt = (int)Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart;
             r < boxRowStart + sqrt; r++)
        {
            for (int d = boxColStart;
                 d < boxColStart + sqrt; d++)
            {
                if (board[r][d] == num)
                {
                    return false;
                }
            }
        }

        // if there is no clash, it's safe
        return true;
    }

    public static void print(
            byte[][] board, int N)
    {

        // We got the answer, just print it
        for (int r = 0; r < N; r++)
        {
            for (int d = 0; d < N; d++)
            {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int)Math.sqrt(N) == 0)
            {
                System.out.print("");
            }
        }
    }
}
