package cn.pintia.zjo.practice.problem1146;

import java.io.IOException;
import java.nio.CharBuffer;

public class LcDisplay implements Readable {
    public static boolean[][] lcd = {
            /* 0 */
            {true,  true, true, true, true, true, false},
            /* 1 */
            {false, true, true, false, false, false, false},
            /* 2 */
            {true, true, false, true, true, false, true},
            /* 3 */
            {true, true, true, true, false, false, true},
            /* 4 */
            {false, true, true, false, false, true, true},
            /* 5 */
            {true, false, true, true, false, true, true},
            /* 6 */
            {true, false, true, true, true, true, true},
            /* 7 */
            {true, true, true, false, false, false, false},
            /* 8 */
            {true, true, true, true, true, true, true},
            /* 9 */
            {true, true, true, true, false, true, true}
    };

    private int count = 1;
    private int scale;
    private int offset;
    private char[] digits;
    public char[][] out;
    private int row;
    private int col;

    public LcDisplay(int scale, char[] digits) {
        this.scale = scale;
        this.digits = digits;
        int len = digits.length;
        this.row = this.scale * 2 + 3;
        this.col = this.scale + 2;
        out = new char[this.row][len * (this.col + 1)];
        offset = this.col + 1;
        initCharArr(out);
    }

    private void initCharArr(char[][] charArr) {
        for (int i = 0; i < charArr.length; i++) {
            for (int j = 0; j < charArr[i].length; j++) {
                charArr[i][j] = ' ';
            }
        }
    }

    private void draw() {
        for (int i = 0; i < digits.length; i++) {
            boolean[] judge = LcDisplay.lcd[digits[i] - '0'];
            drawPartA(judge[0], 0, 1 + offset * i);
            drawPartB(judge[1], 1, 2 + offset * i);
            drawPartC(judge[2], 3, 2 + offset * i);
            drawPartD(judge[3], 4, 1 + offset * i);
            drawPartE(judge[4], 3, 0 + offset * i);
            drawPartF(judge[5], 1, 0 + offset * i);
            drawPartG(judge[6], 2, 1 + offset * i);
        }

    }

    private void drawPartA(boolean draw, int xStart, int yStart) {
        if (draw) {
            for (int i = 1; i <= scale; i++) {
                out[xStart][yStart++] = '-';
            }
        }
    }

    private void drawPartB(boolean draw, int xStart, int yStart) {
        if (draw) {
            int yPos = yStart + scale - 1;
            for (int i = 1; i <= scale; i++) {
                out[xStart++][yPos] = '|';
            }
        }
    }

    private void drawPartC(boolean draw, int xStart, int yStart) {
        if (draw) {
            int yPos = yStart + scale - 1;
            int xPos = xStart + scale - 1;
            for (int i = 1; i <= scale; i++) {
                out[xPos++][yPos] = '|';
            }
        }
    }

    private void drawPartD(boolean draw, int xStart, int yStart) {
        if (draw) {
            int xPos = row;
            int yPos = yStart;
            for ( int i = 1; i <= scale; i++ ) {
                out[xPos - 1][yPos++] = '-';
            }

        }
    }

    private void drawPartE(boolean draw, int xStart, int yStart) {
        if (draw) {
            int xPos = xStart + scale - 1;
            int yPos = yStart;
            for (int i = 1; i <= scale; i++) {
                out[xPos++][yPos] = '|';
            }
        }
    }

    private void drawPartF(boolean draw, int xStart, int yStart) {
        if (draw) {
            int xPos = xStart;
            int yPos = yStart;
            for (int i = 1; i <= scale; i++) {
                out[xPos++][yPos] = '|';
            }
        }
    }

    private void drawPartG(boolean draw, int xStart, int yStart) {
        if (draw) {
            int xPos = xStart + scale - 1;
            for (int i = 1; i <= scale; i++) {
                out[xPos][yStart++] = '-';
            }
        }
    }

    public static void Display(int scale, char[] digits) {
        LcDisplay lcDisplay = new LcDisplay(scale, digits);
        lcDisplay.draw();
        char[][] out = lcDisplay.out;
        for (int r = 0; r < out.length; r++) {
            String line = String.valueOf(out[r]);
            System.out.println(line.replaceFirst("\\s$", ""));
        }
        System.out.println();
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        draw();

        for (int r = 0; r < out.length; r++) {
            cb.append(String.valueOf(out[r]));
            cb.append("\n");
        }

        return 10;
    }
}
