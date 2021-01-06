package cn.pintia.zjo.practice.problem3122;

import java.util.Arrays;

public class Board {
    private final int N;
    private Character[][] board;

    private Board(Cell[][] cells, int N) {
        this.N = N;
        initChars(cells);
    }

    private void initChars(Cell[][] cells) {
        board = Arrays.stream(cells).map(arr -> Arrays.stream(arr).
                map(cell -> cell.value.getToken()).toArray(Character[]::new)).toArray(Character[][]::new);
    }

    public static Board getInstance(Cell[][] cells, int N) {
        return new Board(cells, N);
    }

    public static Character[][] getBoard(Cell[][] cells, int N) {
        return new Board(cells, N).board;
    }

    public static boolean isValid(Character[][] board, int row, int col, Character alphabet) {
        for (int d = 0; d < board.length; d++) {
            if (board[row][d].equals(alphabet)) {
                return false;
            }
        }

        for (int r = 0; r < board.length; r++) {
            if (board[r][col].equals(alphabet)) {
                return false;
            }
        }

        int sqrt = (int)Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;
        for (int i = boxRowStart; i < boxRowStart + sqrt;i++) {
            for (int j = boxColStart; j < boxColStart + sqrt; j++) {
                if (board[i][j].equals(alphabet)) {
                    return false;
                }
            }
        }

        return true;
    }



}
