package cn.pintia.zjo.practice.problem1975;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

/**
 * @Description
 * @author canmozhang
 */
public class DrawSierpinskiFractal implements Readable {
    private int count = 1;
    private int n;
    private char[][] out;
    private int xlen;
    private int ylen;

    public DrawSierpinskiFractal(int n) {
        this.n = n;
        xlen = 1 << n;
        ylen = 2 * xlen;
        this.out = new char[xlen][ylen];
        initChar2DArr(out, xlen, ylen);
    }

    private void initChar2DArr(char[][] out, int xlen, int ylen) {
        for (int i = 0; i < xlen; i++) {
            for (int j = 0; j < ylen; j++) {
                out[i][j] = ' ';
            }
        }
    }


    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        DrawSierpinskiFractal.draw(n, out, xlen - 1, 0);
        for (int i = 0; i < out.length; i++) {
            for (int j = out[0].length - 1; j >=0; j--) {
                if (out[i][j] != ' ') {
                    CharSequence cq = String.valueOf(out[i], 0, j+1);
                    if (n < 5) {
                        cb.append( cq + "\n");
                    } else {
                        System.out.println(cq);
                    }
                    break;
                }
            }
        }
        return 10;
    }

    public static void draw(int n, char[][] out, int x, int y) {
        if (n == 1) {
            out[x][y] = out[x - 1][y + 1] = '/';
            out[x][y + 1] = out[x][y + 2] = '_';
            out[x][y + 3] = out[x - 1][y + 2] = '\\';
            return;
        }
        int ofs = 1 << (n - 1);
        draw(n - 1, out, x, y);
        draw(n - 1, out, x, y + 2 * ofs);
        draw(n - 1, out, x - ofs, y + ofs);
    }

    public static void main(String[] args) {
        int n = 4;
        Scanner output = new Scanner(new DrawSierpinskiFractal(n));
        while(output.hasNextLine()) {
            System.out.println(output.nextLine());
        }
    }

}
