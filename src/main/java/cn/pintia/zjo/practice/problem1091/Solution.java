package cn.pintia.zjo.practice.problem1091;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.LinkedList;
import java.util.Queue;

public class Solution implements Readable {
    private int steps = 0;
    private int count = 1;

    private String start;
    private String end;

    private final int[][] knightMoves = {{1,2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
    private final int chessSize = 8;
    private Position[][] board = new Position[chessSize][chessSize];

    private Queue<Location> queue = new LinkedList<>();


    public Solution(String start, String end) {
        this.start = start;
        this.end = end;

        PositionInChess startPos = PositionInChess.transfer(start);
        PositionInChess endPos = PositionInChess.transfer(end);
        initIsVisitedInChess(board);
        BFS(board, startPos.getX(), startPos.getY(), endPos.getX(), endPos.getY());
    }

    private void initIsVisitedInChess(Position[][] board) {
        for (int r = 0; r < chessSize; r++) {
            for (int c = 0; c < chessSize; c++) {
                board[r][c] = new Position();
            }
        }
    }

    private void BFS(Position[][] board, int xStart, int yStart, int xEnd, int yEnd) {
        queue.add(new Location(xStart, yStart));
        while(!queue.isEmpty()) {
            Location location = queue.peek();
            int x = location.getRow();
            int y = location.getCol();
            queue.poll();

            if (x == xEnd && y == yEnd) {
                this.steps = board[x][y].steps;
                break;
            }
            board[x][y].isVisited = true;
            for (int i = 0; i < chessSize; i++) {
                if ( (x + knightMoves[i][0] >= 0 && x + knightMoves[i][0] < chessSize) &&
                        (y + knightMoves[i][1] >= 0 && y+ knightMoves[i][1] < chessSize) &&
                        !board[x+knightMoves[i][0]][y+knightMoves[i][1]].isVisited) {
                    queue.add(new Location(x + knightMoves[i][0], y + knightMoves[i][1]));
                    board[x + knightMoves[i][0]][y + knightMoves[i][1]].steps = board[x][y].steps + 1;
                }
            }
        }

    }



    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count <0 ) {
            return -1;
        }

        cb.append(String.format("To get from %s to %s takes %d knight moves.", new Object[]{start, end, steps}));

        return 10;
    }

    class Position {
        private boolean isVisited;
        private int steps;

        public Position() {
            isVisited = false;
            steps = 0;
        }
    }

    class Location {


        private int row;
        private int col;

        private Location(int row, int col) {
            this.row = row;
            this.col = col;

        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }
    }
}
