package cn.pintia.zjo.practice.problem1095;

import java.io.IOException;
import java.nio.CharBuffer;

public class FindHumbleNumber implements Readable {
    private int count = 1;
    private Generate generate;
    private int index;
    private int[] humbleNumbers;

    public FindHumbleNumber(int key) {
        this.generate = new HumbleNumberGenerate(key);
        this.index = key - 1;
        humbleNumbers = generate.createTable();
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        cb.append("" + humbleNumbers[index]);
        cb.append("");

        return 10;
    }
}
