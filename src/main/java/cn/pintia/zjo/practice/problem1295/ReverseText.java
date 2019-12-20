package cn.pintia.zjo.practice.problem1295;

import java.io.IOException;
import java.nio.CharBuffer;

public class ReverseText implements Readable{
    private String text;
    private char[] chars;
    private int count = 1;

    public ReverseText(String text) {
        this.text = text;
        this.chars = text.toCharArray();
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        for (int i = chars.length - 1; i >= 0; i--) {
            cb.append(text.charAt(i));
        }

        return 10;
    }
}
