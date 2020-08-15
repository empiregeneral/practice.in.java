package cn.pintia.zjo.practice.problem1146;

import java.io.IOException;
import java.nio.CharBuffer;

public class LcDisplay implements Readable {
    private int count = 1;
    private int scale;
    private char[] digits;
    private char[][] out;
    private int row;
    private int col;

    public LcDisplay(int scale, char[] digits) {
        this.scale = scale;
        this.digits = digits;
        this.row = this.scale * 2 + 3;
        this.col = this.scale + 2;
        out = new char[this.row][this.col];
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

    }

    private void drawPartA(boolean draw, int xStart, int yStart) {

    }

    private void drawPartB(boolean draw, int xStart, int yStart) {

    }

    private void drawPartC(boolean draw, int xStart, int yStart) {

    }

    private void drawPartD(boolean draw, int xStart, int yStart) {

    }

    private void drawPartE(boolean draw, int xStart, int yStart) {

    }

    private void drawPartF(boolean draw, int xStart, int yStart) {

    }

    private void drawPartG(boolean draw, int xStart, int yStart) {

    }


    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }




        return 10;
    }
}
