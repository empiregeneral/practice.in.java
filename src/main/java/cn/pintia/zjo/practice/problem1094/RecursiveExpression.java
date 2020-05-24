package cn.pintia.zjo.practice.problem1094;

import java.io.IOException;
import java.nio.CharBuffer;

public class RecursiveExpression implements Readable {
    private String expression;
    private int count = 1;
    private int[] rows;
    private int[] columns;
    private int p;
    private boolean error;
    private char[] e;

    public RecursiveExpression(String expression) {
        this.expression = expression;
        this.rows = new int[100];
        this.columns = new int[100];
        this.p = 0;
        this.error = false;
        this.e  = new char[256];
    }



    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }
        return 10;
    }
}
