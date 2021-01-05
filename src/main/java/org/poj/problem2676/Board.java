package org.poj.problem2676;

import java.util.Arrays;

/**
 * @Author canmozhang
 * @Description 数独游戏的棋盘
 */
public class Board {
    private int N;
    private Byte[][] board ;

    private Board(Cell[][] cells, int N) {
        this.N = N;
        initBytes(cells);
    }

    public static Board getInstance(Cell[][] cells, int N) {
        return new Board(cells, N);
    }

    public static Byte[][] getBoard(Cell[][] cells, int N) {
        return getInstance(cells, N).board;
    }

    private void initBytes(Cell[][] cells) {
        board = Arrays.stream(cells).
                map(arr -> Arrays.stream(arr).
                        map(cell -> Byte.parseByte(""+cell.value.getToken())).
                        toArray(Byte[]::new)).toArray(Byte[][]::new);
    }

    public static boolean isValid(Byte[][] board, int row, int col, Byte num) {
        // Row has the unique
        for (int d = 0; d < board[0].length; d++) {
            if (board[row][d].equals(num)) {
                return false;
            }
        }

        // Column has the unique
        for (int r = 0; r < board.length; r++) {
            if (board[r][col].equals(num)) {
                return false;
            }
        }

        // Cell In box has the unique
        int sqrt = (int)Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int i = boxRowStart; i < boxRowStart + sqrt; i++) {
            for (int j = boxColStart; j < boxColStart + sqrt; j++) {
                if (board[i][j].equals(num)) {
                    return false;
                }
            }
        }

        return true;
    }
}
